import java.io.Serializable;

public interface IProducts extends Serializable {

    String showFullInfo();

    String showInfo();

    int getId();

    void setComment(String comment);

    boolean setInactive(boolean b);

    boolean isActive();

}
