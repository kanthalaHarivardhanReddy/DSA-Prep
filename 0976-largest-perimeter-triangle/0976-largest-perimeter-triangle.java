class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = n-3; i >= 0; i--) {
            if(nums[i] + nums[i+1] > nums[i+2]) 
                return nums[i]+nums[i+1]+nums[i+2];
        }
        return 0;
    }
}

// a + b > c
// b + c > a 
// a + c > b - it must satisfy these conditions