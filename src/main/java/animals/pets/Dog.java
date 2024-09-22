package animals.pets;
import objects.Animal;

public class Dog extends Animal {
    public Dog(String type, String name, String color, int weight, int age) {
        super(type, name, color, weight, age);
    }

    @Override
    public void say() {
        System.out.println("Гав");
    }
}