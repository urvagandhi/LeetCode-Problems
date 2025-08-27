import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return solveRec(expression, 0, expression.length() - 1);
    }

    public List<Integer> solveRec(String exp, int start, int end) {
        List<Integer> res = new ArrayList<>();

        if (start == end) {
            int num = exp.charAt(start) - '0';
            res.add(num);
            return res;
        }

        if (end - start == 1 && Character.isDigit(exp.charAt(start))) {
            int num = Integer.parseInt(exp.substring(start, end + 1));
            res.add(num);
            return res;
        }

        for (int i = start; i <= end; i++) {
            if (Character.isDigit(exp.charAt(i))) {
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = solveRec(exp, start, i - 1);
            List<Integer> right = solveRec(exp, i + 1, end);

            for (int l : left) {
                for (int r : right) {
                    if (op == '+')
                        res.add(l + r);
                    else if (op == '-')
                        res.add(l - r);
                    else if (op == '*')
                        res.add(l * r);
                }
            }
        }
        return res;
    }
}