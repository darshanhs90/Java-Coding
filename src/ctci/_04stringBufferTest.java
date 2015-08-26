package ctci;


/*Implementation of StringBuffer Data Structure Tester*/
public class _04stringBufferTest {
	public static void main(String[] args) {
		_04stringBuffer stringBuffer=new _04stringBuffer();
		stringBuffer.append('c');
		System.out.println(stringBuffer.toString());
		stringBuffer.append("2ndstring");
		System.out.println(stringBuffer.toString());
		stringBuffer.append(1);
		System.out.println(stringBuffer.toString());
		System.out.println(stringBuffer.length());
		stringBuffer.deleteCharAt(3);
		System.out.println(stringBuffer.toString());
		stringBuffer.delete(0,4);
		System.out.println(stringBuffer.toString());
		stringBuffer.setLength(4);
		System.out.println(stringBuffer.toString());
		stringBuffer.setLength(14);
		System.out.println(stringBuffer.toString());
		stringBuffer.reverse();
		System.out.println(stringBuffer.toString());
		
	}
}
