package objects;

public class Animal {
    private int id;
    private String type, name, color;
    private int weight, age;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal(String type, String name, String color, int weight, int age) {
        this.type = type;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.age = age;
    }


    public Animal(int id, String type, String name, String color, int weight, int age) {
        this.id = id;
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.age = age;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString () {

        String let;
        int ostDel = age % 10;


        if (ostDel == 1) {
            let = " год";
        } else if (ostDel >= 2 && ostDel <= 4 && (age < 10 || age > 20)) {
            let = " года";
        } else {
            let = " лет";
        }
        return "Привет! Я " + type + ", меня зовут "
                + name + ", мне " + age  + let + ", я вешу - "
                + weight + " кг, мой цвет - " + color + " мой id - " + id;
    }

}
