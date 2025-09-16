package Chapter01.Exercises;

class SampleClass {
    public int counter = 1;

    void Display(){
        System.out.println("Counter: " + counter);
    }

    public static void main(String[] args) {
        SampleClass obj = new SampleClass();
        obj.Display();
    }
}
