package com.studentapp.junit.students.info;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;



@UseTestDataFrom("testdata\\studentsdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDatadriventest extends TestBase{

	private String firstname;
	private String lastname;
	private String email;
	private String programme;
	private String course;	
	
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname2(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getProgramme() {
		return programme;
	}


	public void setProgramme(String programme) {
		this.programme = programme;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}

	
	
	
	@Steps
	StudentSerenitySteps steps;
	
	
	@Title("student records data driven")
	@Test
	public void createmultiplestudents(){
		ArrayList<String>courses= new ArrayList<String>();
		courses.add(course);
		
	steps.createStudent(firstname, lastname, email, programme, courses).statusCode(201);
	}
	
}
