package Chapter04;

enum fruits{
    mango(10);


private int price;
fruits(int p){
    this.price = p;
}

public int getPrice(){
    return price;
}
}

public class EnumDemo {
    public static void main(String[] args) {
        fruits f1 = fruits.mango;
        System.out.println(f1);
        System.out.println(f1.getPrice());
    }
}
