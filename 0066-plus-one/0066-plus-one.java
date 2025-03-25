class Solution {
    int carry = 1;

    public int[] plusOne(int[] digits) {
        for (int i = (digits.length - 1); i >= 0; i--) {
            int sum = carry + digits[i];
            carry = sum / 10;
            digits[i] = sum % 10;

            if (carry == 0)
                return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}