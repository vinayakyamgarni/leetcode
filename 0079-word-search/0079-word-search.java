class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        int[][] track = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)
                        && found(board, track, i, j, 0, m, n, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean found(char[][] board, int[][] track,
                         int r, int c, int id,
                         int m, int n, String word) {

        if (id == word.length())
            return true;

        if (r < 0 || c < 0 || r >= m || c >= n ||
            board[r][c] != word.charAt(id) || track[r][c] == 1)
            return false;

        track[r][c] = 1;

        boolean ans = found(board, track, r - 1, c, id + 1, m, n, word) ||
                      found(board, track, r + 1, c, id + 1, m, n, word) ||
                      found(board, track, r, c - 1, id + 1, m, n, word) ||
                      found(board, track, r, c + 1, id + 1, m, n, word);

        track[r][c] = 0; // Backtrack

        return ans;
    }
}