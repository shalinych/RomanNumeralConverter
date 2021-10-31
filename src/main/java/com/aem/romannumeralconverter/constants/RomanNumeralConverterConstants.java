package com.aem.romannumeralconverter.constants;

public class RomanNumeralConverterConstants {

	public static final String[] UNITS = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	public static final String[] TENS = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	public static final String[] HUNDREDS = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	public static final String[] THOUSANDS = { "", "M", "MM", "MMM" };

	public static final String INVALID_INPUT_RANGE_ERROR_MESSAGE = "Invalid input. Input should be in the range of 1-3999 numbers";
	public static final String INVALID_INPUT_ERROR_MESSAGE = "Invalid input. Input should be positive integers";
	public static final String INVALID_URI_ERROR_MESSAGE = "Invalid URI";
	public static final String INPUT_ERROR_MESSAGE = "Min value should be less than Max";

}
