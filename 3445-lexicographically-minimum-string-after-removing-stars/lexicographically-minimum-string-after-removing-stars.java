class Solution {
    public String clearStars(String s) {

        // (ele, index)
        // if ele is same then get bigger index first

        // (a, 1) is present in pq then (a, 5) comes so we prefere to remove (a, 5) first
        // (a, 5), (a, 1) -- custom arrangement in pq (minHeap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return b[1]-a[1];
            else return a[0] - b[0];
        });

        Set<Integer> vis = new HashSet<>();

        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '*') {
                int[] smallest = pq.remove();
                vis.add(smallest[1]); // index 
            } else {
                pq.add(new int[]{ch-'a', i}); // (ele, index)
            }
        }

        // construct ans
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch == '*') continue; // ignore

            if(!vis.contains(i)) ans.append(ch); // if not removed then add in ans
        }

        return ans.toString();
    }
}