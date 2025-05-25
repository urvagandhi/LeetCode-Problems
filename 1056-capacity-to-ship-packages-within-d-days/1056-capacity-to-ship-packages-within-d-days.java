class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;

        for (int i : weights) {
            start = Math.max(start, i);
            end += i;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int totaldays = require(weights, mid);

            if (totaldays <= days) end = mid - 1;
            else start = mid + 1;
                
        }
        return start;
    }
    public int require(int[] weights, int mid){
        int sum = 0;
        int days = 1;
        for(int weight : weights){
            if(sum + weight > mid){
                days++;
                sum = weight;
            } else sum+= weight;
        }
        return days;
    }
}