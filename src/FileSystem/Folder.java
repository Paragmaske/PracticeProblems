package FileSystem;

import java.util.List;

public class Folder implements FileType {
	int id;
	List<FileType> content;

	public Folder(int id, List<FileType> content) {
		this.id = id;
		this.content = content;
	}

	@Override
	public void ls() {

		for (FileType f : content) {
			f.ls();
		}
	}

}
