package com.aem.romannumeralconverter.controller;

import com.aem.romannumeralconverter.exception.InvalidInputRangeException;
import com.aem.romannumeralconverter.exception.InvalidMaxNumberException;
import com.aem.romannumeralconverter.model.RomanNumeralModel;
import com.aem.romannumeralconverter.service.RomanNumeralConverterService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.codehaus.jettison.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralConverterController {

    private final RomanNumeralConverterService romanNumeralConverterService;

    /**
    This controller is responsible for accepting requests to convert Integer(s) to Roman Numeral(s)
    **/
    
    public RomanNumeralConverterController(RomanNumeralConverterService romanNumeralConverterService) {
        this.romanNumeralConverterService = romanNumeralConverterService;
    }

    /**
     * This RequestMapping takes an Integer and returns Roman Numeral(Extension-1)
     * URI: http://localhost:8080/romannumeral?query=3998
     * Output: MMMCMXCVIII
     */
    @RequestMapping(value = "/romannumeral",params = "query", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RomanNumeralModel> convertIntegerToRoman(@RequestParam("query") Integer input)
            throws InvalidInputRangeException {
        return ResponseEntity.status(HttpStatus.OK).body(romanNumeralConverterService.integerToRomanConversion(input));
    }
    
    
    /**
     * This RequestMapping takes an Integer and returns Roman Numerals in the range of inputs:min & max(Extension-2)
     * URI: http://localhost:8080/romannumeral?min=5&max=8
     * Output: {"conversions":[{"input":5,"output":"V"},{"input":6,"output":"VI"},{"input":7,"output":"VII"},{"input":8,"output":"VIII"}]}
     */
    @RequestMapping(value = "/romannumeral",params = {"min","max"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> convertIntegerToRomanRange(@RequestParam("min") Integer input1 , @RequestParam("max") Integer input2)
            throws InvalidInputRangeException, InvalidMaxNumberException, JSONException, InterruptedException, ExecutionException {
        return ResponseEntity.status(HttpStatus.OK).body(romanNumeralConverterService.integerToRomanRangeConversion(input1,input2));
    }
    
}
