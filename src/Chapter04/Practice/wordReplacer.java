package Chapter04.Practice;

import java.util.Scanner;

public class wordReplacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Sentence:");
        String sentence = sc.nextLine();
        System.out.println("Input Word:");
        String word = sc.nextLine();
        System.out.println("Input Word to replace:");
        String replace = sc.nextLine();
        sentence=sentence.replaceAll(word,replace);
        System.out.println("New sentence:"+sentence);
    }
}
