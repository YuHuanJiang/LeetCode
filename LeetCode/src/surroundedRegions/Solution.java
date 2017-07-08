package surroundedRegions;

import java.util.LinkedList;

public class Solution {
	private static final char point_x = 'X';
	private static final char point_o = 'O';
	private static final char point_tmp = '#';
	private int col_length;
	private int row_length;
	
	public void solve(char[][] board) {
        if(board == null || board.length <= 1 || board[0].length <= 1) return;
        row_length = board.length;
        col_length = board[0].length;
        
        for(int i = 0; i < col_length; i++) {
        	fill(board, 0, i);
        	fill(board, row_length - 1, i);
        }
        
        for(int i = 0; i < row_length; i++) {
        	fill(board, i, 0);
        	fill(board, i, col_length - 1);
        }
        
        for(int i = 0; i < row_length; i++) {
        	for(int j = 0; j < col_length; j++) {
        		if(board[i][j] == point_o) board[i][j] = point_x;
        		else if(board[i][j] == point_tmp) board[i][j] = point_o;
        	}
        }
    }
	
	private void fill(char[][] board, int row, int col){
		if(board[row][col] != point_o) return;
		
		board[row][col] = point_tmp;
		LinkedList<Integer> queue = new LinkedList<>();
		int code = row * col_length + col;
		queue.add(code);
		
		while(!queue.isEmpty()) {
			code = queue.poll();
			int t_row = code / col_length;
			int t_col = code % col_length;
			
			valid_up(board, t_row, t_col, queue);
			valid_down(board, t_row, t_col, queue);
			valid_left(board, t_row, t_col, queue);
			valid_right(board, t_row, t_col, queue);
		}
	}
	
	private void valid_up(char[][] board, int row, int col, LinkedList<Integer> queue) {
		int t_row = row - 1;
		if(row >= 1 && board[t_row][col] == point_o) {
			queue.add(t_row * col_length + col);
			fill_x(board, t_row, col);
		}
	}
	
	private void valid_down(char[][] board, int row, int col, LinkedList<Integer> queue) {
		int t_row = row + 1;
		if(row <= row_length - 2 && board[t_row][col] == point_o) {
			queue.add(t_row * col_length + col);
			fill_x(board, t_row, col);
		}
	}
	
	private void valid_left(char[][] board, int row, int col, LinkedList<Integer> queue) {
		int t_col = col - 1;
		if(col >= 1 && board[row][t_col] == point_o) {
			queue.add(row * col_length + t_col);
			fill_x(board, row, t_col);
		}
	}
	
	private void valid_right(char[][] board, int row, int col, LinkedList<Integer> queue) {
		int t_col = col + 1;
		if(col <= col_length - 2 && board[row][t_col] == point_o) {
			queue.add(row * col_length + t_col);
			fill_x(board, row, t_col);
		}
	}
	
	private void fill_x(char[][] board, int row, int col) {
		board[row][col] = point_tmp;
	}
}
