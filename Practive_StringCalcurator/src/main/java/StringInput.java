import java.util.Scanner;

public class StringInput {
    private static final String INPUT_REQUEST_MESSAGE = "계산하고자하는 문자열을 입력하세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public String inputCalcString(){
        System.out.println(INPUT_REQUEST_MESSAGE);
        return scanner.nextLine();
    }
}
