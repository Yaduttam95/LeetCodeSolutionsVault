class Solution 
{
    public int numOfSubarrays(int[] arr) 
    {
        int mod = 1000000007; // Since the answer can be very large, return it modulo 109 + 7.
        int odd = 0, even = 0, total = 0, sum = 0;
        for (int num : arr) 
        {
            sum += num;
            if (sum % 2 == 1) 
            {
                total = (total + even) % mod + 1;
                odd++;
            } 
            else 
            { 
                total = (total + odd) % mod;
                even++;
            }
        }
        return total;
    }
}