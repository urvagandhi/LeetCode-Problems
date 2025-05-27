class Solution {
    public boolean isPalindrome(int x) {

        String numberStr = String.valueOf(x);
        int length = numberStr.length();

        int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }

        for (int i = 0, j = length - 1; i < length && j >= 0; i++, j--) {
            if (digits[i] != digits[j])
                return false;
        }

        return true;
    }
}