class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        int n = nums.length;
        Arrays.fill(ans, -1);
        for(int i = 0; i < n; i++){
            int j = i + 1;
            for(int k = 0; k < n; k++){
                if(nums[j%n] > nums[i]){
                    ans[i] = nums[j%n];
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}