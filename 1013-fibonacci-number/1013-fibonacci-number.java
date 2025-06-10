class Solution {
    public int fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        return (int) Math.round(Math.pow(phi, n) / sqrt5);
    }
}