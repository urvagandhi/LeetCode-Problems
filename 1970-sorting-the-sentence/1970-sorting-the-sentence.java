class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        int i = 0;

        while (i < words.length) {
            int index = words[i].charAt(words[i].length() - 1) - '1';

            if (i != index) {
                swap(words, i, index);
            } else {
                i++;
            }
        }

        for (int j = 0; j < words.length; j++) {
            words[j] = words[j].substring(0, words[j].length() - 1);
        }

        return String.join(" ", words);
    }

    static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
