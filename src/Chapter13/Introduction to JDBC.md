# JDBC 笔记速查（Introduction to JDBC）

- 核心组件
  - Driver/DriverManager 或 DataSource（推荐连接池）
  - Connection
  - Statement / PreparedStatement / CallableStatement
  - ResultSet
  - SQLException（链式异常）

## 依赖与驱动

- JDBC 4.0+ 无需显式 Class.forName，确保正确依赖即可
- 常用 Maven 依赖
  - MySQL: mysql:mysql-connector-j
  - PostgreSQL: org.postgresql:postgresql
  - SQL Server: com.microsoft.sqlserver:mssql-jdbc
  - H2(学习/测试): com.h2database:h2

示例（MySQL 与 H2）

```xml
<dependencies>
    <dependency>
        <groupId>mysql</groupId><artifactId>mysql-connector-j</artifactId><version>8.4.0</version>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId><artifactId>h2</artifactId><version>2.3.232</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 连接 URL 速记

- MySQL: jdbc:mysql://host:3306/db?useSSL=false&serverTimezone=UTC&characterEncoding=utf8
- PostgreSQL: jdbc:postgresql://host:5432/db
- SQL Server: jdbc:sqlserver://host:1433;databaseName=db;encrypt=true;trustServerCertificate=true
- H2(内存): jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_DELAY=-1

## 基本流程（try-with-resources）

```java
String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
try (Connection conn = DriverManager.getConnection(url, "sa", "");
         PreparedStatement ps = conn.prepareStatement(
                "SELECT id, name FROM t_user WHERE status = ?")) {
    ps.setString(1, "ACTIVE");
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
        }
    }
} catch (SQLException e) {
    // e.getSQLState(), e.getErrorCode(), e.getNextException()
}
```

要点

- 总是使用 PreparedStatement，避免 SQL 注入与重复编译
- 资源关闭顺序：ResultSet -> Statement -> Connection（try-with-resources 自动完成）

## 写操作与生成主键

```java
String sql = "INSERT INTO t_user(name, status) VALUES (?, ?)";
try (Connection c = ds.getConnection();
         PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    ps.setString(1, "Alice");
    ps.setString(2, "ACTIVE");
    int updated = ps.executeUpdate();
    try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) {
            long id = keys.getLong(1);
        }
    }
}
```

## 事务管理

```java
try (Connection c = ds.getConnection()) {
    c.setAutoCommit(false);
    c.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    // ... 多条 SQL
    c.commit();
} catch (SQLException e) {
    // 发生异常时回滚
}
```

- Savepoint

```java
Savepoint sp = c.setSavepoint();
try { /* ... */ } catch (SQLException ex) { c.rollback(sp); }
```

- 常见隔离级别：READ_UNCOMMITTED < READ_COMMITTED < REPEATABLE_READ < SERIALIZABLE

## 批处理

```java
String sql = "INSERT INTO t_user(name, status) VALUES(?, ?)";
try (Connection c = ds.getConnection();
         PreparedStatement ps = c.prepareStatement(sql)) {
    c.setAutoCommit(false);
    for (var u : users) {
        ps.setString(1, u.getName());
        ps.setString(2, u.getStatus());
        ps.addBatch();
    }
    int[] counts = ps.executeBatch();
    c.commit();
}
```

- MySQL 可加 rewriteBatchedStatements=true 提升性能

## ResultSet 与游标

- 类型：TYPE_FORWARD_ONLY（默认，最快）、TYPE_SCROLL_INSENSITIVE、TYPE_SCROLL_SENSITIVE
- 并发：CONCUR_READ_ONLY、CONCUR_UPDATABLE
- 大结果集/流式
  - PostgreSQL: ps.setFetchSize(n)
  - MySQL: stmt.setFetchSize(Integer.MIN_VALUE) 并在 URL 加 useCursorFetch=true（驱动不同略有差异）
- 访问空值：rs.wasNull() 判断 getXxx 后是否为 NULL

## 元数据

```java
DatabaseMetaData meta = conn.getMetaData();
try (ResultSet rs = meta.getTables(null, null, "%", new String[]{"TABLE"})) { /* ... */ }

try (ResultSet rs = ps.executeQuery()) {
    ResultSetMetaData rsmd = rs.getMetaData();
    int cols = rsmd.getColumnCount();
}
```

## 大对象与流

```java
// 写入 BLOB
ps.setBinaryStream(1, new FileInputStream(file), file.length());

// 读取 BLOB
try (InputStream in = rs.getBinaryStream("data")) { /* copy */ }

// CLOB
ps.setCharacterStream(1, reader, length);
```

## 日期与时间（推荐 java.time）

```java
ps.setObject(1, java.time.LocalDateTime.now());
LocalDateTime ts = rs.getObject("created_at", LocalDateTime.class);
```

- 注意时区：MySQL 配置 serverTimezone=UTC，应用使用 UTC 存储

## 连接池（HikariCP 示例）

Maven:

```xml
<dependency>
    <groupId>com.zaxxer</groupId><artifactId>HikariCP</artifactId><version>5.1.0</version>
