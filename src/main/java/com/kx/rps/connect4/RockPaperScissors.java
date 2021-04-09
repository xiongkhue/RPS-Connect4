/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kx.rps.connect4;

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
<<<<<<< HEAD
        //variazbles needed for keep tracking, and decisions
        int rounds, wins, ties, loss, chosenOne, chosenTwo;
        String playAgain, outCome, temp;
        boolean play = true;
    }
    
=======
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
            
            //checks for valid input for rounds minimum of 1 and max of 10
            if( rounds > 10 || rounds < 1){
                System.out.println("Ack! only 1-10 rounds allowed");
                System.exit(0);
            }
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
                
                //keeps track of wins, ties, and losses based on who won each round
                outCome = whoWon(chosenOne, chosenTwo, gesture);
                if(outCome == "tie"){
                    ties++;
                }
                else if(outCome == "win"){
                    wins++;
                }
                else
                    loss++;
            }
            
            //prints out results
            System.out.println("We tied "+ties+" time(s) and you won "+wins+" time(s) and I won DUN! DUN! DUN!.."+loss+" time(s)!");
            if(loss < wins){
                System.out.println("You WIN! I LOSE!");
            }
            else if(loss > wins){
                System.out.println("I WIN! You LOSE!");
            }
            else
                System.out.println("We BOTH WIN(tie)!");
            
            //ask user if they want to play again
            System.out.println("Play again? [y/n]");
            playAgain = inputReader.nextLine();
            
            //checks for valid user input to prompt
            while(!playAgain.equals("y") && !playAgain.equals("n")){
                System.out.println("Please answer y or n only.");
                System.out.println("Play again? [y/n]");
                playAgain = inputReader.nextLine();
            }
            
            //ends game if player says no to playing again
            if(playAgain.equals("n")){
                play = false;
                System.out.println("Thanks for playing!");
            }
        }
    }
    
//    Rock-Paper-Scissors comparison Logic
//            Rock(1), Paper(2), Scissors(3)
//            
//            User Choice : Program Choice
//            
//                Rock(1)
//                    1:1 -> Tie
//                    1:2 -> User Loss
//                    1:3 -> User Win
//                    
//                Paper(2)
//                    2:1 -> User Win
//                    2:2 -> Tie
//                    2:3 -> User Loss
//            
//                Scissors(3)
//                    3:1 -> User Loss
//                    3:2 -> User Win
//                    3:3 -> Tie
//            
//            |1:1, 2:2, 3:3| -> User Choice = Program Choice -> Tie
//            
//            |2:1, 3:2| ->  User Choice-1 = Program Choice -> User Win
//                    else |1:2, 2:3| -> User Choice+1 = Program Choice -> User Loss
//            
//            |3:1, 1:3| -> User Choice-2 = Program Choice -> User Loss
//                          User Choice+2 = Program Choice -> User Win
    
    //Function to compare User and Program Choices and determine who wins the round, also prints Program Choice's gesture
    public static String whoWon(int cOne, int cTwo, String[] gest){
        //|1:1, 2:2, 3:3| -> User Choice = Program Choice -> Tie
        if(cOne == cTwo){
            System.out.println(gest[cTwo-1] + " It's a Tie!");
            return "tie";
        }
        //|1:2, 2:3| -> User Choice+1 = Program Choice -> User Loss
        else if(cOne+1 == cTwo){
            System.out.println(gest[cTwo-1] + " You Loss!");
            return "lost";
        }
        //|2:1, 3:2| ->  User Choice-1 = Program Choice -> User Win
        else if(cOne-1 == cTwo){
            System.out.println(gest[cTwo-1] + " You Win!");
            return "win";
        }
        //|1:3| User Choice+2 = Program Choice -> User Win
        //Since |2:1, 3:2| ->  User Choice-1 = Program Choice -> User Win has already been executed
        //Can be simplified to User Choice < Program Choice -> User Win
        else if (cOne < cTwo){
            System.out.println(gest[cTwo-1] + " You Win");
            return "win";
        }
        //|3:1| User Choice-2 = Program Choice -> User Loss
        //Last case scenerio therefore can be simplied to else User Loss
        else{
            System.out.println(gest[cTwo-1] + " You Loss!");
            return "lost";
        }
    }
>>>>>>> 762cc32... Print results for wins, losses, and ties from each round to determine overall winner. Put in place some checks for user input
}
