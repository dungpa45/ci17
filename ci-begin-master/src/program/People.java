package program;

public class People {
    String name; // non-static : dc tao moi kem theo doi tuong
    int age; //non-static : dc tao moi kem theo doi tuong
    static int count; //static tao ra kem theo class

    public People() {
        count++;
        name = "New person";
        age = 20;
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public void walk() {
        System.out.println(name + " is walking around...");
    }

    public static void main(String[] args) {
        People person1 = new People("john",20);
        System.out.println(person1.name);
    }
}

class Student extends People{
    double average;
    public  Student(String name, int age){
        super(name,age);//ham tao : this.name= .... this.age = ....

    }
}