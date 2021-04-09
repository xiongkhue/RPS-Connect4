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

                    someoneWin = check(i, userPick, board, chip);
                    if(someoneWin){
                        break;
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
    
    //checks if there is four in a row
    public static boolean check(int x, int y, String[][] b, String c){
        int track = 0;
        boolean didWin = false;
        
        //down 
        for (int verticle = x+1; verticle < 6; verticle++) {
            if(b[verticle][y] == c){
                track++;               
                if(track == 3){
                    didWin = true;
                }
            }
            else{
                break;
            }
        }
        track = 0;
        //upleft
        for (int verticle = x-1, horizontal = y-1; verticle >= 0 && horizontal >= 0; verticle--, horizontal--) {
            if(b[verticle][horizontal] == c){
                track++;
                if(track == 3){
                    didWin = true;
                }
            }
            else
                break;
        }
        
        //downright
        for (int verticle = x+1, horizontal = y+1; verticle < 6 && horizontal < 7; verticle++, horizontal++) {
            if(b[verticle][horizontal] == c){
                track++;
                if(track == 3){
                    didWin = true;
                }
            }
            else{
                break;
            }
        }
        track = 0;
        
        //downleft
        for (int verticle = x+1, horizontal = y-1; verticle < 6 && horizontal >= 0; verticle++, horizontal--) {
            if(b[verticle][horizontal] == c){
                track++;
                if(track == 3){
                    didWin = true;
                }
            }
            else
                break;
        }
        
        //upright
        for (int verticle = x-1, horizontal = y+1; verticle >= 0 && horizontal < 7; verticle--, horizontal++) {
            if(b[verticle][horizontal] == c){
                track++;
                if(track == 3){
                    didWin = true;
                }
            }
            else{
                break;
            }
        }
        track = 0;
        
        
        //left
        for (int horizontal = y-1; horizontal >= 0; horizontal--) {
            if(b[x][horizontal] == c){
                track++;
                if(track == 3){
                    didWin = true;
                }
            }
            else
                break;
        }
        
        //right
        for (int horizontal = y+1; horizontal < 7; horizontal++) {
            if(b[x][horizontal] == c){
                track++;
                if(track == 3){
                    didWin = true;
                }
            }
            else{
                break;
            }
        }
        track = 0;
        
        return didWin;
    }
}
