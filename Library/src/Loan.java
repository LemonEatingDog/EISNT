import java.util.Date;
import java.util.Optional;

public class Loan {

    Date startDate;
    private Date returnDate;
    String loanedTo;
    int id;
    private boolean available;

    public Loan(String requester, int id) {
        this.startDate = new Date();
        this.id = id;
        this.loanedTo = requester;
        this.available = true;
    }

    public Date getReturnDate(){
        return returnDate;
    }

    public Boolean getActive(){
        return this.available;
    }

    public void returnProduct(){
        this.returnDate = new Date();
        this.available = false;
    }


    public String showInfo(){
        return "Product ID: " +
                this.id +
                ". Requested by: " +
                this.loanedTo +
                ". On: " +
                this.startDate;
    }
}