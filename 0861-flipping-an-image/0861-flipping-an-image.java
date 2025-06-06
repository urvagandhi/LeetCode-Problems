class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {

            int left = 0, right = image[i].length - 1;
            while (left < right) {
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;

                left++;
                right--;
            }

        }

        // Code for Bit Manipulation
        int[][] ans = new int[image.length][image.length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                if (image[i][j] == 1)
                    ans[i][j] = 0;
                else
                    ans[i][j] = 1;
            }
        }

        return ans;
    }
}