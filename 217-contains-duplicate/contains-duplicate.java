import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> n = new HashSet<>();
        for (int num : nums) {
            if (n.contains(num)) {
                return true;
            }
            n.add(num);
        }
        return false;
    }
}
