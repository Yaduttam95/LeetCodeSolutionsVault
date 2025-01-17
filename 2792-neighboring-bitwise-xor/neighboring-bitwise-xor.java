class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        int len = derived.length;
        int ans = 0;

        for(int i=0;i<len-1;i++)
        {
            ans ^= derived[i];
        }

        if(ans == derived[len-1])
            return true;
        return false;        
    }
}