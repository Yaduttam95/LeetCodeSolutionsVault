class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        final int len = grid.length;
        final int n = len * len;
        final int nSeqSum = n * (n + 1) / 2;
        final Set<Integer> numbersSet = new HashSet<>();

        int duplicate = 0;
        int gridSum = 0;
        for (final int[] row : grid) {
            for (final int num : row) {

                if (duplicate == 0) {
                    final int setSizeBefore = numbersSet.size();

                    numbersSet.add(num);

                    if (numbersSet.size() == setSizeBefore) duplicate = num;
                }

                gridSum += num;
            }
        }

        return new int[]{ duplicate, nSeqSum - (gridSum - duplicate) };
    }
}