package Day4;
import java.util.Random;

class Employee {
    private final int empRatePerHour = 20;

    public int calculateEmployeeWage(int empHrs) {
        return empHrs * empRatePerHour;
    }
}

public class EmployeeWageOOP {
    static final int workingDays = 20;
    static final int partTime = 1;
    static final int fullTime = 2;

    public static void main(String[] args) {
        Employee employee = new Employee();
        int totalEmpWage = calculateTotalWage(employee);
        System.out.println("Employee Wage for total working days: " + totalEmpWage);
    }

    private static int calculateTotalWage(Employee employee) {
        int totalEmpWage = 0;
        for (int day = 0; day < workingDays; day++) {
            int empCheck = generateEmployeeCheck();
            int empHrs = getEmployeeHours(empCheck);
            int empWage = employee.calculateEmployeeWage(empHrs);
            totalEmpWage += empWage;
            System.out.println("Day " + (day + 1) + " : Employee Wage: " + empWage);
        }
        return totalEmpWage;
    }

    private static int generateEmployeeCheck() {
        return new Random().nextInt(3); // generates 0, 1, or 2 randomly
    }

    private static int getEmployeeHours(int empCheck) {
        switch (empCheck) {
            case partTime:
                return 4;
            case fullTime:
                return 8;
            default:
                return 0;
        }
    }
}