package pl.boguszg.impulse.model;

public class Summary {

	//Day, week, month
	private String period;
	//call, text, data_transfer
	private String type;
	//Number of connections
	private int count;
	//Total value of connections in summary [min/texts/KB]
	private int value;
	
	public Summary() {}
	
	
	
//	public Summary(String userName, String type, String period) {
//		this.period = "all";
//		this.type = type;
//		this.count = countConnections(userName, type, period);
//		this.value = valueConnections(userName, type, period);
//		
//	}
//	
//	private int countConnections(String userName, String type, String period) {
//		dialer = 
//		switch (type){
//		case "call":
//			connectionsList =  
//			break;
//		case "text":
//			break;
//		case "transfer":
//			break;
//		}
//		return count;
//	}
//	
//	private int valueConnections(String userName, String type, String period) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	
	
}
