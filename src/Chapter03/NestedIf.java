package Chapter03;

public class NestedIf {
    public static void main(String[] args) {
        int age = 20;
        boolean hasDrivingLicense = true;
        if (age >= 18) {
            if (hasDrivingLicense) {
                System.out.println("You are eligible to drive.");
            } else {
                System.out.println("You need a driving license to drive.");
            }
        } else {
            System.out.println("You are not eligible to drive.");
        }
    }
}
