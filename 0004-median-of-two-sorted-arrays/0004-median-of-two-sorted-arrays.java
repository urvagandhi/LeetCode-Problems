class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];

        // Way 1
        // System.arraycopy(nums1, 0, ans, 0, nums1.length);
        // System.arraycopy(nums2, 0, ans, nums1.length, nums2.length);
        // Arrays.sort(ans);

        // Way 2 - JAVA STREAMS
        // int[] ans = IntStream
        //         .concat(Arrays.stream(nums1), Arrays.stream(nums2))
        //         .sorted()
        //         .toArray();

        // Way 3 - IF both arrays are already sorted
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            ans[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }

        while (i < nums1.length)
            ans[k++] = nums1[i++];
        while (j < nums2.length)
            ans[k++] = nums2[j++];

        int total = nums1.length + nums2.length;

        if (total % 2 == 0) {
            return (ans[total / 2 - 1] + ans[total / 2]) / 2.0;
        } else {
            return ans[total / 2];
        }

    }
}