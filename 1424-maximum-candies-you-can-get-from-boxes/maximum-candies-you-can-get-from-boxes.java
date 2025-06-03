class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q=new LinkedList<>();
        for(int node:initialBoxes){
            q.offer(node);
        }
        int total=0;
        while(!q.isEmpty()){
            int box=q.poll();
            if(status[box]==0){
                if(q.isEmpty()){
                    return total;
                }
                q.offer(box);
            }
            else{
                total+=candies[box];
                for(int key:keys[box]){
                    status[key]=1;
                }
                for(int contained:containedBoxes[box]){
                    q.offer(contained);
                }
            }
        }
        return total;
    }
}