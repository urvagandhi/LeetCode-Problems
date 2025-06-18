class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return Collections.emptyList();
        }
        return pad("", digits);
    }

    public List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        ArrayList<String> list = new ArrayList<>();

        String[] phoneMap = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        String chars = phoneMap[digit];

        for (int i = 0; i < chars.length(); i++) {
            char ch = chars.charAt(i);
            list.addAll(pad(p + ch, up.substring(1)));
        }
        return list;
    }
}