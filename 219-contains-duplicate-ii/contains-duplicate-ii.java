class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            int num=nums[i];
            if (pos.containsKey(num)) {
                int preInd = pos.get(num);
                if (i - preInd <= k) {
                    return true;
                }
            }
            pos.put(num,i);
        }
        return false;      
    }
}