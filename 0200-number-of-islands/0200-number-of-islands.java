class Solution {

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    visit(grid, i, j, m, n);
                }
            }
        }

        return count;
    }

    public void visit(char[][] grid, int i, int j, int m, int n) {

        
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;

       
        if (grid[i][j] == '0')
            return;

   
        grid[i][j] = '0';

        // Visit all 4 directions
        visit(grid, i + 1, j, m, n); // Down
        visit(grid, i - 1, j, m, n); // Up
        visit(grid, i, j + 1, m, n); // Right
        visit(grid, i, j - 1, m, n); // Left
    }
}