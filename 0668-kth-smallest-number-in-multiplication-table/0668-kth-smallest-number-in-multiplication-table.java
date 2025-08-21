class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start = 1, end = m * n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = countValues(mid, m, n);
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    int countValues(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }
}