package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

	static class File {
		String name, content;

		public File(String name, String content) {
			this.name = name;
			this.content = "";
			this.appendContent(content);
		}

		public void appendContent(String content) {
			this.content += content;
		}
	}

	static class Directory {
		HashMap<String, Directory> directories;
		HashMap<String, File> files;
		String dirName;

		public Directory(String dirName) {
			this.directories = new HashMap<String, Directory>();
			this.files = new HashMap<String, File>();
			this.dirName = dirName;
		}
	}

	static class FileSystem {
		Directory rootDir;

		public FileSystem() {
			rootDir = new Directory("/");
		}

		public List<String> ls(String path) {
			List<String> output = new ArrayList<String>();
			if (path.equals("/")) {
				if (rootDir.directories.size() > 0) {
					output.addAll(rootDir.directories.keySet());
				}

				if (rootDir.files.size() > 0) {
					output.addAll(rootDir.files.keySet());
				}
			} else {
				String[] arr = path.split("/");
				Directory dir = rootDir;
				for (int i = 1; i < arr.length; i++) {
					String dirName = arr[i];
					if (!dir.directories.containsKey(dirName)) {
						return output;
					}
					dir = dir.directories.get(dirName);
				}

				if (dir.directories.size() > 0) {
					output.addAll(dir.directories.keySet());
				}

				if (dir.files.size() > 0) {
					output.addAll(dir.files.keySet());
				}
			}
			Collections.sort(output);
			return output;
		}

		public void mkdir(String path) {
			String[] arr = path.split("/");
			Directory dir = rootDir;
			for (int i = 1; i < arr.length; i++) {
				String dirName = arr[i];
				if (!dir.directories.containsKey(dirName)) {
					Directory newDir = new Directory(dirName);
					dir.directories.put(dirName, newDir);
				}
				dir = dir.directories.get(dirName);
			}
		}

		public void addContentToFile(String filePath, String content) {
			String[] arr = filePath.split("/");
			Directory dir = rootDir;
			for (int i = 1; i < arr.length - 1; i++) {
				String dirName = arr[i];
				if (!dir.directories.containsKey(dirName)) {
					Directory newDir = new Directory(dirName);
					dir.directories.put(dirName, newDir);
				}
				dir = dir.directories.get(dirName);
			}
			String fileName = arr[arr.length - 1];
			if (dir.files.containsKey(fileName)) {
				dir.files.get(fileName).appendContent(content);
			} else {
				File file = new File(fileName, content);
				dir.files.put(fileName, file);
			}
		}

		public String readContentFromFile(String filePath) {
			String[] arr = filePath.split("/");
			Directory dir = rootDir;
			for (int i = 1; i < arr.length - 1; i++) {
				String dirName = arr[i];
				if (!dir.directories.containsKey(dirName)) {
					return "";
				}
				dir = dir.directories.get(dirName);
			}
			String fileName = arr[arr.length - 1];
			return dir.files.get(fileName).content;
		}
	}

}
