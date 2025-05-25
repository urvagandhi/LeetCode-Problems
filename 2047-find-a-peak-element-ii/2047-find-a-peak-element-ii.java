class Solution {
    public int findmaxIndex(int[][] mat, int n, int m, int col){
        int maxValue = -1;
        int index = -1;
        for(int i = 0;i < n;i++){
            if(mat[i][col] > maxValue){
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        if(n == 0) return new int[]{-1,-1};
        int m = mat[0].length;
        int start = 0, end = m - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int row = findmaxIndex(mat,n,m,mid);

            int left = (mid - 1 >= 0)? mat[row][mid - 1] : -1;
            int right = (mid + 1 < m)? mat[row][mid + 1] : -1;
            
            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }else if (mat[row][mid] < left) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }

        }
         return new int[]{-1, -1};
    }
}