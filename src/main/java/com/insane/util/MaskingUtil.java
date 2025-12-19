package com.insane.util;

import org.springframework.stereotype.Component;

@Component
public final class MaskingUtil {
	
 public static String maskPan(String pan) {
	        if (pan == null || pan.length() < 5) return pan;
	        return "*****" + pan.substring(pan.length() - 5);
	    }

	    public static String maskAadhaar(String aadhaar) {
	        if (aadhaar == null || aadhaar.length() < 4) return aadhaar;
	        return "********" + aadhaar.substring(aadhaar.length() - 4);
	    }
}


