class Solution {

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 128; i++) {
            if (a[i] < b[i]) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        int[] freqs = new int[128];
        int[] freqt = new int[128];

        for (char c : t.toCharArray()) {
            freqt[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            freqs[s.charAt(right)]++;

            while (matches(freqs, freqt)) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                freqs[s.charAt(left)]--;
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";

        return s.substring(start, start + minLen);
    }
}
