class Solution {
    public String minWindow(String s, String t) {

        StringBuilder ans = new StringBuilder();

        int count = 0, l = 0, minLen = Integer.MAX_VALUE, sIndex = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        // build frequency map of t
        for (int r = 0; r < t.length(); r++) {
            char ch = t.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) count++;
                map.put(c, map.get(c) - 1);
            }

            while (count == t.length()) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                char leftChar = s.charAt(l);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count--;
                }

                l++;   // IMPORTANT
            }
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
