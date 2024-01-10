package Important;

public class Taking_any_no_of_ip_parameters {
	
	public int anyNoOfIpParameters(int...num) {//three dot means any number of input parameter we can take
		//and the values will be stored in an array num
		int length=num.length;
		int sum=0;
		for(int i=0;i<length;i++) {
			sum+=num[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		Taking_any_no_of_ip_parameters e=new Taking_any_no_of_ip_parameters();
		System.out.println(e.anyNoOfIpParameters(1,3,4,5,6));

	}

}
