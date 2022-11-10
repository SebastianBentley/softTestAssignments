package mockitostuff;

public class Calculator {

    private final int a = 2;
    private final int b = 5;

    CalculatorService service;

    public Calculator(CalculatorService service) {
        this.service = service;
    }

    public int calculate(int a, int b) {
        return service.add(a, b)*a;
        //return (a+b) * 2;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
