class Solution {

    private int digitSum(int num) {
        int sum = 0 ;
        while(num != 0) {
            sum += (num % 10) ;
            num /= 10 ;
        }
        return sum ;
    }

    public int countLargestGroup(int n) {

        Map<Integer, Integer> freq = new HashMap<>() ;
        int maxSize = 0, cnt = 0 ;

        for(int i=1; i<=n; ++i) {
            int sum = digitSum(i) ;
            freq.put(sum, freq.getOrDefault(sum, 0) + 1) ;
            maxSize = Math.max(maxSize, freq.get(sum)) ;
        }

        for(int size : freq.values()) {
            if(size == maxSize) {
                ++cnt ;
            }
        }

        return cnt ;

    }

}