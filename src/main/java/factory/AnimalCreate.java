package factory;
import data.ListOfAnimals;
import objects.Animal;
import utils.ValidateNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalCreate {
    public static  Animal createAnimalWithData() {

        ValidateNumber validateNumber = new ValidateNumber();
        Scanner console2 = new Scanner(System.in);

        boolean chekAninal = false;
        ListOfAnimals animal = null;
        String animalType=null;

        List<String> listOfAnimalsNames = new ArrayList<>();
        for (ListOfAnimals listOfAnimalsData: ListOfAnimals.values()) {
            listOfAnimalsNames.add(listOfAnimalsData.name().toLowerCase());
        }
        System.out.printf("Какое вы животное %s: \n", String.join("/", listOfAnimalsNames));
        while (!chekAninal) {
            String input2 = console2.next();
            animal = ListOfAnimals.fromString(input2);
            if (animal == null) {
                System.out.println("У нас нет такого животного, попробуйте еще раз");
            } else {
                chekAninal = true;
                animalType=input2.trim().toUpperCase();
            }
        }

        System.out.println("Введите имя");
        String nameconsole = console2.next();

        int ageconsole = 0;
        System.out.println("Введите возраст целым числом, до 3 знаков включительно");
        String ageString = null;

        while (true) {
            ageString = console2.next();
            if (!validateNumber.isNumber(ageString) || ageString.length() > 3) {
                System.out.println("Неверно введен возраст, попробуйте еще раз");
            } else {
                ageconsole = Integer.parseInt(ageString);
                if (ageconsole==0) {
                    System.out.println("Возраст не должен быть равен 0, попробуйте еще раз");
                    continue;
                }
                break;
            }
        }

        int waСonsole = 0;
        System.out.println("Введите вес целым числом, до 3 знаков включительно");
        String waString = null;

        while (true) {
            waString = console2.next();
            if (!validateNumber.isNumber(waString) || waString.length() > 3) {
                System.out.println("Неверно введен вес, попробуйте еще раз");
            } else {
                waСonsole = Integer.parseInt(waString);
                if (waСonsole==0) {
                    System.out.println("Вес не должен быть равен 0, попробуйте еще раз");
                    continue;
                }
                break;
            }
        }

        System.out.println("Введите цвет");
        String colconsole = console2.next();

        return new AnimalFactory(animalType, nameconsole, colconsole, waСonsole, ageconsole).create(animal);
    }
}
