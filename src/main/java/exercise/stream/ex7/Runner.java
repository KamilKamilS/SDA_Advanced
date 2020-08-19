package exercise.stream.ex6;

import java.util.Collections;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        personList().stream()
                .filter(person -> person.getAge() > 20 || person.getHeight() > 1.75)
                .forEach(x -> System.out.println(x));


    }


    public static List<Person> personList() {
        return Collections.emptyList();
    }

}
