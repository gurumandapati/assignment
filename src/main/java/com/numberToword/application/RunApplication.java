package com.numberToword.application;

import org.apache.log4j.Logger;

import com.numberToword.exception.ValidationException;
import com.numberToword.service.NumberToWordConverter;

public class RunApplication {
	final static Logger logger = Logger.getLogger(RunApplication.class);

	public static void main(String[] args) throws Exception {
		try {

			int number = validateInput(args);

			NumberToWordConverter numberToWord = new NumberToWordConverter();
			System.out.println(number +"="+numberToWord.numberToWordConvert(number));
		} catch (ValidationException e) {
			logger.error(" ERROR :: " + e.getMessage());
		} catch (Exception e) {
			logger.error("please try again program terminated ");
		}

	}

	private static int validateInput(final String[] args) throws ValidationException {
		logger.info("Validating The Input");
		if (args.length != 1) {
			throw new ValidationException("Invalid Input.Please supply one Input number to program");
		} else {
			try {
				int number= Integer.parseInt(args[0].trim());
				if(number>999999999)
					throw new ValidationException("Input range is exceeded please pass the number below 999999999");
				
				logger.info("Input Validation Success");
				return number;
			} catch (NumberFormatException e) {
				throw new ValidationException("Please supply the numeric numbers");

			}

		}
		
	}

}
