class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11/
        int n=triangle.size();
        int prev[] = new int[n];
        int curr[] = new int[n];
        //filling the last into the prev array
        for(int j=0;j<n;j++) prev[j] = triangle.get(n-1).get(j);
        for(int r=n-2;r>=0;r--){
            for(int c=0;c<=r;c++){
                curr[c] = triangle.get(r).get(c) + Math.min(prev[c],prev[c+1]);
            }
            prev=curr;
        }
        return prev[0];
    }
}