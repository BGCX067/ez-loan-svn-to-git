package com.ez.common.util;

public class JUtils {

	public int[] convertStringArraytoIntArray(String[] sarray) {
		if (sarray != null) {
			int intarray[] = new int[sarray.length];
			for (int i = 0; i < sarray.length; i++) {
				intarray[i] = Integer.parseInt(sarray[i]);
			}
			return intarray;
		}
		return null;
	}

}
