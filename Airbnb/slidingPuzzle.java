
class Solution {
    public int slidingPuzzle(int[][] board) {
        Set<String> seen = new HashSet<>(); // used to avoid duplicates
        String target = "123450";
        // convert board to string - initial state.
        String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", "");
        Queue<String> q = new LinkedList<>(Arrays.asList(s));
        seen.add(s); // add initial state to set.
        int ans = 0; // record the # of rounds of Breadth Search
        while (!q.isEmpty()) { // Not traverse all states yet?
            // loop used to control search breadth.
            for (int sz = q.size(); sz > 0; --sz) {
                String str = q.poll();
                if (str.equals(target)) { return ans; } // found target.
                int i = str.indexOf('0'); // locate '0'
                int[] d = { 1, -1, 3, -3 }; // potential swap displacements.
                for (int k = 0; k < 4; ++k) { // traverse all options.
                    int j = i + d[k]; // potential swap index.
                    // conditional used to avoid invalid swaps.
                    if (j < 0 || j > 5 || i == 2 && j == 3 || i == 3 && j == 2) { continue; }
                    char[] ch = str.toCharArray();
                    // swap ch[i] and ch[j].
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    s = String.valueOf(ch); // a new candidate state.
                    if (seen.add(s)) { q.offer(s); } //Avoid duplicate.
                }
            }
            ++ans; // finished a round of Breadth Search, plus 1.
        }
        return -1;
    }
}


//Follow Up OOD

class SlidingPuzzle {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};

    class Status {
        int[][] matrix;
        int x, y;
        Status(int[][] m, int i, int j) {
            matrix = new int[m.length][m[0].length];
            for (int ii = 0; ii < m.length; ii++)
                matrix[ii] = m[ii].clone();
            x = i;
            y = j;
        }
        String encodeMatrix() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix.length; j++)
                    builder.append(matrix[j]).append(",");
            return builder.toString();
        }
        void move(int i, int j) {
            matrix[x][y] = matrix[i][j];
            matrix[i][j] = 0;
            x = i;
            y = j;
        }
    }

    public boolean canSolve(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int startX = 0, startY = 0;
        int[][] finalMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                finalMatrix[j] = i * m + j;
                if (matrix[j] == 0) {
                    startX = i;
                    startY = j;
                }
            }
        }

        Status initial = new Status(matrix, startX, startY);
        Status finals = new Status(finalMatrix, 0, 0);
        Queue<Status> queue = new LinkedList<>();
        queue.add(initial);
        Set<String> visited = new HashSet<>();
        visited.add(initial.encodeMatrix());
        System.out.println(initial.encodeMatrix());

        while (!queue.isEmpty()) {
            Status current = queue.poll();
            System.out.println("F: " + current.encodeMatrix());
            int xx = current.x, yy = current.y;
            for (int i = 0; i < 4; i++) {
                int x = xx + dx;
                int y = yy + dy;
                if (x < 0 || x >= m || y < 0 || y >= n)
                    continue;
                current.move(x, y);
                if (current.encodeMatrix().equals(finals.encodeMatrix()))
                    return true;
                if (!visited.contains(current.encodeMatrix())) {
                    visited.add(current.encodeMatrix());
                    System.out.println(current.encodeMatrix());
                    queue.add(new Status(current.matrix, current.x, current.y));
                }
                current.move(xx, yy);
            }
        }

        return false;
    }


    public final static void main(String[] args) {
        SlidingGame sg = new SlidingGame();
        int[][] matrix = new int[][]{{2, 3, 8}, {1, 4, 7}, {6, 0, 5}};
        System.out.println(sg.canSolve(matrix));
    }

}
