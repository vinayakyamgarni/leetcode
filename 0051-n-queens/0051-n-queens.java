class Solution {
    static List<List<String>> l = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        l = new ArrayList<>();
        int[][] arr = new int[n][n];   
        place(0, arr);
        return l;                     
    }

    private static void place(int r, int[][] arr) {
        if (r == arr.length) {
            print(arr);
            return;
        }

        for (int c = 0; c < arr.length; c++) {
            if (isSafe(r, c, arr)) {
                arr[r][c] = 1;
                place(r + 1, arr);
                arr[r][c] = 0;
            }
        }
    }

    public static boolean isSafe(int row, int col, int[][] arr) {

        int r = row;
        int c = col;

        // Check column
        while (r >= 0) {
            if (arr[r][c] == 1)
                return false;
            r--;
        }

        // Check left diagonal
        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (arr[r][c] == 1)
                return false;
            r--;
            c--;
        }

        // Check right diagonal
        r = row;
        c = col;
        while (r >= 0 && c < arr.length) {
            if (arr[r][c] == 1)
                return false;
            r--;
            c++;
        }

        return true;
    }

    public static void print(int[][] arr) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String s = "";

            for (int j = 0; j < arr[i].length; j++) {
                s += (arr[i][j] == 1 ? 'Q' : '.');
            }

            ans.add(s);
        }

        l.add(ans);
    }
}