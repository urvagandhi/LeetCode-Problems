class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            // If num is a power of two, no valid answer
            if ((num & (num - 1)) == 0) {
                ans[i] = -1;
                continue;
            }

            int count = 0;
            int temp = num;

            // Count trailing 1s
            while ((temp & 1) == 1) {
                count++;
                temp >>= 1;
            }

            // Minimum valid value
            ans[i] = num - (1 << (count - 1));
        }

        return ans;
    }
}
