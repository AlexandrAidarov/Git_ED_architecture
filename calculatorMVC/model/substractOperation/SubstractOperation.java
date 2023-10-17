package calculatorMVC.model.substractOperation;

public class SubstractOperation {
    public SubstractOperation(double firstArg, double secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    double firstArg;
    double secondArg;

    public double substract() {
        return firstArg - secondArg;
    }
}