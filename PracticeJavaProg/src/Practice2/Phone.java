package Practice2;

public  class Phone {
	
	public int  phoneNumber  ;
	public String callerID ;
	
	
	Phone (  int a , String id ){
		phoneNumber = a;
		callerID = id;
	}
	
	
	public void receiveCall() {
		System.out.println("receiving call");;
		
	}
	

	public void makeCall() {
		System.out.println("making call");
		
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getCallerID() {
		return callerID;
	}

	
}


