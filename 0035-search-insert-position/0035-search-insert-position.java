class Solution {
    public int searchInsert(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        if (x > nums[end])
            return ans;
        if (nums.length == 0)
            return ans;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x > nums[mid])
                start = mid + 1;
            else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}