import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import static java.lang.System.in;

public class Main {

    public static String user = System.getProperty("user.name");
    public static int choice;
    public static int choiceVal;
    public static ProductsDAO productsDAO = new ProductsDAO();
    public static LoansDAO loansDAO = new LoansDAO();

    public static void main(String[] args) {

        DataFile.readFile(productsDAO, "books.txt");
        DataFile.readFile(productsDAO, "dvd.txt");

        boolean repeat = true;

        do{
            System.out.println("\nWelcome " + user + "!");
            System.out.println("Please select your option:");
            System.out.println("1 - Products\n2 - Loans\n3 - Exit");

            choiceVal = 3;
            choiceLoop();

            switch (choice){
                case 1:
                    productsMenu();
                    break;

                case 2:
                    loansMenu();
                    break;

                case 3:
                    System.out.println("Exiting the application, see you soon " + user + "!");
                    repeat = false;
                    break;
            }

        } while (repeat == true);

    }

    private static int productsMenu() {

        Scanner input = new Scanner(in);

        System.out.println("\nPlease select your option: ");
        System.out.println("1 - Create a new entry");
        System.out.println("2 - Update an item");
        System.out.println("3 - List all items");
        System.out.println("4 - List books");
        System.out.println("5 - List DVDs");
        System.out.println("6 - Delete an item");
        System.out.println("7 - Return to main menu");

        choiceVal = 7;
        choiceLoop();

        switch (choice){
            case 1:
                newProduct();
                break;

            case 2:

                System.out.println("Please insert the internal ID of the item you want to update: \n");
                int searchId = input.nextInt();
                input.nextLine();

                Optional <IProducts> productSearch = productsDAO.searchId(searchId);
                if(productSearch.isPresent()){

                    System.out.println(productSearch.get().showInfo());
                    System.out.println("Please type in the relevant info: ");
                    String update = input.nextLine();

                    productSearch.get().setComment(update);
                    System.out.println(productSearch.get().showFullInfo());


                } else {
                    System.out.println("Invalid ID inserted, please try again.");
                }

                productsMenu();
                break;

            case 3:

                for(IProducts product : productsDAO.products) {
                    System.out.println(product.showFullInfo()+"\n");
                }

                productsMenu();
                break;

            case 4:
                List<Book> books = productsDAO.listBooks();

                for(Book book : books){
                    System.out.println(book.showFullInfo()+"\n");
                }

                productsMenu();
                break;

            case 5:
                List<DVD> dvds = productsDAO.listDvds();

                for(DVD dvd : dvds){
                    System.out.println(dvd.showFullInfo()+"\n");
                }

                productsMenu();
                break;

            case 6:

                System.out.println("Please insert the internal ID of the item you want to update: \n");
                int delId = input.nextInt();
                input.nextLine();

                Optional <IProducts> deleteSearch = productsDAO.searchId(delId);
                if(deleteSearch.isPresent()){

                    System.out.println(deleteSearch.get().setInactive(false));
                    System.out.println(deleteSearch.get().showInfo() + "has been successfully disabled!");

                } else {
                    System.out.println("Invalid ID inserted, please try again.");
                }

                productsMenu();
                break;

            case 7:
                return 1;
        }

        return 1;
    }

    private static void loansMenu(){

        Scanner input = new Scanner(System.in);

        System.out.println("\nPlease select your option: ");
        System.out.println("1 - Create a new entry");
        System.out.println("2 - Return an item");
        System.out.println("3 - Check all ongoing loans");
        System.out.println("4 - Return to main menu");

        choiceVal = 4;
        choiceLoop();

        switch (choice){

            case 1:

                for(IProducts product : productsDAO.products) {
                    System.out.println(product.showInfo()+"\n");
                }

                System.out.println("Please input the requesters name: ");
                String requester = input.nextLine();

                System.out.println("Please insert the products ID: ");
                int id = input.nextInt(); //missing id check
                input.nextLine();

                Loan loan = new Loan(requester, id);
                Main.loansDAO.addLoan(loan);

                loansMenu();
                break;

            case 2:

                System.out.println("Please insert the products ID:");
                int searchId = input.nextInt();

                Optional<Loan> loanFound =loansDAO.searchId(searchId);

                if(loanFound.isPresent()){
                    loanFound.get().returnProduct();
                    System.out.println("Product successfully returned!");
                } else {
                    System.out.println("This product has no data associated.");
                }

                loansMenu();
                break;

            case 3:

                for(Loan lent: loansDAO.loans){
                    System.out.println(lent.showInfo());
                }

                loansMenu();
                break;

            case 4:
                return;
        }

        //return;
    }

    private static void choiceLoop(){

        int i = (choiceVal + 1); // Holds the range value so it isn't lost and keeps the loop running

        Scanner input = new Scanner(in);

        do{
            try{
                choice = input.nextInt();
                if ((choice <= 0) || (choice >= i)){
                    System.out.println("Please input a valid number from the list.");
                }
            } catch (Exception e){
                System.out.println("Please input a number.");
                input.nextLine();
            }
        }while ((choice <= 0) || (choice >= i));

    }

    private static void newProduct(){

        Scanner input = new Scanner(System.in);

        //boolean repeat = false;

        //do{
            System.out.println("Please insert the title: ");
            String title = input.nextLine();

            System.out.println("Who created " + title + " ?");
            String creator = input.nextLine();

            System.out.println("What year was " + title + " published?");
            int pubYear;

            while(true) {
                try {
                    pubYear = input.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Please input a number.");
                    input.nextLine();
                }
            }

            input.nextLine(); //clean loop input

            System.out.println("In what condition is the item?");
            String commment = input.nextLine();

            System.out.println("Is it a book or a DVD?\n1 - Book\n2 - DVD");

            choiceVal = 2;
            choiceLoop();

            switch (choice){
                case 1:

                    while(true) {

                        System.out.println("What's " + title + "'s ISBN?");
                        Long isbn = input.nextLong();
                        int isbnLength = String.valueOf(isbn).length();

                        if (isbnLength != 10 && isbnLength != 13){

                            do{
                                System.out.println("Invalid ISBN, please try again.");
                                break;

                            }while (isbnLength != 10 && isbnLength != 13);

                        }else{
                            Book book = new Book(title, creator, pubYear, commment, isbn);
                            Main.productsDAO.addProduct(book);
                            break;
                        }

                    }
                    break;

                case 2:

                    DVD dvd = new DVD(title, creator, pubYear, commment);
                    Main.productsDAO.addProduct(dvd);
                    break;
            }

            System.out.println("Would you like to insert another product?\n1 - Yes\n2 - No");

            choiceVal = 2 ;
            choiceLoop();

            switch (choice){
                case 1:
                    input.nextLine();
                    newProduct();
                    break;

                case 2:
                    productsMenu();
                    break;
            }

        //} while(!repeat);
    }

}