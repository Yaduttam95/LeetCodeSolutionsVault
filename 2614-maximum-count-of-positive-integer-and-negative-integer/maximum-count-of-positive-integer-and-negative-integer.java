class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        
        for (int num : nums) {
            if (num > 0) pos++;  // Hooray! Another positive joins the team!
            else if (num < 0) neg++; // Uh-oh, another grumpy negative arrives...
        }
        
        return Math.max(pos, neg); // Let the strongest win! \U0001f4aa
    }
}