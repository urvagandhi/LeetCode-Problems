class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 1000000;

        while(start <= end){
            int mid = start + (end - start)/2;

            int divsum = div(nums, threshold, mid);
            if(divsum == 0) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    public int div(int[] nums,int threshold,int mid){
        int sum = 0;
        for(int num : nums){
            sum += Math.ceilDiv(num, mid);
            if (sum > threshold) return 0;
        }
        return 1;
    }
}