import java.util.List;

public class StringValidator {
    private static final List<String> OPERATOR = List.of("+", "-", "*", "/");

    public boolean validateNumber(String number){
        if(number == null || number.isBlank())
            throw new IllegalArgumentException("잘못된 숫자입니다.");

        return number.chars().allMatch(Character::isDigit);
    }

    public boolean validateOperator(String operator){
        if(!OPERATOR.contains(operator))
            throw new IllegalArgumentException("잘못된 연산자 압니다.");

        return true;
    }
}
