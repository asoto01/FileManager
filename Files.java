package filemanager;

public class Files {

	int id =0;
	String name, path;
	
	public Files(String name, String path) {
		this.name = name;
		this.path = path;
		id++;
	}

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
	
	public int getId() {
		return id;
	}
	
}
