package com.numberToword.application;

import org.apache.log4j.Logger;

import com.numberToword.service.NumberToWord;

public class RunApplication {
	final static Logger logger = Logger.getLogger(RunApplication.class);

		 public static void main(String[] args) throws Exception {
			 try{
		        int number = Integer.parseInt(args[0]);
		        NumberToWord numberToWord = new NumberToWord();
		        System.out.println(numberToWord.numberToWord(number));
			 }catch(NumberFormatException e){
				logger.error("This program acepts only Number. Please give valid number");
			 }
			 catch(Exception e){
					logger.error("please try again program intrepted ");
				 }
				 
		    }

}
