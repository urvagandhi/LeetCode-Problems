class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        // int twenty = 0; (not needed as i'm not gonna give it to anyone)

        for(int i  = 0; i < bills.length; i++){
            if(bills[i] == 5) five++;
            else if(bills[i] == 10 && five >= 1){
                five--;
                ten++;
            }else if(bills[i] == 20){
                if(five >= 1 && ten >=1){
                    five--;
                    ten--;
                }
                else if(five >= 3){
                    five = five - 3;
                }
                else return false;
            }
            else return false;
        }
        return true;
    }
}