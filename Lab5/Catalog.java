import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
	 
		private String name;
		private String path;
		
		private List<Document> documents = new ArrayList<>();
		
		//constructor
		public Catalog(String name, String path) {
			this.name = name;
			this.path = path;
		}
		
		//add doc
		public void add(Document doc) {
			 documents.add(doc);
			 }

		//find by ID
		public Document findById(String ID) {
			try { for(Document d : documents)
				 {if(d.getId().equals(ID))
					 return d;
				 }
			}catch(StringIndexOutOfBoundsException nsme)
			{
				System.out.println("Documentul cu ID-ul respectiv nu exista.");
			}
			return null;
			 }
		//setteres + getters
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public List<Document> getDocuments() {
			return documents;
		}

		public void setDocuments(List<Document> documents) {
			this.documents = documents;
		}
}
