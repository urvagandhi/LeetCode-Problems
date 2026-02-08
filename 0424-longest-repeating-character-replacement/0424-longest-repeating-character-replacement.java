class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0, r = 0, maxLen = 0, maxF = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

            char c = s.charAt(r);

            map.put(c, map.getOrDefault(c, 0) + 1);
            maxF = Math.max(maxF, map.get(c));

            while (r - l + 1 - maxF > k) {
                char left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
