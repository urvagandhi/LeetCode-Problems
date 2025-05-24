class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m > n / k)
            return -1;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            start = Math.min(start, day);
            end = Math.max(end, day);
        }

        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int count = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                // if (count == k) {
                //     bouquets++;
                //     count = 0;
                // }
            } else {
                bouquets += count/k;
                count = 0;
            }
        }
        bouquets += count / k;
        if (bouquets >= m)
            return true;
        else
            return false;
        // return bouquets >= m;
    }
}
