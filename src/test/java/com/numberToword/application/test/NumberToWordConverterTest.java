package com.numberToword.application.test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.numberToword.service.NumberToWordConverter;

@RunWith(Parameterized.class)
public class NumberToWordConverterTest {
	private int input;
    private String expected;
    
    public NumberToWordConverterTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }
	
	 @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	                 { 105, "one hundred and five" }, {56945781 , "fifty six million nine hundred and forty five thousand seven hundred and eighty one" }, { 105, "one hundred and five" }
	                 //The first item in the array is the input, and second is the expected outcome.
	           });
	    }
	
	@Test
	public void testNumberToWordConverter(){
		
		NumberToWordConverter test=new NumberToWordConverter();
		try {
	        assertEquals(test.numberToWordConvert(input), expected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
