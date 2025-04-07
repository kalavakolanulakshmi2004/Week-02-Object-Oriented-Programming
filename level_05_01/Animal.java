import java.util.Scanner;
public class Animal {
    protected String name;
    protected int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Dog details (name, age): ");
        String dname = scanner.next();
        int dage = scanner.nextInt();
        Animal dog = new Dog(dname, dage);
        System.out.print("Enter Cat details (name, age): ");
        String cname = scanner.next();
        int cage = scanner.nextInt();
        Animal cat = new Cat(cname, cage);
        System.out.print("Enter Bird details (name, age): ");
        String bname = scanner.next();
        int bage = scanner.nextInt();
        Animal bird = new Bird(bname, bage);
        System.out.println("\nAnimal Details:");
        Animal[] animals = {dog, cat, bird};
        for (Animal a : animals) {
            a.makeSound();
            System.out.println(" ");
        }
    }
}
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println("Chirp! Chirp!");
    }
}
