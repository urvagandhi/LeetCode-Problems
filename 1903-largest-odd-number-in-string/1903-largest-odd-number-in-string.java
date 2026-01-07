class Solution {
    public String largestOddNumber(String num) {
        if(Integer.parseInt(num) % 2 != 0){
            return num;
        }

        int largestOdd = 0;
        int count = 0;
        for(int i = 0; i< num.length(); i++){
            int n = num.charAt(i) - '0';
            if(n%2!=0 && count == 0){
                largestOdd = n;
                count++;
            }
            else if(n%2!=0 && n > largestOdd) largestOdd = n;
        }

        if(largestOdd == 0){
            String str = "";
            return str;
        } else return largestOdd + "";
    }
}