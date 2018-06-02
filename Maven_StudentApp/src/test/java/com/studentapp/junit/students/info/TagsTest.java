package com.studentapp.junit.students.info;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;




@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase{
	

	

	@WithTag("Feature:Positive")
	@Title("first test")
	@Test
	public void test1(){
		
		SerenityRest.rest().given().when().get("/list").then().statusCode(200);
	}

@WithTags({
	@WithTag("Feature:negative"),
	@WithTag("Feature:smoke")
})
	
	@Title("second test")
	@Test
	public void test2(){
		
		SerenityRest.rest().given().when().get("/listaads").then().statusCode(400);
	}
	
	@WithTag("Feature:negative")
	@Title("third test")
	@Test
	public void test3(){
		
		SerenityRest.rest().given().when().get("/lit").then().statusCode(400);
	}
	
}
