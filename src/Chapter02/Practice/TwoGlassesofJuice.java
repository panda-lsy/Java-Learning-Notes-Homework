package Chapter02.Practice;

public class TwoGlassesofJuice {
    public static void main(String[] args) {
        int GlassX = 250;
        int GlassY = 500;
        System.out.println("Glass X: " + GlassX + " ml");
        System.out.println("Glass Y: " + GlassY + " ml");
        int EmptyGlass = 0;
        EmptyGlass = GlassX;
        GlassX = GlassY;
        GlassY = EmptyGlass;
        System.out.println("Glass X: " + GlassX + " ml");
        System.out.println("Glass Y: " + GlassY + " ml");
    }
}
