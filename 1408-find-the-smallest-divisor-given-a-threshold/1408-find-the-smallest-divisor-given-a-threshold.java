class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        for (int num : nums){
            end = Math.max(num, end);
        }

        int ans = start;

        while(start <= end){
            int mid = start + (end - start)/2;

            int divsum = div(nums, threshold, mid);
            if(divsum == 1) start = mid + 1;
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    public int div(int[] nums,int threshold,int mid){
        int sum = 0;
        for(int num : nums){
            sum += Math.ceil((double)num / (double)mid);
            if (sum > threshold) return 1;
        }
        return 0;
    }
}