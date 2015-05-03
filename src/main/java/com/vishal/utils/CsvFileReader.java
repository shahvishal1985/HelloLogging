package com.vishal.utils;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

import com.vishal.pojos.Student;

/**
 * @author Vishal Shah
 *
 */
public class CsvFileReader {
	
	final static Logger LOGGER = Logger.getLogger(CsvFileReader.class);

	//CSV file header
    private static final String [] FILE_HEADER_MAPPING = {"id","firstName","lastName","gender","age"};
	
	//Student attributes
	private static final String STUDENT_ID = "id";
	private static final String STUDENT_FNAME = "firstName";
	private static final String STUDENT_LNAME = "lastName";
	private static final String STUDENT_GENDER = "gender"; 
	private static final String STUDENT_AGE = "age";
	
	public static void readCsvFile(Reader reader) {
		
		CSVParser csvFileParser = null;
		
		//Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
     
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
        	List<Student> students = new ArrayList<Student>();

            
            //initialize CSVParser object
            csvFileParser = new CSVParser(reader, csvFileFormat);
            
            //Get a list of CSV file records
            List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
            
            //Read the CSV file records starting from the second record to skip the header
            for (int i = 1; i < csvRecords.size(); i++) {
            	CSVRecord record = csvRecords.get(i);
            	//Create a new student object and fill his data
            	Student student = new Student(Long.parseLong(record.get(STUDENT_ID)), record.get(STUDENT_FNAME), record.get(STUDENT_LNAME), record.get(STUDENT_GENDER), Integer.parseInt(record.get(STUDENT_AGE)));
                students.add(student);	
			}
            
            //Print the new student list
            for (Student student : students) {
				if(LOGGER.isDebugEnabled()){
					LOGGER.debug(student.toString());
				}
				
				if(student.getAge() > 25){ // Simply want to add warn,error and fatal for few elements. No grudges to > 25. I am one of you!!!!
					LOGGER.warn("This is warn : " + student.getFirstName());
					LOGGER.error("This is error : " + student.getFirstName());
					LOGGER.fatal("This is fatal : " + student.getFirstName());
				}
			}
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                csvFileParser.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

	}

}
