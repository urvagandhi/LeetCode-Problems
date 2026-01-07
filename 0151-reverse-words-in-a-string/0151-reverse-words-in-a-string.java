class Solution {
    public String reverseWords(String s) {

        s = s.trim(); // can't simply do s.trim(), as string i immutable

        int n = s.length();
        String[] words = new String[n]; 
        int k = 0;

        int i = 0;

        while (i < n) {

            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            if (i >= n) break;

            int j = i;

            while (j < n && s.charAt(j) != ' ') {
                j++;
            }

            words[k++] = s.substring(i, j);

            i = j;
        }

        StringBuilder ans = new StringBuilder();
        for (int x = k - 1; x >= 0; x--) {
            ans.append(words[x]);
            if (x != 0) ans.append(" ");
        }

        return ans.toString();
    }
}
