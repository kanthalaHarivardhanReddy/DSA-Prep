public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        // for(char c:Integer.toBinaryString(n).toCharArray()){
        //     if(c=='1') count++;
        // }
        while(n!=0){
            count += (n&1);
            n = n>>>1;
        }
        return count;
    }
}