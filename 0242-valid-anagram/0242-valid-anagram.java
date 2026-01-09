import java.util.Hashtable;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Hashtable<Character, Integer> ht = new Hashtable<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ht.put(c, ht.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!ht.containsKey(c)) return false;

            ht.put(c, ht.get(c) - 1);
            if (ht.get(c) == 0) ht.remove(c);
        }

        return ht.isEmpty();
    }
}
