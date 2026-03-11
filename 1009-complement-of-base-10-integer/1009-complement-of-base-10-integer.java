class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1;
        return n ^ mask;

        // int mask = n | 1; // edge case n == 0
        // for (int i = 0; i <= 4; i++)
        //     mask |= mask >> (1 << i);
        // return n ^ mask; // alternative
    }
}