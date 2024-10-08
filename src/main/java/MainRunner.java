import db.MySQLConnect;
import objects.Animal;
import tables.AnimalTable;
import data.Comands;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.ValidateNumber;
import java.io.IOException;
import java.sql.SQLException;
import static factory.AnimalCreate.createAnimalWithData;


public class MainRunner {

    private static  Scanner console = new Scanner(System.in);
    private static  ValidateNumber validateNumber = new ValidateNumber();

    public static void main(String[] args) throws IOException, SQLException, SQLSyntaxErrorException {

        AnimalTable animalTable = new AnimalTable();

        while (true) {
            List<String> commandNames = new ArrayList<>();

            for (Comands commandData: Comands.values()) {
                commandNames.add(commandData.name().toLowerCase());
            }

            System.out.printf("Введите команду %s: \n", String.join("/", commandNames));
            String inputForComands = console.next();
            Comands command = Comands.fromString(inputForComands);

            if (command==null) {
                System.out.println("Введена неверная команда");
                continue;
            }

            switch (command) {
                case ADD:

                    Animal animals = createAnimalWithData();
                    animalTable.write(animals);
                    animals.say();
                    break;

                case UPDATE:

                    ArrayList<Animal> animalForUpdate = animalTable.read("all");
                    if (animalForUpdate.isEmpty()) {
                        System.out.println("Пока нет ни одного животного для изменения");
                        continue;
                    } else {
                        System.out.println("Введите id животного, которое хотите изменить");
                    }

                    String idString = null;
                    int id = 0;

                    while (true) {
                        idString = console.next();
                        if (!validateNumber.isNumber(idString) || idString.length() > 3) {
                            System.out.println("Введен неверный id, попробуйте еще раз");
                        } else {
                            id = Integer.parseInt(idString);
                            if (id == 0) {
                                System.out.println("Id не должен быть равен 0, попробуйте еще раз");
                                continue;
                            }
                            break;
                        }
                    }

                    Animal newAnimal = createAnimalWithData();
                    newAnimal.setId(id);
                    animalTable.update(newAnimal);
                    break;

                case LIST:

                    System.out.println("Введите фильтр или all (все животные): ");
                    try {
                        String filterAnimal = console.next();
                        ArrayList<Animal> animalForRead = animalTable.read(filterAnimal);
                        if (animalForRead.isEmpty()) {
                            System.out.println("Список пуст");
                        } else {
                            for (Animal item : animalForRead) {
                                System.out.println(item.toString());
                            }
                        }
                    } catch (NullPointerException | SQLSyntaxErrorException er) {
                        System.out.println("Ошибка запроса, попробуйте еще раз");
                    }
                    break;

                case EXIT:
                    System.out.println("Вы ввели Exit, сейчас программа завершит работу");
                    console.close();
                    System.exit(0);
                    MySQLConnect.close();
            }
        }
    }
}
