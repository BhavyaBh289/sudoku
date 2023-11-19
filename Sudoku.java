import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    private static final char EMPTY = '.';

    private boolean solvepos(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == EMPTY) {
                    for (char ch : getPossibleMoves(board, i, j)) {
                        board[i][j] = ch;
                        if (solvepos(board)) {
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

    private boolean solveRec(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(board[i][j] == '.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(isValid(board, i, j, ch)){
                            board[i][j] = ch;

                            // Backtracking Portion According to Condition
                            if(solveRec(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch || board[row][i] == ch || board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []Args){
        int a=1;
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char [][] k =board;
        Sudoku sud = new Sudoku();
        sud.solvepos(board);
        for (char[] n :board){
            for(char w: n){
                System.out.print(w);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        sud.solveRec(k);
        for (char[] n :k){
            for(char w: n){
                System.out.print(w);
            }
            System.out.println();
        }
    }

}
