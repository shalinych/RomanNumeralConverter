package com.aem.romannumeralconverter.controller;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aem.romannumeralconverter.exception.InvalidInputRangeException;
import com.aem.romannumeralconverter.exception.InvalidMaxNumberException;
import com.aem.romannumeralconverter.model.RomanNumeralModel;
import com.aem.romannumeralconverter.service.RomanNumeralConverterService;

@SpringBootTest
public class RomanNumeralConverterControllerTest {

	@Autowired
	private RomanNumeralConverterService romanNumeralConverterService;

	@Test
	public void integer400Input_return400RomanNumeral() {

		int input = 400;
		RomanNumeralModel output = romanNumeralConverterService.integerToRomanConversion(input);
		Assertions.assertEquals(output.getOutput(), "CD");
	}

	@Test
	public void inputNegativeNumber_checkForException() {

		int input = -5600;
		Assertions.assertThrows(InvalidInputRangeException.class, () -> {
			romanNumeralConverterService.integerToRomanConversion(input);
		});
	}

	@Test
	public void inputMinMaxValues_returnRangeRomanNumeral() throws Exception {

		int min = 3, max = 7; 
		String output = romanNumeralConverterService.integerToRomanRangeConversion(min,max);


		JSONArray outputArray = new JSONArray();
		JSONObject finalObj = new JSONObject();


		JSONObject expectedJsonObj = new JSONObject();

		expectedJsonObj.put("input",3);
		expectedJsonObj.put("output","III");
		outputArray.put(expectedJsonObj);

		expectedJsonObj = new JSONObject();

		expectedJsonObj.put("input",4);
		expectedJsonObj.put("output","IV");
		outputArray.put(expectedJsonObj);

		expectedJsonObj = new JSONObject();

		expectedJsonObj.put("input",5);
		expectedJsonObj.put("output","V");
		outputArray.put(expectedJsonObj);

		expectedJsonObj = new JSONObject();

		expectedJsonObj.put("input",6);
		expectedJsonObj.put("output","VI");
		outputArray.put(expectedJsonObj);

		expectedJsonObj = new JSONObject();

		expectedJsonObj.put("input",7);
		expectedJsonObj.put("output","VII");
		outputArray.put(expectedJsonObj);


		finalObj.put("conversions", outputArray);
		String expectedOutput = finalObj.toString();

		Assertions.assertEquals(output,expectedOutput);
	}

	@Test
	public void inputMinGreaterThanMax_checkForException() {
		int min = 4, max = 1;
		Assertions.assertThrows(InvalidMaxNumberException.class, () -> {
			romanNumeralConverterService.integerToRomanRangeConversion(min, max);
		});
	}

}
