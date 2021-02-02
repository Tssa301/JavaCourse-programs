package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.Employee;

public class ProgramEmployee {


    /*
    The program was designed to read an integer N and then the data (id, name, and salary) of N employees. There should be no repetition of id.
 
    Then, make the X percent increase in the salary of a particular employee. For this, the program must read an id and the value X. 
    If the given id does not exist, display a message and abort the operation. In the end, show the updated list of employees as examples.
    */

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {

            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");

            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)) {
                    System.out.print("Id already taken! Try again: ");
                    id = sc.nextInt();
            }
            
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }


        
        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int idsalary = sc.nextInt();
        //Integer pos = position(list, idsalary);
        Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null);
        
        //if (pos == null)
        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter de percentage: ");
            double percent = sc.nextDouble();
            //list.get(pos).increaseSalary(percent);
            emp.increaseSalary(percent);
        }


        System.out.println();
        System.out.println("List of employees:");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();

    }


    public static Integer position(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    } 


    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

}
