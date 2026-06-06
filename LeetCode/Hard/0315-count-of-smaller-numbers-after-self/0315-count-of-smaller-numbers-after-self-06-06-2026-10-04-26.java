class Solution {
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        int[][] indexed = new int[n][2];  // [value, original_index]
        for (int i = 0; i < n; i++) {
            indexed[i][0] = nums[i];
            indexed[i][1] = i;           // carry original index!
        }
        mergeSort(indexed, 0, n - 1);
        List<Integer> result = new ArrayList<>();
        for (int c : count) result.add(c);
        return result;
    }

    void mergeSort(int[][] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    void merge(int[][] arr, int low, int mid, int high) {
        int[][] temp = new int[high - low + 1][2];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (arr[left][0] <= arr[right][0]) {
                // right half elements already passed left → count them!
                count[arr[left][1]] += (right - (mid + 1));
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        // remaining left elements — all right half passed them
        while (left <= mid) {
            count[arr[left][1]] += (right - (mid + 1));
            temp[k++] = arr[left++];
        }
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    }
}