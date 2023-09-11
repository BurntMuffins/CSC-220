package Homework.Homework1;
class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}

class Apple extends Fruit {
    public Apple() {
        super("Apple");
    }
}

public class Classes {
    public static void main(String[] args) {
        Fruit fruit = new Fruit("Banana");
        Apple apple = new Apple();
        System.out.println(apple.getName());
    }
}
