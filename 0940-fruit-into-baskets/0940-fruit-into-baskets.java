class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, maxLength = 0;

        for (int r = 0; r < fruits.length; r++) {
            map.put(fruits[r], r);
            if (map.size() > 2) {
                // find minimum index
                int minIndex = Integer.MAX_VALUE;
                for (int idx : map.values()) {
                    minIndex = Math.min(minIndex, idx);
                }

                // move left pointer directly
                l = minIndex + 1;

                // remove fruit with smallest index
                for (int key : map.keySet()) {
                    if (map.get(key) == minIndex) {
                        map.remove(key);
                        break;
                    }
                }
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}