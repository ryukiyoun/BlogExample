public class StringCalculator {
    private Formula formula;

    public StringCalculator(Formula formula) {
        this.formula = formula;
    }

    public int calcString(){
        return formula.calc();
    }
}
