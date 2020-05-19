package org.launchcode.techjobs_oo;

public abstract class JobField {
    int id;
    static int nextId = 1;
    String value;

    //constructor
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //abstract methods to force overrides:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
