class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int lastEnd = intervals[0][1];
        int skip = 0;

        for(int i = 1; i < intervals.length; i++){
            if(lastEnd <=  intervals[i][0]){
                lastEnd = intervals[i][1];
            }
            else skip++;
        }
        return skip;
    }
}