package Validation;

public class ValidTextNull {
	public Boolean isNull(String str) {
		if(str.isEmpty()) {
			return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		ValidTextNull vl = new ValidTextNull();
		System.out.println(vl.isNull(""));
	}
}
