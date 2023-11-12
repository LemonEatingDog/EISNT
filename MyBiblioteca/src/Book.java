import java.io.Serializable;

public class Book extends Product implements IProducts, Serializable {

    Long isbn;

    public Book(String title, String author, int pubYear, String condition, Long isbn) {
        super(title, author, pubYear, condition, ProductsDAO.setId());
        this.isbn=isbn;
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
                this.id +
                ". \nISBN: " +
                this.isbn;
    }

    @Override
    public String showInfo() {
        return this.title +
                ". Internal ID: " +
                this.id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setComment(String comment) {
        this.condition = comment;
    }

    @Override
    public boolean setInactive(boolean b) {
        this.active = b;
        return false;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }
}