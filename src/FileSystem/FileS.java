package FileSystem;

public class FileS implements FileType {
	int size;
	int id;

	FileS(int id, int size) {
		this.id = id;
		this.size = size;
	}

	@Override
	public void ls() {
		System.out.println("hello im file "+id+"with size"+size);
	}

}
