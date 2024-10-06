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
        Scanner consoleForAnCreate = new Scanner(System.in);

        boolean chekAninal = false;
        ListOfAnimals animal = null;
        String animalType=null;

        List<String> listOfAnimalsNames = new ArrayList<>();
        for (ListOfAnimals listOfAnimalsData: ListOfAnimals.values()) {
            listOfAnimalsNames.add(listOfAnimalsData.name().toLowerCase());
        }
        System.out.printf("Какое вы животное %s: \n", String.join("/", listOfAnimalsNames));
        while (!chekAninal) {
            String inputForAnimals = consoleForAnCreate.next();
            animal = ListOfAnimals.fromString(inputForAnimals);
            if (animal == null) {
                System.out.println("У нас нет такого животного, попробуйте еще раз");
            } else {
                chekAninal = true;
                animalType=inputForAnimals.trim().toUpperCase();
            }
        }

        System.out.println("Введите имя");
        String nameconsole = consoleForAnCreate.next();

        int ageconsole = 0;
        System.out.println("Введите возраст целым числом, до 3 знаков включительно");
        String ageString = null;

        while (true) {
            ageString = consoleForAnCreate.next();
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
            waString = consoleForAnCreate.next();
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
        String colconsole = consoleForAnCreate.next();

        return new AnimalFactory(animalType, nameconsole, colconsole, waСonsole, ageconsole).create(animal);
    }
}
