import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class CatalogUtil {
	public static void save(Catalog catalog) throws IOException {
		try{
			FileOutputStream fo = new FileOutputStream(catalog.getPath());
			ObjectOutputStream oos = new ObjectOutputStream(fo);
			oos.writeObject(catalog);
			oos.close();
			System.out.println(catalog.getName());
		 } catch (FileNotFoundException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 } 
 }
	/*public static Catalog load(String path) throws InvalidCatalogException, ClassNotFoundException, IOException{
			 try {
				 FileInputStream fi = new FileInputStream(path);
				 ObjectInputStream input = new ObjectInputStream(fi);
				 
				 Nu am facut load-ul; nu am inteles ce cere functia aceasta si nici
				 nu am stiut cum sa o implementez
				 
				 
			 }
			}
			*/
		public static void view(Document doc) throws IOException, InvalidCatalogException, ClassNotFoundException{
			 Desktop desktop = Desktop.getDesktop();
			 File file = new File("C:\\Users\\tudor\\eclipse-workspace\\Lab5");
			 if(!Desktop.isDesktopSupported()){
				 System.out.println("ERROR");
		            return;
		        }
			 if(file.exists()) desktop.open(file);
			 }
			
		}
			

