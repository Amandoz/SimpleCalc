public enum Numbers {

    I("I", 1), II("II", 2), III("III", 3), IV("IV", 4), V("V", 5),
    VI("VI", 6), VII("VII", 7), VIII("VIII", 8), IX("IX", 9), X("X", 10);

    private String rome;
    private int arabic;

    Numbers(String rome, int arabic) {
        this.rome = rome;
        this.arabic = arabic;
    }

    int getArabic() {
        return arabic;
    }

    String getRome() {
        return rome;
    }

    static int toArabic(String rome) {
        for (Numbers i : Numbers.values()) {
            if (rome.equals(i.getRome())) {
                return i.getArabic();
            }
        }
        return -1;
    }

    static String toRome(int num) {
        int task;
        String res = "";

        if (num >= 100) {
            res += "C";
            num -= 100;
        }
        if (num >= 10) {
            task = num / 10;
            if (task == 4) {
                res += "XL";
            } else if (task == 9) {
                res += "XC";
            } else if (task >= 1 && task <= 3) {
                for (int j = 0; j < task; j++) {
                    res += "X";
                }
            } else if (task >= 5 && task < 9) {
                res += "L";
                for (int j = 5; j < task; j++) {
                    res += "X";
                }
            }
            num -= task * 10;
        }
        if (num >= 0) {
            for (Numbers i : Numbers.values()) {
                if (num == i.getArabic()) {
                    res += i.getRome();
                }
            }
            res += "";
        }
        return res;
    }

    static boolean isAvailable(String rome) {
        for (Numbers i : Numbers.values()) {
            if (rome.equals(i.getRome())) {
                return true;
            }
        }
        return false;
    }
}
