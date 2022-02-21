package nowcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leaf_kai on 2022/2/21.
 */
public class PhoneNumber{
    private static List<String> resultList = new ArrayList<>();
    private static String[] contentArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        System.out.println(showResult("35"));

    }

    private static List<String> showResult(String digits) {

        if (null == digits || digits.length() == 0) {
            return resultList;
        }
        resultList.clear();
        dfs(new StringBuilder(), digits);
        return resultList;
    }

    private static void dfs(StringBuilder path, String digits) {
        if (path.length() == digits.length()) {
            resultList.add(path.toString());
            return;
        }
        int currentDigitIndex = digits.charAt(path.length()) - '0';
        char[] currentLetters = contentArray[currentDigitIndex].toCharArray();
        for (char item : currentLetters) {
            path.append(item);
            dfs(path, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
