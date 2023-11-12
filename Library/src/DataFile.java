import java.io.*;

public class DataFile {
    public static void writeFile(IProducts product, String nomeFicheiro) {
        try {
            FileOutputStream file = new FileOutputStream(nomeFicheiro, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(file);

            objectOut.writeObject(product);

            objectOut.close();
            file.close();

        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static void readFile(ProductsDAO productsDAO, String nomeFicheiro) {
        try {
            File yourFile = new File(nomeFicheiro);
            yourFile.createNewFile();
            FileInputStream file = new FileInputStream(nomeFicheiro);
            boolean haMais = true;
            while(haMais) {
                ObjectInputStream objectIn = new ObjectInputStream(file);
                Object obj = null;
                try {
                    obj = objectIn.readObject();
                } catch (Exception e) {
                }
                if(obj != null) {
                    productsDAO.addToMemory((IProducts)obj);
                } else {
                    haMais = false;
                }
            }

            file.close();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
