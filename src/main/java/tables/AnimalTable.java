package tables;
import db.MySQLConnect;
import objects.Animal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnimalTable extends AbsTable {
    private static final String NAME = "animals";

    public AnimalTable() {

        super(NAME);
    }

    public void write(Animal animalTab) {
        this.dbConnector.execute(String.format("INSERT INTO %s (id,color,name,weight,type,age) " +
                        "VALUES('%s','%s','%s','%s','%s','%s')", NAME, animalTab.getId(), animalTab.getColor(), animalTab.getName(),
                animalTab.getWeight(), animalTab.getType(), animalTab.getAge()));
    }

    public void print(ResultSet rs) throws SQLException {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-5s%n", "ID", "TYPE", "NAME", "COLOR", "WEIGHT", "Age");
        System.out.println("----------------------------------------------------------------");

        while(rs.next()){
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-5s%n",
                    rs.getInt("id"),
                    rs.getString("type"),
                    rs.getString("name"),
                    rs.getString("color"),
                    rs.getInt("weight"),
                    rs.getInt("age"));
        }
    }

    public ArrayList<Animal> read(String filter) throws SQLException {
        ArrayList<Animal> animal = new ArrayList<>();
        ResultSet resultSet;

        String predicate = "";

        if (!filter.equals("all")) {
            predicate = "where " + filter;
        }
            dbConnector = new MySQLConnect();
            resultSet = this.dbConnector.executeQuery(String.format("SELECT * FROM %s %s;", NAME, predicate).trim());
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String color = resultSet.getString("color");
                int weight = resultSet.getInt("weight");
                int age = resultSet.getInt("age");
                Animal animals = new Animal(id, type, name, color, weight, age);
                animal.add(animals);
            }
            return animal;
    }
    public void update(Animal animal) {
        this.dbConnector.execute(String.format("UPDATE %s SET type='%s', name='%s', color='%s', weight=%s, age=%s WHERE id=%d",
                NAME,
                animal.getType(),
                animal.getName(),
                animal.getColor(),
                animal.getWeight(),
                animal.getAge(),
                animal.getId()));
    }
}

