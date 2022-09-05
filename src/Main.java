import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal("Hello", 2);
        Animal a2 = new Animal("Hello", 1);

        Set<Animal> animals = new HashSet<>();
        animals.add(a1);
        animals.add(a2);

        animals.forEach(System.out::println);

        System.out.println(a1.equals(a2));
    }
}
