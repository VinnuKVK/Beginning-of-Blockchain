package com.vin.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtility {

	//applies SHA-256 algo and returns a hash
	public static String applySHA256(String input) {

		StringBuffer hexString = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] hash = messageDigest.digest(input.getBytes("UTF-8"));
			hexString = new StringBuffer();

			String hex = null;
			for(int t=0 ; t<hash.length ; t++) {
				hex = Integer.toHexString(0xff & hash[t]);
				if( hex.length() ==1 ) {
					hexString.append('0');
				} else {
					hexString.append(hex);
				}
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return hexString.toString();

	}

}
