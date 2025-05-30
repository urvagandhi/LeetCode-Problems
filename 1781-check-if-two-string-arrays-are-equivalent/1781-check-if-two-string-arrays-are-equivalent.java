class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder FinalWord1 = new StringBuilder();
        StringBuilder FinalWord2 = new StringBuilder();
        
        for (int i = 0; i < word1.length; i++) {
            FinalWord1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            FinalWord2.append(word2[i]);
        }

        return FinalWord1.toString().equals(FinalWord2.toString());
    }
}
