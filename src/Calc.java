import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Calc {
    public static void main (String[] args) throws IOException {
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        int actionIndex = -1;
        for (int i=0; i<actions.length; i++) {
            if (exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }

        if (actionIndex==-1) {
            throw new IOException();
        }
        String[] data = exp.split(regexActions[actionIndex]);
        int a,b;
        String[] symbol = exp.split("[+\\-*/ ]");
        if (symbol.length !=2) throw new IOException();
        a = Integer.parseInt(data[0]);
        b = Integer.parseInt(data[1]);




        if (1>a || a>10) {
            throw new IOException();
        }
        if (1>b || b>10) {
            throw new IOException();
        }

        int result = switch (actions[actionIndex]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + actions[actionIndex]);
        };

        System.out.println(result);



    }
}
