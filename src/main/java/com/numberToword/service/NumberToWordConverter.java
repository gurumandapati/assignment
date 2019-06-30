package com.numberToword.service;

import static com.numberToword.constants.AppConstants.UP_TO_NUM_19;
import static com.numberToword.constants.AppConstants.HUNDRED;
import static com.numberToword.constants.AppConstants.AND;
import static com.numberToword.constants.AppConstants.DENOM;
import static com.numberToword.constants.AppConstants.TENS;
import org.apache.log4j.Logger;


/**
 * This class contains the logic of convert the number to English
 * 
 */

public class NumberToWordConverter {
	final static Logger logger = Logger.getLogger(NumberToWordConverter.class);
	
	/**
	 * this method purpose is to convert the number to English word less than
	 * 100
	 *
	 * @param value
	 *            number to be converted in to English word
	 * 
	 * @return It returns the converted number to words.
	 *
	 * @throws Exception
	 *             
	 *
	 * 
	 */

	private String convertUpToHundred(int value) throws Exception {
		if (value < 20)
			return UP_TO_NUM_19[value];
		for (int v = 0; v < TENS.length; v++) {
			String dcap = TENS[v];
			int dval = 20 + 10 * v;
			if (dval + 10 > value) {
				if ((value % 10) != 0)
					return dcap + " " + UP_TO_NUM_19[value % 10];
				return dcap;
			}
		}
		throw new Exception("Should never get here, less than 100 failure");
	}

	

	/**
	 * this method purpose is to convert the number to English word less than
	 * 1000.It calls convertUpToHundred method level that kicks off the < 100 special case. The rest are more general. 
	 * 
	 * @param value
	 *            number to be converted in to English word
	 * 
	 * @return It returns the converted number to words.
	 *
	 * @throws Exception
	 *          
	 *
	 * 
	 */
	private String convertUpToThousand(int value) throws Exception {
		String word = "";
		int remainder = value / 100;
		int mod = value % 100;
		if (remainder > 0) {
			word = UP_TO_NUM_19[remainder] + HUNDRED;
			if (mod > 0) {
				word = word +AND+" ";
			}
		}
		if (mod > 0) {
			word = word + convertUpToHundred(mod);
		}
		return word;
	}
	
	/**
	 * this method purpose is to convert the number to English word 
	 * @param value
	 *            number to be converted in to English word
	 * 
	 * @return It returns the converted number to final completed words.
	 *
	 * @throws Exception
	 *          
	 *
	 * 
	 */
	public String numberToWordConvert(int val) throws Exception {
		if (val < 100) {
			return convertUpToHundred(val);
		}
		if (val < 1000) {
			return convertUpToThousand(val);
		}
		for (int i = 0; i < DENOM.length; i++) {
			int didx = i - 1;
			int dval = new Double(Math.pow(1000, i)).intValue();
			if (dval > val) {
				int mod = new Double(Math.pow(1000, didx)).intValue();
				int l = val / mod;
				int r = val - (l * mod);
				String ret = convertUpToThousand(l) + " " + DENOM[didx];
				if (r > 0) {
					ret = ret + " " + numberToWordConvert(r);
				}
				return ret;
			}
		}
		throw new Exception("Should never get here, bottomed out in numberToWordConvert");
		
	}
}