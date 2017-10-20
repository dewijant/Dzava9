package com.ness;


import java.util.Comparator;

public class Person
{
    private String firstName;
    private String lastName;
    private int age;

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public final static Comparator<Person> compareFirstName = (lhs, rhs) -> lhs.firstName.compareTo(rhs.firstName);

    public final static Comparator<Person> compareLastName = (lhs, rhs) -> lhs.lastName.compareTo(rhs.lastName);

    public Person(String f, String l, int a) {
        firstName = f; lastName = l; age = a;
    }

    
    public static int compareFirstNames(Person lhs, Person rhs) {
        return lhs.firstName.compareTo(rhs.firstName);
    }

    public String toString() {
        return "[Person: firstName:" + firstName + " " +
                "lastName:" + lastName + " " +
                "age:" + age + "]";
    }

}
