package Chapter05.Assignment;

import java.util.Scanner;

abstract class Book {
    String authorName, bookName;
    double price;
    int stock, page;

    protected abstract String extraInfo();

    public Book(String authorName, String bookName, int page, double price, int stock) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.page = page;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("书名: ").append(bookName)
                .append("\n作者: ").append(authorName)
                .append("\n页数: ").append(page)
                .append("\n价格: ").append(price)
                .append("\n库存: ").append(stock);
        String extra = extraInfo();
        if (extra != null && !extra.isEmpty()) {
            sb.append("\n").append(extra);
        }
        return sb.toString();
    }

    static class SoftwareBook extends Book {
        String softwareVersion, softwareName;

        public SoftwareBook(String softwareName, String softwareVersion, String authorName, String bookName, double price, int stock, int page) {
            super(authorName, bookName, page, price, stock);
            this.softwareName = softwareName;
            this.softwareVersion = softwareVersion;
        }

        @Override
        protected String extraInfo() {
            return "软件名称: " + softwareName + "\n软件版本: " + softwareVersion;
        }
    }

    static class HardwareBook extends Book {
        String hardwareCategory, publisher;

        public HardwareBook(String authorName, String bookName, double price, int stock, int page, String hardwareCategory, String publisher) {
            super(authorName, bookName, page, price, stock);
            this.hardwareCategory = hardwareCategory;
            this.publisher = publisher;
        }

        @Override
        protected String extraInfo() {
            return "硬件类别: " + hardwareCategory + "\n出版社: " + publisher;
        }
    }

    private static CommonInput readCommon(Scanner sc) {
        CommonInput ci = new CommonInput();
        System.out.print("请输入作者: ");
        ci.authorName = sc.nextLine().trim();
        System.out.print("请输入书名: ");
        ci.bookName = sc.nextLine().trim();
        System.out.print("请输入页数(整数): ");
        ci.page = readInt(sc);
        System.out.print("请输入价格(数字): ");
        ci.price = readDouble(sc);
        System.out.print("请输入库存(整数): ");
        ci.stock = readInt(sc);
        return ci;
    }

    private static int readInt(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("格式错误，请输入整数: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("格式错误，请输入数字: ");
            }
        }
    }

    private static class CommonInput {
        String authorName, bookName;
        int page, stock;
        double price;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请选择图书类别(1-软件类, 2-硬件类): ");
        int choice = readInt(sc);

        CommonInput ci = readCommon(sc);
        Book book;

        if (choice == 1) {
            System.out.print("请输入软件名称: ");
            String sname = sc.nextLine().trim();
            System.out.print("请输入软件版本: ");
            String sver = sc.nextLine().trim();
            book = new SoftwareBook(sname, sver, ci.authorName, ci.bookName, ci.price, ci.stock, ci.page);
        } else if (choice == 2) {
            System.out.print("请输入硬件类别: ");
            String hcat = sc.nextLine().trim();
            System.out.print("请输入出版社: ");
            String pub = sc.nextLine().trim();
            book = new HardwareBook(ci.authorName, ci.bookName, ci.price, ci.stock, ci.page, hcat, pub);
        } else {
            System.out.println("无效选择，程序结束。");
            return;
        }

        System.out.println("\n已录入的图书信息如下：");
        System.out.println(book); // 复用父类的展示逻辑
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        Book.main(args);
    }
}