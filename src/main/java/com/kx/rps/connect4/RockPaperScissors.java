/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kx.rps.connect4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author khuxi
 */
public class RockPaperScissors {
    
    public static void main(String[] args){
        
        //Execute game method
        playGame();
    }
    
    public static void playGame(){
    //variazbles needed for keep tracking, and decisions
    int wins, ties, loss, chosenOne, chosenTwo;
    String outCome, temp;
    //variazbles needed for runtime
    int rounds;
    String playAgain;
    boolean play = true;
    //RPS Game Choices : Rock, Paper, Scissors
    String[] gesture = {"    _______\n" +
        "---'   ____)\n" +
        "      (_____)\n" +
        "      (_____)\n" +
        "      (____)\n" +
        "---.__(___)", "    _______\n" +
        "---'   ____)____\n" +
        "          ______)\n" +
        "          _______)\n" +
        "         _______)\n" +
        "---.__________)", "    _______\n" +
        "---'   ____)____\n" +
        "          ______)\n" +
        "       __________)\n" +
        "      (____)\n" +
        "---.__(___)"};
        
    //Scanner for user input
    //Random for program randomly choosing rock, paper, scissors
    Scanner inputReader = new Scanner(System.in);
    Random randomizer = new Random();
    
        //while User wants to play
        while(play){
            System.out.println("How many rounds would you like to play (1-10)?");
            temp = inputReader.nextLine();
            
            //try and parse user input to integer value for rounds
            try{
                rounds = Integer.parseInt(temp);
            }catch (NumberFormatException e) {
                System.out.println("Ack! only 1-10 rounds allowed");
                System.exit(0);
            }
            //if valid user input then initialize variables for game
            rounds = Integer.parseInt(temp);
            wins = 0;
            loss = 0;
            ties = 0;
            
            //for each round
            for(int i = 0; i < rounds; i++){
                System.out.println("Rock(1), Paper(2), Scissors(3), GO! [1-3]");
                temp = inputReader.nextLine();
                
                //while user input is not valid, 1, 2, or 3, prompt user for valid input
                while(!temp.equals("1") && !temp.equals("2") && !temp.equals("3")){
                    System.out.println("Please enter 1, 2, or 3 only.");
                    System.out.println("Rock(1), Paper(2), Scissors(3), GO! [1-3]");
                    temp = inputReader.nextLine();
                }
                //once user input is valid  initialize user's choice and randomize program choice
                chosenOne = Integer.parseInt(temp);
                chosenTwo = 1 + randomizer.nextInt(3);
            }
            
            //ask user if they want to play again
            System.out.println("Play again? [y/n]");
            playAgain = inputReader.nextLine();
            
            //ends game if player says no to playing again
            if(playAgain.equals("n")){
                play = false;
                System.out.println("Thanks for playing!");
            }
        }
    }
}
