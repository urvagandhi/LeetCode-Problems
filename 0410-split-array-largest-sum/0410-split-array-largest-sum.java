class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE, end = 0;

        for (int num : nums) {
            end += num;
            start = Math.max(num, start);
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int pieces = 1, sum = 0;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    pieces++;
                    sum = num;
                }
            }

            if (pieces <= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}