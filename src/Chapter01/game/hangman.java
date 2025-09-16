package Chapter01.game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class hangman {

    public void showMenu(){
        int option;
        Scanner input = new Scanner(System.in);
        System.out.println("**************************");
        System.out.println("******* 1.开始游戏 *******");
        System.out.println("******* 2.游戏说明 *******");
        System.out.println("******* 3.退出游戏 *******");
        System.out.println("**************************");
        System.out.println("请输入你的选择：");
        option = input.nextInt();
        if(option==1){
            hangMan();
        }
        else if(option==2){
            System.out.println("游戏说明：");
            System.out.println("1. 游戏会随机选择一个单词，你需要通过猜字母来找出这个单词。");
            System.out.println("2. 每次只能猜一个字母，如果猜对了，字母会显示在单词的正确位置上；如果猜错了，你会失去一次机会。");
            System.out.println("3. 你有6次机会来猜错字母，如果在机会用完之前猜出整个单词，你就赢了！");
            System.out.println("4. 如果你用完了所有机会还没有猜出单词，游戏就结束了。");
            System.out.println("祝你好运！");
            showMenu();
        }
        else if(option==3){
            System.out.println("感谢你的使用，再见！");
        }
        else{
            System.out.println("输入错误，请重新输入！");
            showMenu();
        }
    }

    public void hangMan() {
        System.out.println("欢迎来到猜单词游戏！");
        ArrayList<String> words = new ArrayList<String>();
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("grape");
        words.add("pear");
        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));
        char[] guessed = new char[word.length()];
        for (int i = 0; i < guessed.length; i++) {
            guessed[i] = '_';
        }
        int chances = 6;
        Scanner input = new Scanner(System.in);
        while (chances > 0) {
            System.out.println("当前单词：" + String.valueOf(guessed));
            System.out.println("你还有" + chances + "次机会。");
            System.out.println("请输入你猜的字母：");
            char guess = input.next().charAt(0);
            boolean correct = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessed[i] = guess;
                    correct = true;
                }
            }
                if (!correct) {
                    chances--;
                    System.out.println("猜错了！");
                } else {
                    System.out.println("猜对了！");
                }
                if (String.valueOf(guessed).equals(word)) {
                    System.out.println("恭喜你，猜出了单词：" + word);
                    break;
                }
            if (chances == 0) {
                System.out.println("很遗憾，你没有猜出单词，正确的单词是：" + word);
            }
        }
    }
    public static void main(String[] args) {

        hangman game = new hangman();
        game.showMenu();

    }
}