</dependency>
```

配置与使用：

```java
HikariConfig cfg = new HikariConfig();
cfg.setJdbcUrl("jdbc:mysql://localhost:3306/app?useSSL=false&serverTimezone=UTC");
cfg.setUsername("app"); cfg.setPassword("secret");
cfg.setMaximumPoolSize(10);
cfg.setMinimumIdle(2);
cfg.setConnectionTimeout(10000);
DataSource ds = new HikariDataSource(cfg);

try (Connection c = ds.getConnection()) { /* ... */ }
```

## 安全与健壮性

- 永远使用 PreparedStatement，禁止字符串拼接参数
- 最小权限账号，限制 DML/DDL
- 不在日志中记录敏感参数
- 处理 SQLException 链：while ((e = e.getNextException()) != null) {...}

## 常见问题

- 驱动未找到：检查依赖与类路径
- 字符集乱码：useUnicode=true&characterEncoding=utf8
- 时区错误：serverTimezone=UTC
- 自动提交导致半成功：显式事务包裹
- N+1 查询：批量操作或联表

## 代码结构建议

- DAO/Repository 模式，封装 CRUD
- 统一工具类封装 DataSource、事务、异常翻译
- 使用映射器方法将 ResultSet 转换为实体，避免在业务层直接操作 JDBC

示例 DAO 片段

```java
public Optional<User> findById(DataSource ds, long id) throws SQLException {
    String sql = "SELECT id, name, status FROM t_user WHERE id = ?";
    try (Connection c = ds.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
        ps.setLong(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                User u = new User(rs.getLong("id"), rs.getString("name"), rs.getString("status"));
                return Optional.of(u);
            }
            return Optional.empty();
        }
    }
}
```

## 调试与日志

- 启用 SQL 日志（注意脱敏），或使用代理数据源
- 捕捉 SQLState 与 errorCode 定位数据库端错误
- 对慢 SQL 打印耗时与执行计划（EXPLAIN）

结论

- JDBC 核心在于：正确的资源管理、参数化查询、事务控制、连接池与驱动细节
- 从简单 DriverManager 过渡到 DataSource + 连接池，分层设计更健壮

- 优先考虑批处理、流式读取与索引优化以提升性能
## Statement 执行 SQL

- 适用：临时脚本、DDL 或不含外部输入的固定 SQL
- 风险：易受 SQL 注入，生产代码优先使用 PreparedStatement

基本用法

```java
try (Connection c = ds.getConnection();
    Statement st = c.createStatement()) {

    // 查询（只读）
    try (ResultSet rs = st.executeQuery(
          "SELECT id, name FROM t_user WHERE status = 'ACTIVE'")) {
       while (rs.next()) {
          long id = rs.getLong(1);
          String name = rs.getString(2);
       }
    }

    // DML/DDL（返回影响行数，DDL 通常为 0）
    int updated = st.executeUpdate(
          "UPDATE t_user SET status = 'DISABLED' WHERE status = 'ACTIVE'");
    st.executeUpdate("CREATE INDEX IF NOT EXISTS idx_user_status ON t_user(status)");
}
```

execute 三态 API（处理可能返回结果集或更新计数）

```java
try (Connection c = ds.getConnection();
    Statement st = c.createStatement()) {

    boolean hasResult = st.execute("UPDATE t_user SET status='ACTIVE' WHERE id < 100");
    while (true) {
       if (hasResult) {
          try (ResultSet rs = st.getResultSet()) {
             while (rs.next()) { /* 处理结果集 */ }
          }
       } else {
          int count = st.getUpdateCount();
          if (count == -1) break; // 无更多结果
          // 处理 count
       }
       hasResult = st.getMoreResults();
    }
}
```

返回生成主键

```java
try (Connection c = ds.getConnection();
    Statement st = c.createStatement()) {

    int n = st.executeUpdate(
          "INSERT INTO t_user(name, status) VALUES ('Bob','ACTIVE')",
          Statement.RETURN_GENERATED_KEYS);

    try (ResultSet keys = st.getGeneratedKeys()) {
       if (keys.next()) {
          long id = keys.getLong(1);
       }
    }
}
```

批处理（不含外部输入时使用）

```java
try (Connection c = ds.getConnection();
    Statement st = c.createStatement()) {

    c.setAutoCommit(false);
    st.addBatch("INSERT INTO t_user(name, status) VALUES ('A','ACTIVE')");
    st.addBatch("UPDATE t_user SET status='DISABLED' WHERE id = 10");
    int[] counts = st.executeBatch();
    c.commit();
}
```

可选配置

- 创建：createStatement(type, concurrency[, holdability])
- 游标/性能：setFetchSize(n), setMaxRows(n), setQueryTimeout(seconds)
- 大计数：executeLargeUpdate 可返回 long

提示

- 禁止拼接外部输入；一旦有参数，改用 PreparedStatement
- 多语句执行与分号支持取决于驱动与数据库配置
- 依旧使用 try-with-resources 确保 Statement/ResultSet 关闭