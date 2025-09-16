package Chapter01.Homework;

public class createTalkingStudent {
    public static void main(String[] args) {
        Student student = new Student("Tom", 20, "Mathematics");
        student.introduce();
    }
}

class Student {
    String name;
    int age;
    String course;

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void introduce() {
        System.out.println("Hello, my name is " + name + ". I am " + age + " years old and I am studying " + course + ".");
    }
}
