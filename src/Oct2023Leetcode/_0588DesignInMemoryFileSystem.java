package Oct2023Leetcode;

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

	static class FileSystem {

		public FileSystem() {
		}

		public List<String> ls(String path) {

		}

		public void mkdir(String path) {
		}

		public void addContentToFile(String filePath, String content) {

		}

		public String readContentFromFile(String filePath) {

		}
	}

}
