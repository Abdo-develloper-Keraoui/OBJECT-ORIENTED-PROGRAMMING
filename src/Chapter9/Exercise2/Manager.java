package Chapter9.Exercise2;

public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + this.bonus;
    }

    @Override
    public String toString() {
        return "Manager {: " + super.getName() + ", Pay" + this.calculatePay() + " }";
    }


}
