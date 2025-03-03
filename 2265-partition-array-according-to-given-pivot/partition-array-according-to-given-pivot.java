class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int[] ans = new int[nums.length];
        int index = 0;
        // fill array with pivot
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pivot;
        }

        // move from left to right, fill only elements that are smaller
        for (int left = 0; left < nums.length; left++) {

            if (nums[left] < pivot) {
                ans[index] = nums[left];
                index++;
            }
        }

        // now move from right to left and fill the elements that are greater
        index = ans.length-1;
        for (int right = nums.length-1; right >= 0; right--) {

            if (nums[right] > pivot) {
                ans[index] = nums[right];
                index--;
            }
        }
        return ans;    
    }
}