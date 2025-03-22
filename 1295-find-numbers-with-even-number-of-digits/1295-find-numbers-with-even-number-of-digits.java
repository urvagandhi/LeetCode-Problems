class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int count = 0;
            while (temp > 0) {
                temp /= 10;
                count++;
            }
            if (count % 2 == 0) total++;
        }
        return total;
    }
}