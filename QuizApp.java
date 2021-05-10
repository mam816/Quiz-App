package quizapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class QuizApp {

    
    public static void main(String[] args) {
        Scanner dataFileScanner = null;
        File dataFile = new File("C:\\Users\\mamil.DESKTOP-TMOJG4N\\OneDrive\\Documents\\NetBeansProjects\\QuizApp\\src\\quizapp\\psychology_test.txt");
        String examTitle;
        try {
            int totalCorrect = 0;
            dataFileScanner = new Scanner(dataFile);
            examTitle = dataFileScanner.nextLine();
            String examPassRate = dataFileScanner.nextLine();
            
            JOptionPane.showMessageDialog(null,"This is a "+examTitle+" exam. You must recieve no less than an "+examPassRate+" to pass this exam.");
            String[] testQuestions = new String[10]; 
            String[][] allAnswerChoices = new String[10][5];
            int[] correctAnswers = new int[10];
            for(int x = 0; x < 10; x++)
            {
            testQuestions[x] = dataFileScanner.nextLine();
            allAnswerChoices[x] = dataFileScanner.nextLine().split("#");
            correctAnswers[x] = Integer.parseInt(dataFileScanner.nextLine()); 
            }
          
         int x = 0;
         while(x < 10)
         {
         String output = "";
         output+=testQuestions[x] + "\n"+ "\n";
         for(int y = 0; y< 5; y++)
           {
            output+= y+1 + ")" +allAnswerChoices[x][y]+ "\n";
           }
            output+=  "\n";         
             int currentAnswer = Integer.parseInt(JOptionPane.showInputDialog(output,null));
             if(currentAnswer == correctAnswers[x])
              {
               JOptionPane.showMessageDialog(null,"You are correct");
               totalCorrect++;
              }
             else
              {
               JOptionPane.showMessageDialog(null,"You are incorrect");
              }  
              x++;                   
         }
           int finalScore = (totalCorrect%10)*10;
           if(finalScore < 85)
             {
              JOptionPane.showMessageDialog(null, "You have failed the exam with a "+finalScore+" . Please retake.");
             }
           else
             {
             JOptionPane.showMessageDialog(null, "Congrats!You have passed the exam with a "+finalScore);
             }
           
         }
         
         catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
}

}
    

