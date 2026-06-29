class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length())// word fpunding condition 
        {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) // word not found
        {
            return false;
        }
// char not  match
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

// visited element mark as#
        char temp = board[i][j];
        board[i][j] = '#';

//explore all the sides of the #
        boolean found =
                dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) ||
                dfs(board, word, i, j - 1, index + 1);
        //backtrack
        board[i][j] = temp;
        return found;
    }
}