class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = 0, i = num.length - 1;
        List<Integer> ans = new ArrayList<>();

        while (i >= 0 || k > 0) {
            int sum = carry + (i >= 0 ? num[i] : 0) + (k % 10);
            carry = sum / 10;
            ans.add(sum % 10);
            k /= 10;
            i--;
        }
        if (carry > 0) {
            ans.add(carry);
        }
        if (k > 0) {
            ans.add(k);
        }
        Collections.reverse(ans);
        return ans;
    }
}