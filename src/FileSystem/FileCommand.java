package FileSystem;

import java.util.*;

public class FileCommand {
	public static void main(String[] args) {
		List<FileType> l1 = new ArrayList<>();

		Folder child = new Folder(22, l1);
		FileS f1 = new FileS(1, 20);
		FileS f2 = new FileS(2, 20);
		List<FileType> l = new ArrayList<>();
		l.add(f1);
		l1.add(f2);
		l.add(child);
		Folder parent = new Folder(11, l);

		parent.ls();
		

		

	}
}
