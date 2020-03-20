import java.io.IOException;

public class Lab5 {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InvalidCatalogException {
			Lab5 app = new Lab5();
			app.testCreateSave();
			//app.testLoadView();
		}

			 private void testCreateSave() throws IOException {
			 Catalog catalog = new Catalog("Exemplu 1", "C:\\Users\\tudor\\eclipse-workspace\\Lab5\\text.txt");
			 Document doc = new Document("java1", "Java Course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
			 doc.addTag("type", "Slides");
			 
			 catalog.add(doc);

			CatalogUtil.save(catalog);
			 }

			 /*private void testLoadView() throws ClassNotFoundException, IOException, InvalidCatalogException {
			 Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
			 Document doc = catalog.findById("java1");
			 CatalogUtil.view(doc);
			 }
*/
}
