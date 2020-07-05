public class Calculator {

    public static String calculation(int lOp, int rOp, char operation, boolean isRome) throws Exception {
        String result = "";
        switch (operation) {
            case '+':
                result = Integer.toString(lOp + rOp);
                break;
            case '-':
                result = Integer.toString(lOp - rOp);
                break;
            case '*':
                result = Integer.toString(lOp * rOp);
                break;
            case '/':
                result = Integer.toString(lOp / rOp);
                break;
            default:
                throw new Exception("Неизвестная операция");
            }
        if (isRome) {
            result = Numbers.toRome(Integer.parseInt(result));
        }
        return result;
    }
}
