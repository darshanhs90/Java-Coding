package DropboxPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0609FindDuplicateFileInSystem {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new String[] { "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)",
				"root/c/d 4.txt(efgh)", "root 4.txt(efgh)" }));
	}

	public static List<List<String>> findDuplicate(String[] paths) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < paths.length; i++) {
			String pathString = paths[i];
			String directory[] = pathString.split(" ");
			String dirPath = directory[0];
			for (int j = 1; j < directory.length; j++) {
				String fileNameArr[] = directory[j].split("\\(");
				String fileName = fileNameArr[0];
				String fileContent = fileNameArr[1];
				fileContent = fileContent.substring(0, fileContent.length() - 1);

				if (map.containsKey(fileContent)) {
					map.get(fileContent).add(dirPath + "/" + fileName);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(dirPath + "/" + fileName);
					map.put(fileContent, list);
				}
			}
		}
		List<List<String>> output = new ArrayList<List<String>>();

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getValue().size() > 1)
				output.add(entry.getValue());
		}

		return output;
	}
}
