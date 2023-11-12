import java.io.Serializable;

public class DVD extends Product implements IProducts, Serializable {

    public DVD(String title, String creator, int pubYear, String condition) {
        super(title, creator, pubYear, condition, ProductsDAO.setId());
    }

    @Override
    public String showFullInfo() {
        return this.title +
                " by " +
                this.creator +
                " published in " +
                this.pubYear +
                ".\nCondition: " +
                this.condition +
                ". Internal ID: " +
                this.id;
    }

    @Override
    public String showInfo() {
        return this.title +
                ". Internal ID: " +
                this.id;
    }

    @Override
    public void setComment(String condition) {
        this.condition = condition;
    }

    @Override
    public boolean setInactive(boolean b) {
        this.active = b;
        return false;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }

}