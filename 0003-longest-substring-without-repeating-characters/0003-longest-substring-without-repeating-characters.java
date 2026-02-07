class Solution {
    public int lengthOfLongestSubstring(String s) {
        
       Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            if (map.containsKey(currentChar)) {
                l = Math.max(l, map.get(currentChar) + 1);
            }
            map.put(currentChar, r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        
        return maxLength; 
    }
}