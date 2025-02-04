import java.util.ArrayList;

abstract class Employee{
    
    private String name;

    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;

    }

    public abstract double calculateSalaray();

    @Override
    public String toString(){
        return "Employee[name=" + name + ",id= " + id + ", salaray= " + calculateSalaray() + "]"; 
    }

    

}   
//*******end of abstract class employee*******


class FullTimeEmployee extends Employee{
    

    

    private double monthlysalary;


    // without its implementation it will create error

    @Override
    public double calculateSalaray() {
        
        return monthlysalary;
    }


    public FullTimeEmployee(String name, int id, double monthlysalary){
        super(name,id);
        this.monthlysalary = monthlysalary;
    }



    
}
//*******end of sub class full time employee **********



class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;

    }

    //overriding the abstract method that is compulsory
    @Override
    public double calculateSalaray(){
        return hoursWorked * hourlyRate;

    }





}
//****************end of part time employee class***************

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }


    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }


    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}




    




//********main class*************
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas" , 1, 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("alexander", 2, 40, 100);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details: ");
        payrollSystem.displayEmployees();
        System.out.println("Removing EMployees");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees Details: ");
        payrollSystem.displayEmployees();
        
    }

}
