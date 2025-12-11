public class D3 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> xMin = new HashMap<>();
        Map<Integer, Integer> xMax = new HashMap<>();
        Map<Integer, Integer> yMin = new HashMap<>();
        Map<Integer, Integer> yMax = new HashMap<>();

        // In Coordinate for a row the col value changes, for a col row val changes, so
        // for row we need to check with cols and for cols we need to check with rows
        for (int[] pair : buildings) {
            int x = pair[0], y = pair[1];
            xMin.put(x, Math.min(xMin.getOrDefault(x, y), y));
            xMax.put(x, Math.max(xMax.getOrDefault(x, y), y));

            yMin.put(y, Math.min(yMin.getOrDefault(y, x), x));
            yMax.put(y, Math.max(yMax.getOrDefault(y, x), x));
        }

        int covered = 0;
        for (int[] pair : buildings) {
            int x = pair[0], y = pair[1];
            int xl = xMin.get(x);
            int xr = xMax.get(x);
            boolean left = (xl < y && y < xr);
            int yd = yMin.get(y);
            int yu = yMax.get(y);
            boolean right = (yd < x && x < yu);
            if (left && right)
                covered++;
        }
        return covered;
    }
}
