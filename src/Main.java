import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        String path = "c:\\cobol\\in.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                line = br.readLine();
                String name = fields[0];
                String email = fields[1];
                double sl = Double.parseDouble(fields[2]);
                list.add(new Employee(name, email, sl));
            }


            double st1 = list.stream()
                    .filter(x -> x.getName().contains("M"))
                    .mapToDouble(Employee::getSalary).sum();

            List<String> st2 = list.stream()
                    .filter(x -> x.getSalary() > 2000.00)
                    .map(Employee::getEmail).toList();



            st2.forEach(System.out::println);
            System.out.println("Sum of salary of people whose name starts with 'M': " + st1);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
