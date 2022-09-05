import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayList<Employee> employees = loadStaff("src/employee.txt");

        /**
         * Данный метод создает сортировку по размеру зарплаты
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary()); // от меньшей к большей
                return o2.getSalary().compareTo(o1.getSalary()); // от большей к меньшей
            }
        });
         */
        // а это через lambda
        employees.sort((o1,o2) -> o2.getSalary().compareTo(o1.getSalary()));
        System.out.println("Список отсортированный по размеру зарплат:");
        System.out.println("------------------------------------------");
        for (Employee worker : employees)
            System.out.println(worker.toString());
        System.out.println();

        employees.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Список отсортированный по именам:");
        System.out.println("------------------------------------------");
        for (Employee worker : employees)
            System.out.println(worker.toString());
        System.out.println();

        employees.sort((o1,o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
        // !!!! ------- сравнение сразу по нескольким параметрам
        employees.sort(Comparator.comparing(Employee::getStartDate).thenComparing(Employee::getSalary));
        // !!!! -------
        System.out.println("Список отсортированный по дате найма и зарплате:");
        System.out.println("------------------------------------------");
        for (Employee worker : employees)
            System.out.println(worker.toString());
        System.out.println();

        System.out.println();


    }

    private static ArrayList<Employee> loadStaff (String filename) {
        ArrayList<Employee> staff = new ArrayList<>();
        File file = new File(filename);

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String[] words = line.split(",");
                if (words.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(words[0], Integer.parseInt(words[1]),
                        (new SimpleDateFormat("dd.mm.yyyy")).parse(words[2])));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }

//  -------- CLASS END
}
