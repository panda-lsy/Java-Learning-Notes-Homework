package Chapter02.Practice;

public class SwappingTwoNumbers_on_theBoard {
    static int A = 10;
    static int B = 20;
    static void SwapNum(){
        A = A + B;
        B = A - B;
        A = A - B;
    };
    public static void main(String[] args) {
        System.out.println("A: " + A);
        System.out.println("B: " + B);
        SwapNum();
        System.out.println("A: " + A);
        System.out.println("B: " + B);
    }
}
