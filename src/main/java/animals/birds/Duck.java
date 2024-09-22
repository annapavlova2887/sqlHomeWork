package animals.birds;
import objects.Animal;

public class Duck extends Animal implements Flying {

    public Duck(String type, String name, String color, int weight, int age) {
        super(type, name, color, weight, age);
    }

    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }

}
