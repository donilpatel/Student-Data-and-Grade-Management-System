// base class representing a person with an ID and name
public class Person {
    private final String id; // unique identifier for the person
    private final String name; // name of the person

    // constructor initializes the ID and name
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter for ID
    public String getId() {
        return id;
    }

    // getter for name
    public String getName() {
        return name;
    }
}
