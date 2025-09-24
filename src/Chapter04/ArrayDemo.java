package Chapter04;

public class ArrayDemo {
    public static void main(String[] args) {
        //创建一个数组
        String [] names=new String[3];
        //另一种方法
        String [] name1={"Alice","Bob","Charlie"};
        //赋值
        names[0]="Alice";
        names[1]="Bob";
        names[2]="Charlie";
        //输出
        System.out.println(names[0]);
        //使用 for 循环遍历数组
        for(int i=0;i<names.length;i++) {
            System.out.println(names[i]);
        }
        //使用增强 for 循环
        for(String s: names){
            System.out.println(s);
        }
    }
}
