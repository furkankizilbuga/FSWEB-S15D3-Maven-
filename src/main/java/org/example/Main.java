package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();

        Employee employee1 = new Employee(1, "Furkan", "Kızılbuğa");
        Employee employee2 = new Employee(1, "Furkan", "Kızılbuğa");
        Employee employee3 = new Employee(3, "Gracie", "Abrams");
        Employee employee4 = new Employee(3, "Gracie", "Abrams");
        Employee employee5 = new Employee(3, "Gracie", "Abrams");
        Employee employee6 = new Employee(4, "Hayley", "Williams");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("Removed: " + removeDuplicates(employees));

        System.out.println("Word Count: " + WordCounter.calculatedWord());

    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();

        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i) != null && employees.get(i).getId() != null) {
                Integer employee = employees.get(i).getId();
                if(employee == null) return duplicates;
                for (int j = i + 1; j < employees.size(); j++) {
                    if (employees.get(j) != null && employees.get(j).getId() != null && employee.equals(employees.get(j).getId()) && !duplicates.contains(employees.get(j))) {
                        duplicates.add(employees.get(i));
                    }
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();

        for(Employee employee : employees) {
            if(employee != null) uniques.put(employee.getId(), employee);
        }

        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> uniques = new ArrayList<>();

        List<Employee> duplicates = findDuplicates(employees);

        for (Employee employee : employees) {
            if(!duplicates.contains(employee) && employee != null) {
                    uniques.add(employee);
            }
        }

        return uniques;
    }

}