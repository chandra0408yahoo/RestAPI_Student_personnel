package com.studentapp.junit.students.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReuseableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;



//java -jar rest.jar --server.port=8085



@RunWith(SerenityRunner.class)
public class SerenityStudentCrudTest extends TestBase{
	
	
	static String firstname=randomgen()+"reguser";
	static String lastname=randomgen()+"regUSERLASTNAME";
	static String programme=randomgen()+"Computerscience";
	static String email=randomgen()+"x3y@yahoo.com";
	
	static int studentId;
	
	@Steps
	StudentSerenitySteps steps;
	
	
	@Title("this test will create a new student")
	@Test()
	public void test001(){
		
		ArrayList<String>courses= new ArrayList<String>();
		courses.add("java");
		courses.add("c");
	steps.createStudent(firstname,lastname,email,programme,courses).statusCode(201)
	.spec(ReuseableSpecifications.getGenericResponseSpec());
	
		
	
	}



	@Title("this test will create a GET student details")
	@Test()
	public void test002(){
	
	HashMap<String, Object> value1	=steps.getStudentverifiabledata(firstname);
	System.out.println("the value is"+value1);
	assertThat(value1,hasValue(firstname));
	studentId=(int)value1.get("id");

	}




@Title("put on statement to edit")
@Test()
public void test003(){

	ArrayList<String>courses= new ArrayList<String>();
	courses.add("java");
	courses.add("c");


	steps.studentupdate(studentId,firstname,lastname,email,programme,courses).statusCode(200)
	.spec(ReuseableSpecifications.getGenericResponseSpec());
	
	
	
}


/*
@Title("delete on statement")
@Test
public void test004(){


	
	SerenityRest.rest().given().
	when().
	delete("/"+studentId);

	SerenityRest.rest().given().
	when().
	get("/"+studentId).
	then().log().all().statusCode(404);
	
}
*/


	
	
	public static int randomgen(){
		Random rand = new Random();
		int v1 = rand.nextInt(50);
	 return v1;

	}
}
