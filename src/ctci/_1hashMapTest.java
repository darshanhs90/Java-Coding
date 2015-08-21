package ctci;




/*Implementation of Hash Map Data Structure Tester*/
public class _1hashMapTest {
	public static void main(String[] args) {
		_1hashMap map=new _1hashMap();
		System.out.println(map.toString());
		for (int i = 0; i < 300; i++) {
			System.out.println(map.put("darshan","asd"));	
		}
		
		System.out.println(map.toString());
	}
}
