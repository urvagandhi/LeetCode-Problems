class Solution {
    public int longestSubarray(int[] nums) {
        int count = 0;
        int count1 = 0;
        int zero = 0;
        int max = 0;

        int j = 0;
        while (j < nums.length && nums[j] == 0)
            j++;

        for (int i = j; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if(zero == 1) count1++;
            }
            else if (nums[i] == 0) {
                if (zero == 0)
                    zero = 1;
                else {
                    max = Math.max(max, count);
                    count = count1;
                    count1 = 0;
                }
            }

        }

        max = Math.max(max, count);
        if (zero == 0 && j<=0)
            max--;
        return max;
    }
}