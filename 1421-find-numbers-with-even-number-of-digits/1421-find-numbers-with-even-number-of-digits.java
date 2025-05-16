class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;
            if (num < 0) {
                num = num * -1;
            }
            count = (int)(Math.log10(num)) + 1;
            if (count % 2 == 0)
                total++;
        }
        return total;
    }
}