package xiaomi.arr;

public class 一年中的第几天 {

    private boolean isLeapYear(int y) {

        return y % 400 == 0 || (y % 4 == 0 && y % 100 != 0);
    }

    private int computeDate(int y, int m, int d) {

        int res = 0;

        switch (m) {
            case 12: res += 30;
            case 11: res += 31;
            case 10: res += 30;
            case 9: res += 31;
            case 8: res += 31;
            case 7: res += 30;
            case 6: res += 31;
            case 5: res += 30;
            case 4: res += 31;
            case 3:
                if (isLeapYear(y)) res += 29;
                else res += 28;
            case 2: res += 31;
            case 1: break;
        }

        res += d;
        return res;
    }

    public static void main(String[] args) {

    }
}
