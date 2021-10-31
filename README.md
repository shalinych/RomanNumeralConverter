
## Contents

* [About The Project](#about-the-project)
* [Built With](#built-with)
* [Building and Running Project](#building-and-running-project)
* [Prerequisites](#prerequisites)
* [Testing Methodology](#testing-methodology)
* [Engineering Methodology](#engineering-methodology)
* [Packaging Layout](#packaging-layout)
* [References](#references)

## About The Project :

This application takes in Integer(s) and converts into Roman Numeral(s). This project includes functionality from Extension-1 & Extension-2. The integer supporting range 1-3999 can use the following URI: 'http://localhost:8080/romannumeral?query={integer}' and to be able to display all numerals in the range 'min' to 'max' can use this URI: http://localhost:8080/romannumeral?min={integer}&max={integer}.

## Built With:

* Java SpringBoot 
* REST APIs 
* JUnit for unit testing 
* Spring Tool Suite

## Building and Running Project:


The project can be built as a 'Spring Boot App' if using Spring Tool Suite. Once the application is up and running, any of the below URI can be accessed via browser or any other API testing tool(Postman etc.,)

This URI supports integers from 1-3999 as per Extension-1

http://localhost:8080/romannumeral?query={integer} 

This URI takes two integers min, max and gives a list of Roman Numerals in that range

http://localhost:8080/romannumeral?min={integer}&max={integer} 


## Prerequisites:

Prerequisites for running project locally

* Java 8 
* Lombok  
* JUnit 5


## Testing Methodology:

 > Below are the unit test cases for the project.
 >   * Scenario 1:
     URI : 'http://localhost:8080/romannumeral?query=400'
     
     Expected Output : {"input":"400","output":"CD"}
     
 <img width="432" alt="Screen Shot 2021-10-30 at 4 51 06 PM" src="https://user-images.githubusercontent.com/63678435/139568524-6a111ffc-9220-4c5b-a826-d5c6fc8c9f8a.png">

 >   * Scenario 2: URI : 'http://localhost:8080/romannumeral?query=-5600'
       
       Expected Output : Invalid Request. Input should be in the range of 1-3999 numbers
      
<img width="455" alt="Screen Shot 2021-10-30 at 11 05 43 PM" src="https://user-images.githubusercontent.com/63678435/139569000-01c1bab4-dbf9-4aaa-9177-d7691024eb14.png">

      
 >   * Scenario 3 : URI : 'http://localhost:8080/romannumeral?min=3&max=7'
       
       Expected Output : {"conversions":[{"input":3,"output":"III"},{"input":4,"output":"IV"},{"input":5,"output":"V"},{"input":6,"output":"VI"},{"input":7,"output":"VII"}]}
       
<img width="1189" alt="Screen Shot 2021-10-30 at 11 05 56 AM" src="https://user-images.githubusercontent.com/63678435/139568528-c3472712-aa61-4db3-92d5-9ed9efb07b67.png">

 >   * Scenario 4 : URI : 'http://localhost:8080/romannumeral?min=10&max=7'
       
       Expected Output : Min value should be less than Max
       
<img width="470" alt="Screen Shot 2021-10-30 at 11 13 37 PM" src="https://user-images.githubusercontent.com/63678435/139569008-131fed48-f6ea-4dfb-9902-787fdf43e705.png">

## Engineering Methodology:
- Requirements gathering -> Analysis -> Design -> Code -> Test -> Deploy -> Maintenance

## Packaging Layout:

* **controller**: RomanNumeralConverterController

Controller class processes the REST API requests and returns the response. It has 2 GET requests with path '\romannumeral' and varied parameters.

* **service**: RomanNumeralConverterService

Service class contains the business logic for converting Integer to Roman number. Request data from Controller(Integer(s)) will be passed here and after passing the valid checks the input number(s) will be converted as Roman Numeral(s) and returned back to controller. If any of the checks fail, appropriate exception will be returned. 
* **model**: RomanNumeralModel

RomanNumeralModel object has the structure for output data after Roman Numeral conversion.

* **constants**: RomanNumeralConverterConstants

This class has constants defined including Error Messages and other constants required to compute Roman Numerals.

* **handler**: GlobalExceptionHandler

This global exception handler class is to handle the exceptions thrown by controller.

* **exception**:InvalidInputRangeException, InvalidMaxNumberException

Customized exception classes for specific edge cases.


## References:

* https://en.wikipedia.org/wiki/Roman_numerals for Roman Numerals	
* https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Future.html for multi-threading
* https://stackedit.io/app# for formatting README.md

