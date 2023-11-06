public class Main {
    public static void main(String[] args) {
        parenthesesCheck("((((())");
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int openCount = 0, closeCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
            }
            if (c == ')') {
                closeCount++;
            }
            if (openCount < closeCount) {
                return false;
            }
        }

        if (closeCount == openCount) {
            return true;
        } else {
            return false;
        }

    }


    // 2. reverseInteger
    public static String reverseInteger(int check) {
        String ans = "";
        while (check > 0) {
            ans += check % 10;
            check /= 10;
        }
        return ans;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        str += " ";
        String ans = "";
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                ans += (int) word.charAt(0);
                ans += word.charAt(word.length() - 1);
                if (word.length() > 2) {
                    ans += word.substring(2, word.length() - 1);
                    ans += word.charAt(1);
                }
                if (i != str.length() - 1) {
                    ans += " ";
                }
                word = "";
            } else {
                word += str.charAt(i);
            }
        }
        return ans;
    }


    // 4. decipherThis
    public static String decipherThis(String str) {
        str += " ";
        String ans = "";
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                int num = 0, pos = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) >= '0' && word.charAt(j) <= '9') {
                        num += 10;
                        num += Integer.parseInt(word.substring(j, j + 1));
                        pos = j;
                    } else {
                        break;
                    }
                }
                ans += (char) num;
                ans += word.charAt(word.length() - 1);
                if (word.length() - 1 > 1 + pos) {
                    ans += word.substring(pos + 2, word.length() - 1);
                    ans += word.substring(pos + 1);
                }
                if (i != str.length() - 1) {
                    ans += " ";
                }
                word = "";
            } else {
                word += str.charAt(i);
            }
        }
        return ans;
    }
}