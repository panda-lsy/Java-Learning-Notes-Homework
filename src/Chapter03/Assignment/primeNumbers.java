package Chapter03.Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class primeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number:");
        int n = sc.nextInt();
        int list [] = new int[n];
        int count = 0;
        if (n<1){
            System.out.println("None");
        } else if (n==1) {
            System.out.println("1");
        }else{
            boolean[] isComposite = new boolean[n + 1];
            for (int i = 2; i * i <= n; i++) {
                if (!isComposite[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isComposite[j] = true;
                    }
                }
            }
            count = 0;
            for (int i = 2; i <= n; i++) {
                if (isComposite[i]) {
                    list[count++] = i;
                }
            }
        //System.out.println(Arrays.toString(list));
        int count1=0;
        for (int i=2;i<=n;i++){
            if (i>list[count1]){
                break;
            }else if (i<list[count1]){
                System.out.print(i  );
            } else if (i==list[count1]) {
                count1+=1;
            }
        }
        }
    }
}
