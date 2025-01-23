package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Employee>
        employees = Arrays.asList(
                new Employee("Varsha", 24, "Comp1", "A01", 40000),
                new Employee("Zoya", 29, "Comp2", "A02", 60000),
                new Employee("max", 22, "Comp3", "A03", 20000),
                new Employee("Martin", 25, "Comp4", "A04", 40000),
                new Employee("moana", 30, "Comp5", "A05", 70000)
        );
        List<Employee> salaryFiltered = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.toList());
        System.out.println("Employees with salary > 50000:");
        salaryFiltered.forEach(System.out::println);

        List<Employee> ageFiltered = employees.stream()
                .filter(e -> e.getAge() < 30)
                .collect(Collectors.toList());
        System.out.println("\nEmployees with age < 30:");
        ageFiltered.forEach(System.out::println);

        Map<String, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getName, e -> e));

        Map<String, Employee> salaryLessThan40000 = employeeMap.entrySet().stream()
                .filter(entry -> entry.getValue().getSalary() < 40000)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("\nEmployees with salary < 40000:");
        salaryLessThan40000.values().forEach(System.out::println);

        Map<String, Employee> ageGreaterThan25 = employeeMap.entrySet().stream()
                .filter(entry -> entry.getValue().getAge() > 25)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("\nEmployees with age > 25:");
        ageGreaterThan25.values().forEach(System.out::println);
    }
}
