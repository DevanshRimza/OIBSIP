import java.util.*;
public class atmInterface 
{
public static Scanner sc=new Scanner(System.in);
public static ArrayList<String> list=new ArrayList<>();

// "login" function checks if the given username and pin are valid
public static void login(String username,int pin) 
{
if (username.contains("Nick") && pin==3030) 
{
list.add("Logged in");
getChoice(11000);
} 
else 
{
System.out.println("Enter valid info!");
System.out.print("Username should followed by pin seperated with a space: ");
login(sc.next(),sc.nextInt());
}
}

// "transaction" function displays the transaction history for 
//the user
public static void transaction(double balance) 
{
for (String i:list) 
{
System.out.println(i);
}
getChoice(balance);
}

// "withdraw" function withdraws the required amount from the account
public static void withdraw(double balance,double amount) 
{
if(amount<=balance && amount>=0) 
{
balance-=amount;
System.out.println("Transaction successful, Current balance is " + balance);
list.add("Rupee's " + amount + " withdrawn.");
getChoice(balance);
} 
else 
{
System.out.print("Enter a valid amount(greater than or equal to 0): ");
withdraw(balance,sc.nextInt());
}
}

// "deposit" function deposits the specified amount into the account
public static void deposit(double balance,double amount) 
{
if(amount>=0) 
{
balance+=amount;
System.out.println("Transaction successful, Current balance is " + balance);
list.add(amount + " ruppee/'s deposited!");
getChoice(balance);
} 
else 
{
System.out.print("Enter a valid amount(greater than or equal to 0): ");
deposit(balance,sc.nextInt());
}
}

// "transfer" function transfer the specified amount to another user's account
public static void transfer(double balance,double amount) 
{
if((amount<=balance) && (amount>=0)) 
{
System.out.print("Enter reciver's username: ");
String receiverName=sc.next();
balance-=amount;
System.out.println(amount + " rupee/s sent to " + receiverName);
System.out.println("Transaction successful, Current balance is " + balance);
list.add(amount + " transfered to account " + receiverName);
getChoice(balance);
} 
else 
{
System.out.print("Enter a valid amount(greater than or equal to 0): ");
transfer(balance,sc.nextInt());
}
}

// "quit" function exits from the program
public static void quit(double balance,char response) 
{
if(response=='y' || response=='Y') 
{
System.out.println("************** Logged out ****************");
System.out.println();
} 
else getChoice(balance);
}

// "getChoice" function presents the user with a list of options and 
//allows them to choose one of the actions
public static void getChoice(double balance) 
{
System.out.println("----------------------------------------");
System.out.println();
System.out.println("1. Transactions History");
System.out.println("2. Withdraw");
System.out.println("3. Deposit");
System.out.println("4. Transfer");
System.out.println("5. Quit");
System.out.print("Choose one of the following actions: ");
int opt=sc.nextInt();
System.out.println();
if(1>opt || opt>5) 
{
System.out.println("Enter valid input!");
getChoice(balance);
} 
else 
{
switch(opt) 
{
case 1:
System.out.println("----------Transaction history!----------");
transaction(balance);
break;

case 2:
System.out.print("Enter amount to be withdrawn: ");
double amountToWithraw=sc.nextInt();
withdraw(balance,amountToWithraw);
break;

case 3:
System.out.print("Enter amount to be deposited: ");
double amountToDeposit=sc.nextInt();
deposit(balance,amountToDeposit);
break;

case 4:
System.out.print("Enter amount to be transfered: ");
double amountToTransfer=sc.nextInt();
transfer(balance,amountToTransfer);
break;

case 5:
System.out.print("Do you want to exit?(Yes/No): ");
char m=sc.next().charAt(0);
quit(balance,m);
break;
}
}
}

public static void main(String[] args) 
{
System.out.println();
// Use username as 'Nick'
System.out.println("Use pin as '3030 for testing");
System.out.println("---------------< Login! >---------------");
System.out.print("Enter user name: ");
String username = sc.next();
System.out.print("Enter pin: ");
int pin=sc.nextInt();
login(username,pin);
}
}