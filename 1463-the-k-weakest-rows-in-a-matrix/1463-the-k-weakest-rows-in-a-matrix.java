import java.util.*;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] info = new int[mat.length][2];

        for (int r = 0; r < mat.length; r++) {
            int count = 0;
            for (int val : mat[r]) {
                count += val;
            }
            info[r][0] = count;
            info[r][1] = r;
        }

        Arrays.sort(info, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = info[i][1];
        }

        return ans;
    }
}
