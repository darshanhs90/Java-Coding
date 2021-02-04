package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class _0588DesignInMemoryFileSystem {

	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		System.out.println(fs.ls("/"));
		fs.mkdir("/a/b/c");
		fs.addContentToFile("/a/b/c/d", "hello");
		System.out.println(fs.ls("/"));
		System.out.println(fs.readContentFromFile("/a/b/c/d"));
	}

	static class Directory {
		HashMap<String, Directory> directories;
		HashMap<String, File> files;
		String name;

		public Directory(String name) {
			this.name = name;
			this.files = new HashMap<String, File>();
			this.directories = new HashMap<String, Directory>();
		}

	}

	static class File {
		StringBuilder fileContentBuilder;

		public File(String content) {
			fileContentBuilder = new StringBuilder();
			appendContent(content);
		}

		public void appendContent(String content) {
			fileContentBuilder.append(content);
		}

		public String getContent() {
			return fileContentBuilder.toString();
		}
	}

	static class FileSystem {
		Directory rootDirectory;

		public FileSystem() {
			this.rootDirectory = new Directory("");
		}

		public List<String> ls(String path) {
			String splitPath[] = path.split("/");

			// traverse to last path;
			Directory currDir = this.rootDirectory;
			List<String> list = new ArrayList<String>();
			if (!path.equals("/")) {
				for (int i = 1; i < splitPath.length - 1; i++) {
					currDir = currDir.directories.get(splitPath[i]);
				}

				if (splitPath.length - 1 >= 0 && currDir.files.containsKey(splitPath[splitPath.length - 1])) {
					list.add(splitPath[splitPath.length - 1]);
					return list;
				} else {
					currDir = currDir.directories.get(splitPath[splitPath.length - 1]);
					Iterator<String> iter = currDir.directories.keySet().iterator();
					while (iter.hasNext()) {
						list.add(iter.next());
					}
					return list;
				}
			}
			list.addAll(new ArrayList<>(currDir.directories.keySet()));
			list.addAll(new ArrayList<>(currDir.files.keySet()));
			Collections.sort(list);
			return list;
		}

		public void mkdir(String path) {
			String splitPath[] = path.split("/");
			Directory currDir = this.rootDirectory;
			for (int i = 1; i < splitPath.length; i++) {
				if (!currDir.directories.containsKey(splitPath[i])) {
					currDir.directories.put(splitPath[i], new Directory(splitPath[i]));
				}
				currDir = currDir.directories.get(splitPath[i]);
			}
		}

		public void addContentToFile(String filePath, String content) {
			String splitPath[] = filePath.split("/");
			Directory currDir = this.rootDirectory;
			for (int i = 1; i < splitPath.length - 1; i++) {
				if (!currDir.directories.containsKey(splitPath[i])) {
					currDir.directories.put(splitPath[i], new Directory(splitPath[i]));
				}
				currDir = currDir.directories.get(splitPath[i]);
			}

			String fileName = splitPath[splitPath.length - 1];

			if (currDir.files.containsKey(fileName)) {
				File file = currDir.files.get(fileName);
				file.appendContent(content);
			} else {
				File file = new File(content);
				currDir.files.put(fileName, file);
			}
		}

		public String readContentFromFile(String filePath) {
			String splitPath[] = filePath.split("/");
			Directory currDir = this.rootDirectory;
			for (int i = 1; i < splitPath.length - 1; i++) {
				currDir = currDir.directories.get(splitPath[i]);
			}
			String fileName = splitPath[splitPath.length - 1];

			return currDir.files.get(fileName).getContent();
		}
	}

}
