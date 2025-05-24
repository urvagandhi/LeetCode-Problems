class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = max(piles);
        int ans = 0;

        while (start <= end){
            int mid = start + (end - start)/2;
            int totalhrs = requiretime(piles, mid);

            if (totalhrs <= h){
                end = mid - 1;
            }
            else start = mid + 1;
        }
        return start;
    }

    public int requiretime(int[] piles, int kbph){
        int total = 0;
        for(int i = 0; i < piles.length; i++){
            total += Math.ceil((double)piles[i] / (double)kbph);
        }
        return total;
    }

    public int max(int[] piles){
        int max = piles[0];
        for(int i = 1; i < piles.length; i++){
            if(piles[i] > max) max = piles[i];
        }
        return max;
    }
}