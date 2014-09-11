package nl.rdj;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class MultiMapTest {

    @Test
    public void testApp() {
        ListMultimap<String, Person> multimap = ArrayListMultimap.create();
        for (Person person : Arrays.asList(new Person("Remko", "de Jong"), new Person("Brigitte", "Engels"), new Person("Remko", "Jansen"))) {
            multimap.put(person.getFirstName(), person);
        }
        for (String firstName : multimap.keySet()) {
            List<Person> persons = multimap.get(firstName);
            out.println(firstName + ": " + persons);
        }
    }
}

class Person {
    
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("first name: %s, last name: %s", firstName, lastName);
    }
    
}
