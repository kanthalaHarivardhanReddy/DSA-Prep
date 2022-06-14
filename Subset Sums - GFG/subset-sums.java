// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}
// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> solve(ArrayList<Integer> arr, int i, int sum) {
        if(i == arr.size()){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(sum);
            return ans;
        }
            
        ArrayList<Integer> nonpick = solve(arr, i + 1, sum);
        ArrayList<Integer> pick = solve(arr, i + 1, sum + arr.get(i));
        pick.addAll(nonpick);
        return pick;
        
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = solve(arr, 0, 0);
        Collections.sort(ans);
        return ans;
    }
}