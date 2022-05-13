import java.util.Scanner;

public class StringInput {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputCalcString(){
        System.out.println("계산하고자하는 문자열을 입력하세요.");
        return scanner.nextLine();
    }
}
