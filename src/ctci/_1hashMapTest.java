package ctci;




/*Implementation of Hash Map Data Structure Test Case*/
public class _1hashMapTest {
	public static void main(String[] args) {
		_1hashMap map=new _1hashMap();
		System.out.println(map.toString());
		map.put("darshan","asd");
		System.out.println(map.get("asdasd"));
		System.out.println(map.get("darshan"));
		System.out.println(map.toString());
		System.out.println(map.delete("darshan"));
		System.out.println(map.delete("asdasd"));
		System.out.println(map.toString());
	}
}
