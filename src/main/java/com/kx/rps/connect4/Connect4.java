/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kx.rps.connect4;

import java.util.Scanner;

/**
 *
 * @author khuxi
 */
public class Connect4 {
    
    public static void main (String[] args){
        playGame();
    }
    
    public static void playGame(){
        
        //Variables for user input/pick, user's turn, and if someone has won
        boolean isPlayer, someoneWin = false;
        int userPick;
        String chip = " X ";
        String playerOne = "Player 1";
        String playerTwo = "Player 2";
        String player = playerOne;
        Scanner inputReader = new Scanner(System.in);
        
        //Creates 6H x 7L grid
        String[][] board = new String[6][7];
        for(int i = 0; i < 6; i++){
            for(int j =0; j < 7; j++){
                board[i][j] = " __";
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        
        //while no one has won, next player can place new chip.
        while(!someoneWin){
            System.out.println("Pick a column! [1-7], "+player);
            userPick = inputReader.nextInt() -1;
            for(int i = 5; i >= 0; i--){
                if(board[i][userPick] == " __"){
                    board[i][userPick] = chip;
                    for(int z = 0; z < 6; z++){
                        for(int j =0; j <7; j++){
                            System.out.print(board[z][j]);
                        }
                        System.out.println();
                    }

                    if(chip.equals(" X ")){
                        player = playerTwo;
                        chip = " O ";
                    }
                    else{
                        player = playerOne;
                        chip = " X ";
                    }
                    break;               
                }
            }
        }
    }
}
