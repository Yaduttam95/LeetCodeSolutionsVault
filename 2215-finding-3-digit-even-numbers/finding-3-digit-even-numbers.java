class Solution {
    public int[] findEvenNumbers(int[] digits) {

        Set<Integer> nums = new HashSet<>() ;
        int n = digits.length ;

        for(int i=0; i<n; ++i) {

            if(digits[i] == 0) {
                continue ;
            }

            for(int j=0; j<n; ++j) {

                for(int k=0; k<n; ++k) {

                    if(digits[k]%2 != 0 || i == j || j == k || i == k) {
                        continue ;
                    }

                    int num = digits[i]*100 + digits[j]*10 + digits[k] ;
                    nums.add(num) ;

                }

            }

        }

        List<Integer> res = new ArrayList<>(nums) ;
        Collections.sort(res) ;

        int[] ans = new int[res.size()] ;

        for(int i=0; i<res.size(); ++i) {
            ans[i] = res.get(i) ;
        }

        return ans ;

    }
}