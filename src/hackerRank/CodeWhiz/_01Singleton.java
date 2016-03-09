package hackerRank.CodeWhiz;

class Singleton{
	public static Singleton inst ;
	public String str;
	private Singleton() {

	}
	public static Singleton getSingleInstance () {
		if(inst == null) {
			inst = new Singleton();
		}
		return inst;
	}
}
