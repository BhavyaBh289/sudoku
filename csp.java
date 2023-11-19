class Solution {
    private static final char EMPTY = '.';

    public void solveSudoku(char[][] board) {
        solveRec(board);
    }

    private boolean solveRec(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == EMPTY) {
                    for (char ch : getPossibleMoves(board, i, j)) {
                        board[i][j] = ch;
                        if (solveRec(board)) {
                            return true;
                        } else {
                            board[i][j] = EMPTY;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private List<Character> getPossibleMoves(char[][] board, int row, int col) {
        List<Character> possibleMoves = new ArrayList<>();

        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, row, col, ch)) {
                possibleMoves.add(ch);
            }
        }
        return possibleMoves;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch || board[row][i] == ch ||
                board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == ch) {
                return false;
            }
        }
        return true;
    }
}
