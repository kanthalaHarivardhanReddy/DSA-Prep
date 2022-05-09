class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n];
        int outdegree[] = new int[n];
        for(int node[]:trust){
            outdegree[node[0]-1] +=1;
            indegree[node[1]-1] +=1;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0){
                return i+1;
            }
        }
        return -1;
    }
}