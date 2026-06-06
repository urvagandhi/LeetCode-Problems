class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int cnt = 0;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += countPairs(arr, low, mid, high); // PASS 1: count
        merge(arr, low, mid, high);             // PASS 2: sort
        return cnt;
    }

    // PASS 1 — just count, don't merge yet
    static int countPairs(int[] arr, int low, int mid, int high) {
        int cnt = 0;
        int right = mid + 1;
        for (int left = low; left <= mid; left++) {
            while (right <= high && arr[left] > 2L * arr[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    // PASS 2 — exact same merge as Count Inversions (but without count)
    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while (left <= mid)  temp[k++] = arr[left++];
        while (right <= high) temp[k++] = arr[right++];
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}