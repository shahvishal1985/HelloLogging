package com.vishal.utils;

import java.util.Random;

import org.apache.log4j.Logger;
import org.kohsuke.randname.RandomNameGenerator;

import com.vishal.pojos.Student;

/**
 * @author Vishal Shah
 *
 */
public class StudentRandomGenerator {

	final static Logger LOGGER = Logger.getLogger(StudentRandomGenerator.class);

	public static void createStudent(){
		Student student = null;
		RandomNameGenerator rnd = new RandomNameGenerator(0);
	    Random rand = new Random();
	    int maxAge= 30;
	    int minAge = 5;
	    
		for(int i=0 ; i < 1000 ; i ++){
			student = new Student();
			student.setFirstName(rnd.next());
			student.setLastName(rnd.next());
			student.setId(rand.nextLong());
			student.setGender(i%2 == 0 ?"M": "F");
			student.setAge(rand.nextInt((maxAge - minAge) + 1) + minAge);
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
}
