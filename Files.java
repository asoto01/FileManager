package filemanager;

public class Files {

	int id =0;
	String name;
	
	public Files(String name) {
		this.name = name;
		id++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
}
