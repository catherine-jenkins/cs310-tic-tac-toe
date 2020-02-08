package edu.jsu.mcis;

public class TicTacToeModel {
     
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for (int i = 0; i < width; i++){
           for (int j = 0; j < width; j++){
               board[i][j] = Mark.EMPTY;
           }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE*********************************
        boolean isMarkMade = false;
        
        if ((isValidSquare(row, col))) {
            
            if (!isSquareMarked(row, col)) {
               
                if (xTurn){
                    board[row][col] = Mark.X;
                    xTurn = false;
                }
                else{
                    board[row][col] = Mark.O;
                    xTurn = true;
                }
                isMarkMade = true;
            }
        }
        return isMarkMade;
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE******************************
        boolean isSquareValid = true;
        
        if ((row > width - 1 || row < 0) || (col > width - 1 || col < 0)){
            
            isSquareValid = false;
        }

        return isSquareValid;
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        boolean squareIsMarked = false;
        
        if (board[row][col] == Mark.X || board[row][col] == Mark.O){
            
            squareIsMarked = true;
        }
        
        return squareIsMarked;
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        return board[row][col];   
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if (isMarkWin(Mark.X)){
            return Result.X;
        }
        else if (isMarkWin(Mark.O)){
            return Result.O;
        }
        else if (isTie()){
            return Result.TIE;
        }
        else{
            return Result.NONE;
        } 
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
        boolean markIsWin = false;
        int horizontalCounter = 0;
        int verticalCounter = 0;
        int diagonalCounter1 = 0;
        int diagonalCounter2 = 0;
        
        for (int i = 0; i < width; i++){
           
            horizontalCounter = 0;
            verticalCounter = 0;
            
            for (int j = 0; j < width; j++){
                if (board[i][j] == mark){
                    horizontalCounter += 1;
                    if (horizontalCounter == width){
                        markIsWin = true;
                    }
                }
                if (board[j][i] == mark){
                    verticalCounter += 1;
                    if (verticalCounter == width){
                        markIsWin = true;
                    }
                }
            }
            if (board[i][i] == mark){
                diagonalCounter1 += 1;
                if (diagonalCounter1 == width){
                    markIsWin = true;
                }
            }
            if (board[i][width - i -1] == mark){
                diagonalCounter2 += 1;
                if (diagonalCounter2 == width){
                    markIsWin = true;
                }
            } 
        }
        return markIsWin;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
        boolean gameIsTie = false;
        if (!isMarkWin(Mark.X) && !isMarkWin(Mark.O) && isGameover()){
            gameIsTie = true; 
        }
        return gameIsTie;
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        boolean gameIsOver = true;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < width; j++){
                if (board[i][j] == Mark.EMPTY){
                    gameIsOver = false;
                }  
            } 
        }
        if (isMarkWin(Mark.X) || isMarkWin(Mark.O)){
            gameIsOver = true;
        }
        return gameIsOver;   
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        for (int i = 0; i < width; i++){
            output.append(i);
        }
        output.append("\n");
        
        for (int i = 0; i < width; i++){
            
           output.append(i + " ");
           
           for (int j = 0; j < width; j++){
               output.append(board[i][j]);
            }
           
           output.append("\n");
        }
        
        return output.toString();
    }  
}