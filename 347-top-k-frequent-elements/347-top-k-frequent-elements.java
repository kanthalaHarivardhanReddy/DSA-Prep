class Pair{
    int num, freq;
    Pair(int num, int freq){
        this.num=num;
        this.freq=freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==1) return nums;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    if(a.freq - b.freq == 0 )
                        return b.num - a.num;
                    return a.freq - b.freq;
                }
            }
        );
        Map<Integer, Integer> map =new HashMap<>();

        for(int i : nums) map.put(i, map.getOrDefault(i,0)+1);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size()>k) pq.poll();
            // System.out.println(pq.peek().num);
        }
        int ans[] = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll().num;
        }
        return ans;
    }
}