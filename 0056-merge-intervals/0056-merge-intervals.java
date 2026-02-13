class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> res = new ArrayList<>();
        int[] current = intervals[0];  // start with first interval

        for (int i = 1; i < intervals.length; i++) {
            // If overlapping
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                res.add(current);
                current = intervals[i];
            }
        }

        res.add(current); // add last interval

        return res.toArray(new int[res.size()][]);
    }
}
