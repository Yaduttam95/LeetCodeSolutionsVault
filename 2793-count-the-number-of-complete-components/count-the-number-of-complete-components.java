import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                if (isComplete(component, graph)) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            component.add(curr);
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    private boolean isComplete(List<Integer> component, List<List<Integer>> graph) {
        int size = component.size();
        int expectedEdges = (size * (size - 1)) / 2;
        int actualEdges = 0;
        for (int node : component) {
            actualEdges += graph.get(node).size();
        }
        actualEdges /= 2; // Since it's an undirected graph, we counted each edge twice
        return actualEdges == expectedEdges;
    }
}