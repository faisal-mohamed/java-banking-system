import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BankSystem bank = new BankSystem();
        bank.RegUser("kunal", "kunal");
        bank.RegUser("rahul", "rahul");

        int x = 10;

        while(x!=3) {
            System.out.println("1.Reg New User 2.Login to Existing Account  3.Exit");
            System.out.print("Press any one key: ");
            x = in.nextInt();
            if(x==1) {
                //Registration Starts here------------------------------
                int regopt = 1;
                while(regopt!=0) {
                    System.out.println("..............Registering New User");
                    System.out.println("Enter Username: ");
                    String username = in.next();
                    if(bank.RegUser(username)) {
                        System.out.println("Enter Password: ");
                        String password = in.next();
                        bank.RegUser(username, password);
                    } else {
                        System.out.println("username aldready exist....");
                        System.out.println("Press 1 to retry or 0 to exit the Registration Process");
                        regopt = in.nextInt();
                    }
                    regopt = 0;
                }
                //Registration ends here--------------------------------------
            }
            else if(x==2) {
                //Login starts here----------------------------------------------------------------------
                int logopt = 1;
                while(logopt!=0) {
                    System.out.println("................Login User");
                    System.out.println("Enter Username: ");
                    String username = in.next();
                    System.out.println("Enter Password: ");
                    String password = in.next();

                    User u = bank.LoginUser(username,password);
                    if(u==null) {
                        System.out.println("Username or Password is incorrect");
                        System.out.println("Press 1 to retry or 0 to exit");;
                        logopt = in.nextInt();
                    } else {
                        int logact=1;
                        System.out.println("Login Sucessfull.......... Welcome "+u.getUsername());

                        while(logact!=0) {

                            System.out.println("1.Deposit 2.Withdraw 3.Check Balance 4.Mini Statement 5.Transfer Money 6.Exit");
                            logact = in.nextInt();
                            if(logact == 1) {
                                System.out.println("Enter amount to Deposit: ");
                                double amt = in.nextDouble();
                                u.setBalance(amt);
                                System.out.println("Sucessfully Deposited "+amt);
                                System.out.println(".................Your Balance: ₹"+u.getBalance());
                                u.withdrawtransferamt("Deposited",amt);
                            }
                            else if(logact == 2) {
                                System.out.println("Enter amount to Withdraw");
                                double amt = in.nextDouble();
                                if(u.getBalance() < amt) {
                                    System.out.println("Oops....Insuffiecient Balance");
                                } else {
                                    System.out.println("Categories of Withdraw: 1.Entertainment 2.Groceries 3.Rent 4.Others");
                                    int cate = in.nextInt();
                                    String reason;
                                    if(cate == 1)  reason = "Entertainment";
                                    else if(cate == 2) reason = "Groceries";
                                    else if(cate == 3) reason = "Rent";
                                    else reason = "Others";
                                    u.withdrawamt(reason, amt);
                                    System.out.println("Your Remainiing Balance: "+u.getBalance());
                                }
                            }

                            else if(logact==3) {
                                System.out.println("Your Balance: ₹"+u.getBalance());
                            } else if(logact==4) {
                                System.out.println();
                                u.printStatement();
                            } else if(logact==5) {
                                System.out.println("Enter Username for the whom the money should be transferred");
                                String username1 = in.next();
                                System.out.println("Rewrite Username for confirmation");
                                String username2 = in.next();
                                if(username1.equals(username2)) {
                                    User transferUser = bank.FindUser(username1);
                                    System.out.println("Enter amount to be sent: ");
                                    double transferAmt = in.nextDouble();
                                    if(transferAmt < u.getBalance()) {
                                        transferUser.setBalance(transferAmt);
                                        System.out.println("................Sucessfully transferred ₹"+transferAmt+" to "+transferUser.getUsername());
                                        String transTo = "Sent amount to"+username1;
                                        u.withdrawtransferamt(transTo, transferAmt);
                                    } else {
                                        System.out.println("Oops...Insufficient Balance");
                                        System.out.println("Your Balance: "+u.getBalance());
                                    }


                                } else {
                                    System.out.println("Oops.....Mismatch between username");
                                }
                            } else {
                                logact = 0;
                                logopt = 0;
                            }
                        }

                    }

                }
                //login ends here-----------------------------------------------------------------------
            }
            else {
                x=3;
            }
        }
    }
}
