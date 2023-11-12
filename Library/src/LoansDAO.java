import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoansDAO {

    List<Loan> loans;

    public LoansDAO(){
        this.loans = new ArrayList<>();
    }

    public void addLoan(Loan loan){
        this.loans.add(loan);
    }

    public Optional<Loan> searchId(int id){
        for (Loan loan : this.loans) {
            if(loan.id == id){
                return Optional.of(loan);
            }
        }
        return Optional.empty();
    }

}
