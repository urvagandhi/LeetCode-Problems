class Solution {
    public int minInsertions(String s) {
        int stack = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    count++;
                }

                if (stack > 0) {
                    stack--;
                } else {
                    count++;
                }
            }
        }
        count = count + stack * 2;
        return count;
    }
}