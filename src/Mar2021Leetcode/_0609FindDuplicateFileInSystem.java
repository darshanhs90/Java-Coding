package Mar2021Leetcode;

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
		HashMap<String, List<String>> contentToPathMap = new HashMap<String, List<String>>();
		for (String path : paths) {
			String arr[] = path.split(" ");
			String rootPath = arr[0];
			for (int i = 1; i < arr.length; i++) {
				String file = arr[i];
				String fileArr[] = file.split("\\(");

				String fileName = fileArr[0];
				String fileContent = fileArr[1];
				fileContent = fileContent.substring(0, fileContent.length() - 1);

				if (!contentToPathMap.containsKey(fileContent)) {
					contentToPathMap.put(fileContent, new ArrayList<String>());
				}

				contentToPathMap.get(fileContent).add(rootPath + "/" + fileName);
			}
		}

		List<List<String>> output = new ArrayList<List<String>>();
		for (Map.Entry<String, List<String>> entry : contentToPathMap.entrySet()) {
			if (entry.getValue().size() > 1) {
				output.add(entry.getValue());
			}
		}
		return output;
	}
}
