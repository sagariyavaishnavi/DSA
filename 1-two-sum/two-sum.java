class Solution {
    public int[] twoSum(int[] nums, int target) {
        //take a size
        int size=nums.length;
        int i,j;
        for(i=0;i<size-1;i++){
            for(j=i+1;j<size;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}