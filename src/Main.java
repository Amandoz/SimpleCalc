import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();

        String result;
        int lOp;
        int rOp;
        char operation;

        try {
            Input input = new Input(target);

            lOp = input.getNumbers()[0];
            operation = input.getOperation();
            rOp = input.getNumbers()[1];
            result = Calculator.calculation(lOp, rOp, operation, input.isRome());
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
