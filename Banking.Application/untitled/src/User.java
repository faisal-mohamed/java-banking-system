import java.util.ArrayList;
import java.util.UUID;

public class User {
   private UUID userID;
   private String username;
    private String password;
    private double balance;

    ArrayList<Statement> statements;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
        this.userID = UUID.randomUUID();
        this.statements = new ArrayList<>();
    }


    public UUID getUserID() {
        return userID;
    }
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance+=balance;
    }

    public void withdrawamt(String item, double amount){
        this.statements.add(new Statement(item, amount));
        this.balance-=amount;
    }
    public void withdrawtransferamt(String reason, double amt) {
        this.statements.add(new Statement(reason, amt));
    }
    public void printStatement() {
        System.out.println(getUsername()+"  Mini Statement...........");
        for(Statement statement : statements) {
            System.out.println("Categories: "+statement.item+" Amount: "+statement.amount);
        }
    }
}

class Statement {
    String item;
    double amount;

    public Statement(String item, double cost) {
        this.item = item;
        this.amount = cost;
    }
}