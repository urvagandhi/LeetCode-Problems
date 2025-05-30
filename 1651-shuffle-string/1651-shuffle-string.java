class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < indices.length) {
            if (i != indices[i]) {
                swap(chars, i, indices[i]);
                swap(indices, i, indices[i]);
            } else {
                i++;
            }
        }
        return new String(chars);
    }

    static void swap(char[] arr, int first, int second) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}