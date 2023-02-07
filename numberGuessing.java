import java.io.*;
import javax.swing.*;
public class numberGuessing 
{
public static void main(String args[]) 
{
int secretNum=(int)(Math.random()*100+1);
int userGuess=0;
int attempt=1;
try 
{
while(userGuess!=secretNum) 
{
String response=JOptionPane.showInputDialog(null,"Guess a number between 1 and 100.");
userGuess = Integer.parseInt(response);
JOptionPane.showMessageDialog(null, " "+determineGuess(userGuess,secretNum,attempt));
attempt++;
}
}catch(Exception e) 
{
System.out.println(e);	
}
}
public static String determineGuess(int userGuess,int secretNum,int attempt) 
{
if(userGuess<=0 || userGuess>100) 
{
return "Your guess is invalid";
}else if(userGuess==secretNum) 
{
return "GREAT! You guessed the correct number.You won the game. \n You guessed the number in "+ attempt+" attempts.";
}else if(userGuess>secretNum) 
{
return "Your guess is too high, try again! \n Enter Number : " + attempt;
}else if(userGuess<secretNum) 
{
return "Your guess is too low, try again! \n Enter Number :  " + attempt;
}else 
{
return "Your guess is incorrect \n Enter Number : " + attempt;
}
}
}