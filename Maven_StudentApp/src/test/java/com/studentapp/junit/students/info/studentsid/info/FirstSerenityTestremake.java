package com.studentapp.junit.students.info.studentsid.info;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;


@RunWith(SerenityRunner.class)
public class FirstSerenityTestremake {

	@BeforeClass
	public static void init(){
		RestAssured.baseURI="http://localhost:8085/student";
	}
	
	@Test
	
	public void getAllStudents(){
	//	RestAssured.given().
		SerenityRest.given().
		when().
		get("/list").then().log().all()
		.statusCode(200);
	}
	
	/*
@Test
	
	public void getAllStudentsfailtest(){
	//	RestAssured.given().
		SerenityRest.given().
		when().
		get("/list").then().log().all()
		.statusCode(500);
	}



@Pending
@Test
public void getAllStudents_pending(){
//	RestAssured.given().

}
	
@Ignore
@Test
public void getAllStudents_Ignore(){
//	RestAssured.given().

}

@Test
public void getAllStudents_error(){
//	RestAssured.given().
System.out.println(5/0);
}


@Test
public void getAllStudents_file() throws FileNotFoundException{

File r = new File("e:file.txt");
	FileReader re= new FileReader(r);
	
	
}
*/

	
}
