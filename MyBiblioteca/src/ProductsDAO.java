import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsDAO {

    List<IProducts> products;

    public ProductsDAO(){
        products = new ArrayList<>();
    }

    public void addProduct(IProducts product) {

        // Verifica se é um Livro ou DVD
        // Para guardar no ficheiro correto
        String nomeFicheiro = product.
                getClass().
                toString().equals("class Book") ? "books.txt" : "dvd.txt";

        DataFile.writeFile(product, nomeFicheiro);

        // Adiciona à lista
        addToMemory(product);
    }

    public void addToMemory(IProducts product) {
        this.products.add(product);
    }

    public static int setId(){
        return Main.productsDAO.products.size() + 1;
    }

    public Optional<IProducts> searchId(int searchId){
        for (IProducts product : this.products) {
            if(product.getId() == searchId){
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Book> listBooks(){

        List<Book> results = new ArrayList<>();

        for(IProducts product: this.products){

            if (product instanceof Book){
                results.add((Book) product);
            }
        }

        return results;
    }

    public List<DVD> listDvds(){

        List<DVD> results = new ArrayList<>();

        for(IProducts product: this.products){

            if (product instanceof DVD){
                results.add((DVD) product);
            }
        }

        return results;
    }

    /*public Optional<IProducts> searchId(int pid) {

        for (IProducts product : this.products) {
            if(product.)

        }

    }*/

    /*public void updateItem(String comment){

    }*/
}