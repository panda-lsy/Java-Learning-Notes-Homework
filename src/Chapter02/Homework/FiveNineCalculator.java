package Chapter02.Homework;

public class FiveNineCalculator {
    public static void main(String[] args) {
        int a = 5;
        int b = 9;
        int andResult = a & b;
        System.out.println("5 & 9 = " + andResult);
        int orResult = a | b;
        System.out.println("5 | 9 = " + orResult);
        int notAResult = ~a;
        System.out.println("~5 = " + notAResult);
        int notBResult = ~b;
        System.out.println("~9 = " + notBResult);
        int xorResult = a ^ b;
        System.out.println("5 ^ 9 = " + xorResult);
    }
}
