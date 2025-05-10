class Solution {
    public long minSum(int[] nums1, int[] nums2) {
    
       long sum=0, c=0;
        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]==0)
            {
                c++;
            }
            sum=sum+nums1[i];
        }
        long sum2=0, c2=0;
        for(int i=0;i<nums2.length;i++)
        {
            if(nums2[i]==0)
            {
                c2++;
            }
            sum2=sum2+nums2[i];
        }

        if(sum==sum2 && c!=0&&c2!=0)
        {if(c>c2)return sum+c;
        else return sum2+c2;}

        if(c==0 && c2==0){if(sum==sum2)return sum;
        else return -1;}

        if(c!=0 &&c2!=0)
        {
            if((sum+c)>(sum2+c2))return sum+c;
            else return sum2+c2;
        }
        if(c==0 &&c2!=0)
        {
            if(sum>sum2&&sum>=sum2+c2)
            {
                return sum;
            }
        }
         if(c!=0 &&c2==0)
        {
            if(sum<sum2 &&sum+c<=sum2)
            {
                return sum2;
            }
        }
        return -1;
    }
}