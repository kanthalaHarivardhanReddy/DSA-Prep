class Solution {
    public int maxProduct(String[] words) {
        int bitarr[] = new int[words.length];
        
        for(int i = 0; i < words.length; i++) {
            int num = 0;
            for(char ch: words[i].toCharArray()){
                if(((num >> (ch - 'a' + 1))&1) == 0)
                    num = num | (1 << (int)(ch - 'a' + 1));
            }
            bitarr[i] = num;
        }
        
        int maxlen = 0; 
        for(int i = 0; i < bitarr.length; i++) {
            for(int j = i + 1; j < bitarr.length; j++) {
                int num1 = bitarr[i], num2 = bitarr[j];
                
                while(num1 > 0 && num2 > 0) {
                    if((num1 & 1) == 1 && (num2 & 1) == 1){
                        break;
                    }
                    num1 = num1 >> 1;
                    num2 = num2 >> 1;
                }
                
                if(num1 != 0 && num2 != 0) {
                    continue;
                }
                else {
                    int len = words[i].length() * words[j].length();
                    maxlen = Math.max(maxlen, len);
                }
            }
        }
        return maxlen;
    }
}