package eduraka;



// once we create subclass of abstract class, either that subclass has to implement unimplemented method of AbstractClass OR this subclass has to be abstract as well.
public class SubclassAbstract extends AbstractClass{

	@Override
	public int multuply(int x, int y) {
		// TODO Auto-generated method stub
		return x*y*2;
	}
	
	public static class MySingleton {
		private String companyName;
		private static MySingleton instance = null;
		
		private MySingleton(String com) {
			this.companyName = com;
		}
		
		public static MySingleton getInstance(String com) {
			if (instance==null) {
				instance = new MySingleton(com);
			}
			return instance;
		}
		
		public String getCompany() {
			return companyName;
		}
		
	}

}
