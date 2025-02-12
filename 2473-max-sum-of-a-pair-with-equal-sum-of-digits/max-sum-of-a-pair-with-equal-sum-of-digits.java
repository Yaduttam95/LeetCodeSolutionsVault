class Solution {
    public int maximumSum(int[] nums) {
        int[] map = new int[82];
        int ans = -1;

        for(int i = 0 ; i < nums.length ; i++){
            int sum = 0, num = nums[i];
            while(num > 0){
                sum += num%10;
                num/=10;
            }

            if(map[sum] != 0){
                ans = Math.max(ans,nums[i] + map[sum]);
                map[sum] = Math.max(map[sum],nums[i]);
            }
            else{
                map[sum] = nums[i];
            }
        }

        return ans;
    }
}