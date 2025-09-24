package Chapter03;

public class DoWhilePractice {
    public static void main(String[] args) {
        int n=10;
        for(int i=1;i<=n;i++){
            System.out.println(i);
        }
        int j=11;
        while(j<=n){
            System.out.println(j);
            j++;
        }
        int k=10;
        do{
            System.out.println(k);
            k++;
        }while(k<=n);
    }
}
