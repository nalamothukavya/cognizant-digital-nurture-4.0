import java.util.ArrayList;
import java.util.Scanner;

public class c {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student names (type 'exit' to stop):");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) break;
            studentNames.add(name);
        }

        System.out.println("Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }
    }
}
