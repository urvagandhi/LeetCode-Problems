public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ones = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            ones[i] = count;
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            int min = 101;
            int index = -1;

            for (int j = 0; j < ones.length; j++) {
                if (ones[j] < min) {
                    min = ones[j];
                    index = j;
                }
            }

            res[i] = index;
            ones[index] = 101;
        }

        return res;
    }
}
