public class Input {

    private String[] tokens;
    private boolean isRome;

    public Input(String input) throws Exception {
        tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new Exception("Не правильное количество аргументов");
        }
    }

    public int[] getNumbers() throws Exception {

        if (Numbers.isAvailable(tokens[0]) && Numbers.isAvailable(tokens[2])) {
            isRome = true;
            return new int[]{Numbers.toArabic(tokens[0]), Numbers.toArabic(tokens[2])};
        } else if (isInt(tokens[0]) && isInt(tokens[2])) {
            isRome = false;
            int lOp = Integer.parseInt(tokens[0]);
            int rOp = Integer.parseInt(tokens[2]);
            if ((lOp < 1 || lOp > 10) || (rOp < 1 || rOp > 10)) {
                throw new Exception("Выход за пределы, использовать числа от 1 до 10");
            }
            return new int[]{lOp, rOp};
        } else if((Numbers.isAvailable(tokens[0]) && isInt(tokens[2]) || (Numbers.isAvailable(tokens[2]) && isInt(tokens[0])))){
            throw new Exception("Используйте только арабские или только римские цифры");
        } else {
            throw new Exception("Не правильные аргументы");
        }
    }

    public char getOperation() {

        char op = tokens[1].charAt(0);
        switch (op) {
            case '+':
            case '/':
            case '*':
            case '-':
                return op;
            default:
                return '#';
        }
    }

    public boolean isRome() {
        return isRome;
    }

    private boolean isInt(String str) {

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
