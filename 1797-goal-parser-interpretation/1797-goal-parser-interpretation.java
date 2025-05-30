class Solution {
    public String interpret(String command) {
        StringBuilder output = new StringBuilder();
        char[] chars = command.toCharArray();
        for(int i = 0; i < command.length();){
            if(chars[i] == 'G'){
                output.append("G");
                i++;
            }else if(chars[i] == '(' && chars[i+1] == ')'){
                output.append("o");
                i+=2;
            }else if(chars[i] == '(' && chars[i+1] == 'a'){
                output.append("al");
                i+=4;
            }
        }
        return output.toString();
    }
}
