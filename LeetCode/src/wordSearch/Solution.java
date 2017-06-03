package wordSearch;

public class Solution {
	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, i, j, word, new int[]{0})) return true;
            }
        }

        return false;
    }

    private boolean search(char[][] board, boolean[][] visited, int row, int col, String word, int[] idx) {
        if (idx[0] == word.length()) return true;

        boolean hasPath = false;
        if (check(board, visited, row, col, word, idx[0])) {
            visited[row][col] = true;
            idx[0]++;
            hasPath = search(board, visited, row - 1, col, word, idx)
                    || search(board, visited, row, col + 1, word, idx)
                    || search(board, visited, row + 1, col, word, idx)
                    || search(board, visited, row, col - 1, word, idx);


            if (!hasPath) {
                visited[row][col] = false;
                idx[0]--;
            }
        }

        return hasPath;
    }

    private boolean check(char[][] board, boolean[][] visited, int row, int col, String word, int idx) {
        return row >= 0 && row < board.length
                && col >= 0 && col < board[0].length
                && !visited[row][col]
                && board[row][col] == word.charAt(idx);
    }
}
