class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0; int r = 0;
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            while(set.contains(s.charAt(i)) && l < r){
                set.remove(s.charAt(l));
                l++;
                System.out.println(l);
            }
            set.add(s.charAt(i));
            r++;
            System.out.println(r);
            maxLength = Math.max(maxLength, r - l);
            System.out.println(maxLength);
        }
        return maxLength;
    }
}