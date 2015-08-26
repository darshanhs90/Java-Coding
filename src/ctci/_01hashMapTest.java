package ctci;




/*Implementation of Hash Map Data Structure Tester*/
public class _01hashMapTest {
	public static void main(String[] args) {
		_01hashMap map=new _01hashMap();
		System.out.println(map.toString());
		for (int i = 0; i < 300; i++) {
			System.out.println(map.put("darshan","asd"));	
		}
		
		System.out.println(map.toString());
	}
}
