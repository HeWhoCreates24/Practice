import java.util.*;
public class EMS{
    public static Employee [] employees = new Employee[100];
    public static Integer empCount = 0;
    public static Integer getEmpCount() {
        return empCount;
    }
    public static class Employee {
        int id;
        String name;
        String position;
        int salary;
        Employee (int id){
            System.out.println("Employee ID : " + id + ", created");
            System.out.println();
            empCount++;
        }
        void setName (String Name){
            this.name = Name;
        }
        void setPosition (String pos){
            this.position = pos;
        }
        void setSalary (int salary){
            this.salary = salary;
        }
        String getName (){
            return this.name;
        }
        int getSalary (){
            return this.salary;
        }
    }
    static void cal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter function number :");
        int fn = sc.nextInt();
        switch (fn){
            case 1 -> {
                int n = empCount;
                if (n != 0){
                    for (int i = 0; i < n; i++){
                    System.out.println("ID : " + i);
                    System.out.println("Name : " + employees[i].name);
                    System.out.println("Position : " + employees[i].position);
                    System.out.println("Salary : " + employees[i].getSalary());
                    System.out.println();
                    }
                }
                else {
                    System.out.println("No employees created yet");
                    return;
                }
            }
            case 2 -> {
                int n = empCount;
                if (n != 0){
                    System.out.println("Enter name to search :");
                    sc.nextLine();
                    String name = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < n; i++){
                        if (employees[i].getName().contains(name)) {
                            found = true;
                            System.out.println("ID : " + i);
                            System.out.println("Name : " + employees[i].name);
                            System.out.println("Position : " + employees[i].position);
                            System.out.println("Salary : " + employees[i].getSalary());
                            System.out.println();
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("Employee not found!");
                    }
                }
                else {
                    System.out.println("No employees created yet");
                }
            }
            case 3 -> {
                int n = empCount;
                employees[n] = new Employee(n);
                System.out.println("Enter name :");
                sc.nextLine();
                String name = sc.nextLine();
                employees[n].setName(name);
                System.out.println("Enter position :");
                String position = sc.nextLine();
                employees[n].setPosition(position);
                System.out.println("Enter salary :");
                int salary = sc.nextInt();
                sc.nextLine();
                employees[n].setSalary(salary);
                System.out.println("Employee ID : " + n + ", initialised");
                System.out.println();
            }
            case 4 -> {
                System.out.println("Enter ID to update :");
                int n = sc.nextInt();
                System.out.println("Enter name :");
                sc.nextLine();
                String name = sc.nextLine();
                employees[n].setName(name);
                System.out.println("Enter position :");
                String position = sc.nextLine();
                employees[n].setPosition(position);
                System.out.println("Enter salary :");
                int salary = sc.nextInt();
                sc.nextLine();
                employees[n].setSalary(salary);
                System.out.println("Employee ID : " + n + ", updated");
                System.out.println();
            }
            case 5 -> {
                System.out.println("Enter ID to delete :");
                int n = sc.nextInt();
                for (int i = n; i < empCount; i++){
                    employees[i] = employees[i+1];
                }
                empCount--;
                System.out.println("Employee ID : " + n + ", deleted");
                System.out.println();
            }
            default -> {
                System.out.println("Function not available");
                System.out.println();
            }
        }
    }
    static void dis(){
        System.out.println("1 -> Display all employees");
        System.out.println("2 -> Search for employee");
        System.out.println("3 -> Add employee");
        System.out.println("4 -> Update employee");
        System.out.println("5 -> Delete employee");
        cal();
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to Employee Management System...");
            boolean doing;
            do {
                doing = true;
                boolean done = false;
                while (!done){
                    System.out.println("1 -> enter function");
                    System.out.println("2 -> display functions");
                    System.out.println("enter choice :");
                    int ch1 = sc.nextInt();
                    switch (ch1){
                        case 1 -> {
                            cal();
                            done = true;
                        }
                        case 2 -> {
                            dis();
                            done = true;
                        }
                        default -> System.out.println("choice not available!");
                    }
                }
                done = false;
                while (!done){
                    System.out.println("Want to continue ? (y / n) :");
                    char ch2 = sc.next().charAt(0);
                    switch (ch2){
                        case 'y' -> {
                            doing = true;
                            done = true;
                        }
                        case 'n' -> {
                            doing = false;
                            done = true;
                        }
                        default -> System.out.println("choice not available!");
                    }
                }
            } while (doing);
            System.out.println("Thankyou for using EMS...");
        }
    }
}