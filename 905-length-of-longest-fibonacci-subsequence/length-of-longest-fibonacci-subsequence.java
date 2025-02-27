class Solution 
{
    public int lenLongestFibSubseq(int[] arr) 
    {
        int n = arr.length, max = 0;
        Set<Integer>set = new HashSet<>();
        for(int i : arr) set.add(i);
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int a = arr[i], b = arr[j], count = 2, sum = a+b;
                while(set.contains(sum))
                {
                    count++;
                    a = b;
                    b = sum;
                    sum = a+b;
                }
                if(count > 2) max = Math.max(max, count);
            }
        }
        return max;
    }
}