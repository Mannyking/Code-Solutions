package code.solutions;

public class Person {
    String name;
    int age;

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "John Doe";
        person.age = 30;
        person.displayInfo();

        PersonHandler handler = new PersonHandler();
        handler.handlePerson(person);
    }
}

class PersonHandler {
    public void handlePerson(Person person) {
        System.out.println("Handling " + person.name);
    }
}
