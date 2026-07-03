class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)
                        && found(board, i, j, 0, m, n, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean found(char[][] board, int r, int c, int id,
                         int m, int n, String word) {

        if (id == word.length())
            return true;

        if (r < 0 || c < 0 || r >= m || c >= n ||
                board[r][c] != word.charAt(id))
            return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean ans = found(board, r - 1, c, id + 1, m, n, word) ||
                      found(board, r + 1, c, id + 1, m, n, word) ||
                      found(board, r, c - 1, id + 1, m, n, word) ||
                      found(board, r, c + 1, id + 1, m, n, word);

        board[r][c] = temp;

        return ans;
    }
}