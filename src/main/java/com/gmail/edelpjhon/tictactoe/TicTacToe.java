package com.gmail.edelpjhon.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private final char playerX = 'X';
    private final char playerO = 'O';
    private char currentPlayer = playerX;
    private char[][] board;
    public void runGame() {
        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();
        while (true) {
            getPlayerMove();
            printBoard();
            if (isStopCondition()) {
                printWinner();
                break;
            }
        }
    }

    public boolean isStopCondition() {
        return isWinner(playerX) || isWinner(playerO) || isBoardFull();
    }

    private void printWinner() {
        System.out.println(getPrintWinner());
    }

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    public void placePiece(int row, int col, char piece) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = piece;
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
    }
    public void placePiece(int row, int col) {
        placePiece(row-1, col-1, currentPlayer);
        placePieceAI();
    }

    public void getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter position between 1-9 "+ currentPlayer + " :");
        if (currentPlayer == playerO) {
            placePieceAI();
            return;
        }
        int position = scanner.nextInt();
        int[] rowCol = getRowCol(position);
        placePiece(rowCol[0], rowCol[1], currentPlayer);
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public void placePieceAI() {
        int position = getPositionAI();
        int[] rowCol = getRowCol(position);
        placePiece(rowCol[0], rowCol[1], currentPlayer);
    }

    public int[] getRowCol(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return new int[]{row, col};
    }

    public int getPositionAI(){
        int[] bestMove = minmax(this.board, 0, true);
//        System.out.println("Best move: " + bestMove[0] + " " + bestMove[1]);
        return bestMove[0] * 3 + bestMove[1] + 1;
    }

    public int[] minmax(char[][] board, int depth, boolean isMaximizing){
        int[] position ={-1,-1,0} ;
        if(isWinner(playerX)){
            return new int[]{-1, -1, -1 * depth};
        }else if(isWinner(playerO)){
            return new int[]{-1, -1,  depth };
        }else if(isBoardFull()){
            return new int[]{-1, -1, 0 };
        }

        if(isMaximizing){
            int bestScore = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == ' '){
                        board[i][j] = playerO;
                        int[] score = minmax(board, depth + 1, false);
                        board[i][j] = ' ';
                        if(score[2] > bestScore){
                            bestScore = score[2];
                            position[0] = i;
                            position[1] = j;
                            position[2] = bestScore;
                        }
                    }
                }
            }
        }else{
            int bestScore = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == ' '){
                        board[i][j] = playerX;
                        int[] score = minmax(board, depth + 1, true);
                        board[i][j] = ' ';
                        if(score[2] < bestScore){
                            bestScore = score[2];
                            position[0] = i;
                            position[1] = j;
                            position[2] = bestScore;
                        }
                    }
                }
            }
        }
        return position;
    }


    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---|---|---");
            }
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return  false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(char piece) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == piece && board[i][1] == piece && board[i][2] == piece) {
                return true;
            }
            if (board[0][i] == piece && board[1][i] == piece && board[2][i] == piece) {
                return true;
            }
        }
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {
            return true;
        }
        return board[0][2] == piece && board[1][1] == piece && board[2][0] == piece;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public String getPrintWinner() {
        if (isWinner(playerX)) {
            return "Player X wins!";
        } else if (isWinner(playerO)) {
            return "Player O wins!";
        } else {
            return "It's a tie!";
        }
    }

    public boolean isStarted() {
        return !isBoardFull() && !isWinner(playerX) && !isWinner(playerO);
    }
}
