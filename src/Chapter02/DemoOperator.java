package Chapter02;
public class DemoOperator {
    public static void main(String[] args) {
        int a = 20;
        int b = 3;

        //Demo asssignment operator.
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);

        // Demo comparison operators.
        int x=10;
        int y=5;
        boolean result=x>y;
        System.out.println(result);
        result=x<y;
        System.out.println(result);
        result=x>=y;
        System.out.println(result);
        result=x<=y;
        System.out.println(result);
        result=x!=y;
        System.out.println(result);

        //== operator
        int c=10;
        int d=10;


        //!= operator
        int e=20;
        int f=30;



        //Demo Logical Operators
        int g=25;
        int h=20;
        int i=30;
        result=g>h && g<i; //true && true =true
        System.out.println("Logical AND Operator: "+result);


        //Demo instanceof Operator
        DemoOperator dp=new DemoOperator();//object creation


        //Demo unary operator
        //Pre-increment ++a1
        int a1=2;

        //post increment


        //Pre Decrement
        int a3=5;



        //Post Decrement



        //Ternary Operator..Greatest number among n1 and n2
        int n1=10;
        int n2=20;


        //Directly Using Boolean value in Ternary operator.

        //order of Precedence.
        double answer1=2*5+3;
        System.out.println(answer1);
        //Overriding operator precedence.
        double answer2=2*(5+3);
        System.out.println(answer2);


    }
}
