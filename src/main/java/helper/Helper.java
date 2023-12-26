package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Helper {
	public static String changeToMD5(String password) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    byte[] bytes = md5.digest(password.getBytes());
	    String md5_password = new String(Base64.getEncoder().encode(bytes));
		return md5_password;
	}
}
