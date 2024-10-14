package factory;
import objects.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.ListOfAnimals;

public class AnimalFactory {

    private String name, color;
    private int weight, age;

    public AnimalFactory(String name, String color, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Animal create(ListOfAnimals animalData) {
        switch (animalData) {
            case CAT: {
                return new Cat(name, color, weight, age);
            }
            case DOG: {
                return new Dog(name, color, weight, age);
            }
            case DUCK: {
                return new Duck(name, color, weight, age);
            }
        }

        return null;
    }
}
