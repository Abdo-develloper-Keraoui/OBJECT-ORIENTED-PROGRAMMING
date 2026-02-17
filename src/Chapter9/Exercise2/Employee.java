package Chapter9.Exercise2;

public class Employee {
    //name, baseSalary
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double calculatePay() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return "Employee {: " + getName() + ", Pay" + calculatePay() + " }";
    }
}
