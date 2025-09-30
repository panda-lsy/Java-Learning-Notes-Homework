package Chapter04;

public class StringDemo {
    public static void main(String[] args) {
        String s1="Hello";
        System.out.println(s1);
        System.out.println("Memory Address before:"+System.identityHashCode(s1));
        s1=s1+"World";
        System.out.println(s1);
        System.out.println("Memory Address after updating s1:"+System.identityHashCode(s1));
        s1="Hello";
        System.out.println(s1);
        System.out.println("Memory Address after updating s1:"+System.identityHashCode(s1));

        StringBuilder word = new StringBuilder("Hello");
        word.append(" World");
        System.out.println(word.length());
        char ch = word.charAt(2);
        System.out.println(ch+word.substring(1,3));


    }
}
