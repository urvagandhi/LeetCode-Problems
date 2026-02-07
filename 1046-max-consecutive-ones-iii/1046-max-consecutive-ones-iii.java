class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int l = 0, r = 0, zeros = 0;

        for(r = 0; r < nums.length; r++){
            if(nums[r] == 0){
                zeros++;
            }
            if(zeros > k){
                if(nums[l] == 0) zeros--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}