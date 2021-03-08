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
    }
}
