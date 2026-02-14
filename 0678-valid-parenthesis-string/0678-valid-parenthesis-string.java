class Solution {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min--;
                max--;
            } else { // '*'
                min--;      // treat as ')'
                max++;      // treat as '('
            }

            // If even the maximum is negative, impossible
            if (max < 0) return false;

            // Minimum can't go below 0
            min = Math.max(min, 0);
        }

        return min == 0;
    }
}
