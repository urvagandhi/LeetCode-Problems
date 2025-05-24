class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        if (arr.length == 1) return 0;
        if (arr[start] > arr[start + 1]) return start;
        if (arr[end] > arr[end - 1]) return end;

        start++;
        end--;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) return mid;
            else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}