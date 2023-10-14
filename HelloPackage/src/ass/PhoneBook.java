import java.util.Scanner;

class Person {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class Phonebook {
    private Person[] person;
    private int size;

    public Phonebook(int capacity) {
        person = new Person[capacity];
        size = 0;
    }

    public void addPerson(Person person) {
        if (size < person.length) {
            person[size] = person;
            size++;
        }
    }

    public Person findPerson(String name) {
        for (int i = 0; i < size; i++) {
            if (person[i].getName().equals(name)) {
                return person[i];
            }
        }
        return null;
    }
}

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of Person >> ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Phonebook phonebook = new Phonebook(capacity);

        for (int i = 0; i < capacity; i++) {
            System.out.print("Name and Phonenumber (ex. 홍길동 010-1234-5678) >> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                String name = parts[0];
                String phoneNumber = parts[1];
                Person person = new Person(name, phoneNumber);
                phonebook.addPerson(person);
            } else {
                System.out.println("Invalid input. Please enter the name and phone number separated by a space.");
                i--;  // Retry
            }
        }

        System.out.println("Store Done");

        while (true) {
            System.out.print("Name to search >> ");
            String searchName = scanner.nextLine();

            if (searchName.equals("stop")) {
                break;
            }

            Person foundPerson = phonebook.findPerson(searchName);

            if (foundPerson != null) {
                System.out.println(foundPerson.getName() + "'s number is " + foundPerson.getPhoneNumber());
            } else {
                System.out.println(searchName + " not found");
            }
        }

        scanner.close();
    }
}
