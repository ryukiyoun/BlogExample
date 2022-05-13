import java.util.ArrayList;
import java.util.List;

public class Formula {
    private final static StringValidator validator = new StringValidator();

    private final List<String> numbers = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public Formula(String text){
        stringClassification(new StringSplit().split(text));
    }

    private void stringClassification(String[] elements){
        for(String element : elements){
            addNumberString(element);
        }
    }

    private void addNumberString(String element){
        if(!validator.validateNumber(element))
            numbers.add(element);
    }

    private void addOperatorString(String element){
        if(!validator.validateOperator(element))
            operators.add(element);
    }
}
