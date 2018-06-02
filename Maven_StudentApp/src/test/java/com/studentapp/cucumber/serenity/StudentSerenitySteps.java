package com.studentapp.cucumber.serenity;

import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReuseableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {
	
	
	@Step
	public ValidatableResponse createStudent(String firstname,String lastname,
			String email, String programme,List<String>courses){
	StudentClass student= new StudentClass();
		
		student.setFirstName(firstname);
		student.setLastName(lastname);
		student.setEmail(email);
		student.setProgramme(programme);
		student.setCourses(courses);
		
	return	SerenityRest.rest().given().spec(ReuseableSpecifications.getGenericRequestSpec()).
		when().
		body(student).
		post().
		then().log().all();
	}
	
@Step
public  HashMap<String, Object> getStudentverifiabledata(String firstname){
	
	String p1="findAll{it.firstName=='";
	String p2="'}get(0)";
HashMap<String,Object> value=  SerenityRest.rest().given().
	when().
    get("/list").
	then().log().all().statusCode(200).extract().
	path(p1+firstname+p2);

return value;
	
}

@Step
public ValidatableResponse studentupdate(int studentId,String firstname1,String lastname1,
		String email1, String programme1,List<String>courses1){
	
	

	StudentClass student1= new StudentClass();
	firstname1=firstname1+"updated";
	student1.setFirstName(firstname1);
	student1.setLastName(lastname1);
	student1.setEmail(email1);
	student1.setProgramme(programme1);
	student1.setCourses(courses1);
	
	 return SerenityRest.rest().given().spec(ReuseableSpecifications.getGenericRequestSpec()).log().all().
	when().
	body(student1).
	put("/"+studentId).
	then().log().all();
	

}
}
