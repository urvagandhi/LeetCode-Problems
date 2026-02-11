class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0, r = 0, count= 0;

        while(l < g.length && r < s.length){
            if(s[r] >= g[l]){
                count++;
                l++;
            }
            r++;
        }
        return count;
    }
}