import java.io.Serializable;

public class Product implements Serializable {

    String title;
    String creator;
    int pubYear;
    String condition;
    boolean active;
    int id;

    public Product(String title, String creator, int pubYear, String condition, int id) {

        this.title = title;
        this.creator = creator;
        this.pubYear = pubYear;
        this.condition = condition;
        this.active = true;
        this.id = id;
    }

}