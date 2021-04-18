package April2021PrepLeetcode;

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
		List<List<String>> output = new ArrayList<List<String>>();
		if (paths == null || paths.length == 0)
			return output;

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (String path : paths) {
			String[] pathArr = path.split(" ");
			String basePath = pathArr[0];
			for (int i = 1; i < pathArr.length; i++) {
				String subPath = pathArr[i];
				String[] subArr = subPath.split("\\(");

				String fileName = subArr[0];
				StringBuilder fileContent = new StringBuilder(subArr[1]);
				fileContent.deleteCharAt(fileContent.length() - 1);

				String combinedFilePath = basePath + "/" + fileName;

				if (!map.containsKey(fileContent.toString())) {
					map.put(fileContent.toString(), new ArrayList<String>());
				}

				map.get(fileContent.toString()).add(combinedFilePath);
			}
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getValue().size() >= 2) {
				output.add(entry.getValue());
			}
		}
		return output;
	}
}
