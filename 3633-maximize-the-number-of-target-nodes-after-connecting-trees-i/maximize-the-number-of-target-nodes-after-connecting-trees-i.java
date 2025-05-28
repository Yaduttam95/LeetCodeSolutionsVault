class Solution {

    private static class Point {
        public final int value;
        public final int distance;
        public Point(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        int n = edges1.length;
        for (int[] edge: edges1) {
            map1.putIfAbsent(edge[0], new ArrayList<>());
            map1.get(edge[0]).add(edge[1]);
            map1.putIfAbsent(edge[1], new ArrayList<>());
            map1.get(edge[1]).add(edge[0]);
        }
        int[] ar1 = countDistance(map1, n, k);
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int[] edge: edges2) {
            map2.putIfAbsent(edge[0], new ArrayList<>());
            map2.get(edge[0]).add(edge[1]);
            map2.putIfAbsent(edge[1], new ArrayList<>());
            map2.get(edge[1]).add(edge[0]);
        }
        int m = edges2.length;
        int[] ar2 = countDistance(map2, m, k - 1);
        int max = 0;
        for (int i = 0; i < ar2.length; ++i) max = Math.max(max, ar2[i]);
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            res[i] = ar1[i] + max;
        }
        return res;
    }

    private int[] countDistance(Map<Integer, List<Integer>> map, int n, int k) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            res[i] = BFS(map, n, k, i);
        }
        return res;
    }

    private int BFS(Map<Integer, List<Integer>> map, int n, int k, int start) {
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(start, 0));
            int count = 0;
            boolean[] visited = new boolean[n + 1];
            while (!q.isEmpty()) {
                Point cur = q.poll();
                int curValue = cur.value;
                int curDistance = cur.distance;
                if (visited[curValue]) continue;
                visited[curValue] = true;
                if (curDistance <= k) ++count;
                List<Integer> list = map.getOrDefault(curValue, new ArrayList<>());
                for (int item: list) {
                    q.add(new Point(item, curDistance + 1));
                }
            }
            return count;
    }


}