public class Calculator {
    public static void main(String[] args){
        Formula formula = new Formula(new StringInput().inputCalcString());

        StringCalculator calculator = new StringCalculator(formula);

        System.out.println(calculator.calcString());
    }
}
