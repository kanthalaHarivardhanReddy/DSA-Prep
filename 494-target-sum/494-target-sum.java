class Solution {
    private int countDpart(int[] nums, int n,int d){
        int tsum=0;
        for(int ele:nums) tsum+=ele;
        int sum=tsum-d;
        if(sum<0 || sum%2!=0) return 0;
        sum/=2;
        int prev[] = new int[sum+1];
        if(nums[0]==0) prev[0] =2;
        else prev[0]=1;
        if(nums[0]!=0 && nums[0]<=sum) prev[nums[0]]=1;
        for(int i=1;i<n;i++){
            int curr[] = new int[sum+1];
            for(int tar=0;tar<=sum;tar++){
                int nonpick=prev[tar];
                int pick = 0;
                if(nums[i]<=tar) pick=prev[tar-nums[i]];
                curr[tar]=pick+nonpick;
            }
            prev=curr;
        }
        return prev[sum];
    }
    public int findTargetSumWays(int[] nums, int target) {
        //converting the question into the s1-s2=D problem 
        //which makes our memoization and tabulation code easier to write
        //EG: [1,3,2,1] D=3
        //subset 1 contains the positives 1.[3,2] 2.[3,1,1] sum1=5
        //subset 2 contains the negatives  [1,1]   [2]  sum2=2
        //sum1-sum2=D => 5-3=3
        return countDpart(nums,nums.length,target);
    }
}