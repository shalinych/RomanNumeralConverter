package com.aem.romannumeralconverter.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;

import com.aem.romannumeralconverter.constants.RomanNumeralConverterConstants;
import com.aem.romannumeralconverter.exception.InvalidInputRangeException;
import com.aem.romannumeralconverter.exception.InvalidMaxNumberException;
import com.aem.romannumeralconverter.model.RomanNumeralModel;

@Service
public class RomanNumeralConverterService {

	/**
	 * Returns a Roman Numeral in the form of an object of type RomanNumeral for any
	 * Integer input given. An Integer in the range of 1 to 3999 is passed as a
	 * parameter to this method(Extension-1)
	 * 
	 * @param input
	 * @return RomanNumeralModel with input and output.
	 * @throws InvalidInputRangeException
	 */
	public RomanNumeralModel integerToRomanConversion(Integer input) throws InvalidInputRangeException {

		String output = "";

		if (input <= 0 || input > 3999) {

			throw new InvalidInputRangeException(RomanNumeralConverterConstants.INVALID_INPUT_RANGE_ERROR_MESSAGE);
		}

		output = computeRomanValue(input);
		return RomanNumeralModel.builder().input(input.toString()).output(output).build();

	}

	/**
	 * Inputs to this service are input1(min) & input2(max) which returns an array
	 * of objects of Roman Numerals in the range of input1(min) & input2(max)
	 * 
	 * @param input1
	 * @param input2
	 * @return Roman Numerals as array of Objects of type RomanNumeralModel
	 * @throws InvalidInputRangeException
	 * @throws InvalidMaxNumberException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public String integerToRomanRangeConversion(Integer input1, Integer input2) throws InvalidInputRangeException,
			InvalidMaxNumberException, JSONException, InterruptedException, ExecutionException {

		JSONObject outputObj = new JSONObject();
		try {
			String output = "";

			if (input1 <= 0 || input1 > 3999 || input2 <= 0 || input2 > 3999) {

				throw new InvalidInputRangeException(RomanNumeralConverterConstants.INVALID_INPUT_RANGE_ERROR_MESSAGE);
			}

			if (input1 >= input2) {
				throw new InvalidMaxNumberException(RomanNumeralConverterConstants.INPUT_ERROR_MESSAGE);
			}

			JSONArray outputArray = new JSONArray();

			for (int input = input1; input <= input2; input++) {

				output = getRomanValue(input).get();
				JSONObject obj = new JSONObject();
				obj.put("input", input);
				obj.put("output", output);
				outputArray.put(obj);
			}

			outputObj.put("conversions", outputArray);

		} finally {

		}
		return outputObj.toString();
	}

	/**
	 * A non-blocking asynchronous way of executing which returns the required
	 * value. By making the method asynchronous, we can complete one operation while
	 * waiting for the other to finish.
	 * 
	 * @param input1
	 * @param input2
	 * @throws InvalidInputRangeException
	 * @throws InvalidMaxNumberException
	 */

	public Future<String> getRomanValue(int input) {
		return CompletableFuture.supplyAsync(() -> computeRomanValue(input)).thenApply(romanValue -> {
			return romanValue;
		});
	}

	private String computeRomanValue(int input) {
		return RomanNumeralConverterConstants.THOUSANDS[input / 1000]
				+ RomanNumeralConverterConstants.HUNDREDS[(input % 1000) / 100]
				+ RomanNumeralConverterConstants.TENS[(input % 100) / 10]
				+ RomanNumeralConverterConstants.UNITS[input % 10];
	}
}
