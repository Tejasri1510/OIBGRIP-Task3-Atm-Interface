import java.util.*;
class Atm{
    int user_pin,user_id;
    ArrayList<String> transaction=new ArrayList<>();
    double amount,money=0;
    Scanner sc=new Scanner(System.in);
    Atm(int id,int pin){
        user_id=id;
        user_pin=pin;
        amount=10000;
    }
    public void TransactionHistory(){
        if(transaction.size()==0){
            System.out.println("<---No Transactions are done yet--->");
        }
        else{
            System.out.println("<---Here are your transactions--->");
            for(int i=0;i<transaction.size();i++){
                System.out.println(transaction.get(i));
            }
        }
        System.out.println();
    }
    public void Withdraw(){
        System.out.println("Enter amount");
        money=sc.nextInt();
        if(money<=amount){
            amount-=money;
            transaction.add(money+" is withdrawn from your account "+user_id);
            System.out.println("<---Witndrawn Successfully!!!--->");
            System.out.println("***Your Current Balance is "+amount+" ***");
        }
        else{
            System.out.println("Withdrawal failed!!No suffcient money in your account");
        }
        System.out.println();
    }
    public void Deposit(){
        System.out.println("Enter amount");
        money=sc.nextInt();
        amount+=money;
        transaction.add(money+" is deposited to your account "+user_id);
        System.out.println("***Your Current Balance is "+amount+" ***");
        System.out.println();
    }
    public void Transfer(){
        System.out.println("Enter account id to which you want to transfer");
        int account_id=sc.nextInt();
        System.out.println("Enter cash you want to transfer");
        money=sc.nextInt();
        if(money<=amount){
        amount-=money;
        transaction.add(money+" is transfered to the account "+account_id);
        System.out.println("<--- "+money+" is transfered to the account "+account_id+" successfully--->");
        System.out.println("***Your Current Balance is "+amount+" ***");}
        else{
             System.out.println("Transaction failed!!No suffcient money in your account");
        }
        System.out.println();
    }
    public void Quit(){
        System.out.println("You can remove your card");
        System.out.println();
    }
}
class AtmInterface{
    public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter user id");
         int id=sc.nextInt();
         System.out.println("<---Please don't remove your card--->");
         System.out.println("Enter pin");
         int pin=sc.nextInt();
         Atm user=new Atm(id,pin);
         int ch=0;
         do{
         System.out.println("*---*---*---*---*---*---*---*---*---*---*");
         System.out.println("<---Please choose one option--->");
         System.out.println("1.Transaction History");
         System.out.println("2.Withdraw");
         System.out.println("3.Deposit");
         System.out.println("4.Transfer");
         System.out.println("5.Quit");
         System.out.println();
         System.out.println("Enter your choice:");
         ch=sc.nextInt();
         switch(ch){
            case 1: user.TransactionHistory();
                    break;
            case 2: user.Withdraw();
                    break;
            case 3: user.Deposit();
                    break;
            case 4: user.Transfer();
                    break;
            case 5: user.Quit();
                    break;
            default:System.out.println("Select valid option");
                    break;
         }
         }while(ch!=5);
         System.out.println("Thank You!!!");
    }
}