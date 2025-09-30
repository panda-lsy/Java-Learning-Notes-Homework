package Chapter03.Assignment;

import java.util.Scanner;

public class identifyChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String character = sc.next();
        character = character.toUpperCase();
        if (character.equals("A") || character.equals("E") || character.equals("I") || character.equals("O") || character.equals("U")){
            System.out.println("Vowel");
        }else if(character.length()==1){
            System.out.println("Consonant");
        }else{
            System.out.println("Invalid Character!");
        }
    }
}
