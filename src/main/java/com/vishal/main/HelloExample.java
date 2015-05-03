package com.vishal.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import com.vishal.utils.CsvFileReader;
import com.vishal.utils.StudentRandomGenerator;

/**
 * @author Vishal Shah
 *
 */
public class HelloExample{
		
	public static void main(String[] args) {
	
		HelloExample obj = new HelloExample();
		obj.runMe("vishal shah");
		
	}
	
	private void runMe(String parameter){
		
    	InputStream is = getClass().getResourceAsStream("/student.csv");
    	Reader reader = new InputStreamReader(is);    	
		CsvFileReader.readCsvFile(reader);	
		StudentRandomGenerator.createStudent();
	}	
}