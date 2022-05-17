import java.util.ArrayList;
import java.util.List;

public class Formula {
    private final static StringValidator validator = new StringValidator();

    private final List<String> numbers = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public Formula(String text) {
        stringClassification(new StringSplit().split(text));
    }

    private void stringClassification(String[] elements) {
        for (int i = 0; i < elements.length - 1; i = i + 2) {
            addNumberString(elements[i]);
            addOperatorString(elements[i + 1]);
        }

        addNumberString(elements[elements.length - 1]);
    }

    private void addNumberString(String element) {
        if (validator.validateNumber(element))
            numbers.add(element);
    }

    private void addOperatorString(String element) {
        if (validator.validateOperator(element))
            operators.add(element);
    }

    public int calc() {
        int result = Integer.parseInt(numbers.get(0));

        for (int i = 0; i < operators.size(); i++) {
            switch (operators.get(i)) {
                case "+":
                    result = calcAdd(result, Integer.parseInt(numbers.get(i + 1)));
                    break;
                case "-":
                    result = calcMinus(result, Integer.parseInt(numbers.get(i + 1)));
                    break;
                case "*":
                    result = calcMet(result, Integer.parseInt(numbers.get(i + 1)));
                    break;
                case "/":
                    result = calcDiv(result, Integer.parseInt(numbers.get(i + 1)));
                    break;
            }
        }

        return result;
    }

    private int calcAdd(int num1, int num2) {
        return num1 + num2;
    }

    private int calcMinus(int num1, int num2) {
        return num1 - num2;
    }

    private int calcMet(int num1, int num2) {
        return num1 * num2;
    }

    private int calcDiv(int num1, int num2) {
        if (num2 == 0)
            throw new IllegalArgumentException("나누고자 하는 값이 0입니다.");

        return num1 / num2;
    }
}
