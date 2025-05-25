class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 1000000;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(div(nums, threshold, mid)) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }

    public boolean div(int[] nums,int threshold,int mid){
        int sum = 0;
        for(int num : nums){
            sum += Math.ceil((double)num / (double)mid);
        }
        return sum <= threshold;
    }
}