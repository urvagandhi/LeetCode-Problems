class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        for (int num : nums){
            end = Math.max(num, end);
        }

        while(start <= end){
            int mid = start + (end - start)/2;

            int divsum = div(nums, mid);
            if(div(nums, mid) > threshold) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    public int div(int[] nums, int mid){
        int sum = 0;
        for(int num : nums){
            sum += Math.ceil((double)num / (double)mid);
        }
        return sum;
    }
}