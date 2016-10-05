package com.crunchify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crunchify.bean.Employee;


@Controller
public class TestRequestMapping {

	@RequestMapping(value = "testUrl1", method = RequestMethod.GET)
	public String testUrl1(ModelMap model) {
		Employee empl1 = new Employee("fortin", "david");
		
		model.addAttribute("employee", empl1);
		String heading = "Spring MVC: How to Access ModelMap Values in a JSP?";
		String result1 = "Hey.. I'm result1.. You are seeing me on welcome page.";
		String result2 = "Hey.. I'm result2.. ";
 
		String credit = "Demo by <a href='http://crunchify.com'>Crunchify</a>. Click <a href='http://crunchify.com/category/java-web-development-tutorial/'>here</a> for more than 350 Java Examples.";
 
		// you can add any Collection Objects to ModelMap
		// including JSON, String, Array, Map, List, etc...
		model.addAttribute("heading", heading);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("credit", credit);
		return "test1";
	}
	
	//curl -i -X GET http://localhost:8080/CrunchifySpringMVCTutorial/testUrl1

	@RequestMapping(value = "/testUrl1", method = RequestMethod.POST)
	@ResponseBody
	public String getFoosBySimplePath() {
	    return "Get some Foos': POST Method";
	}
	
	/*
	@RequestMapping(value = "/testUrl2", method = RequestMethod.GET, headers = {"key1=val1"} )
	@ResponseBody
	public String getHeaderGETMethod() {
	    return "Get some Foos': GET Method = key1=val1 ";
	}
	*/
	
	
	//curl -i -H "key1:val1" http://localhost:8080/CrunchifySpringMVCTutorial/testUrl1
	@RequestMapping(value = "/testUrl1",  headers ={"key1=val1"}, method = RequestMethod.GET)
	@ResponseBody
	public String getHeaderGETMethod() {
	    return "Get some Foos': GET Method = key2=val2 ";
	}
	
	@RequestMapping(value = "/testUrl1",  headers ={"Accept=application/json"}, method = RequestMethod.GET)
	@ResponseBody
	public String getAcceptJSON() {
		
	    return "Get some Foos': GET Method = ACCEPT JSON /n ";
	}

	
//curl -H "Accept:application/json,text/html" http://localhost:8080/CrunchifySpringMVCTutorial/testUrl1
	@RequestMapping(value = "/testUrl1",  headers ={"Accept=application/json"}, method = RequestMethod.GET,
			  produces = { "application/json", "application/xml" })
	@ResponseBody
	public String getAcceptProduceJSON() {
		
	    return "Get some Foos': GET Method = ACCEPT JSON / n ";
	}
	
	
	//curl http://localhost:8080/CrunchifySpringMVCTutorial/testUrl1/42
	@RequestMapping(value = "/testUrl1/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePathWithPathVariable(
	  @PathVariable("id") long id) {
	    return "Get a specific Foo with id=" + id;
	}
	

	//curl -i -d id=100 http://localhost:8080/CrunchifySpringMVCTutorial/testUrl3
	//http://localhost:8080/CrunchifySpringMVCTutorial/testUrl3?id=42
	//http://localhost:8080/CrunchifySpringMVCTutorial/testUrl3?id=111&nom=fortin
	@RequestMapping(value = "/testUrl3", method = RequestMethod.GET, params={"id", "nom"})
	@ResponseBody
	public String getFoosBySimplePathWithRequestParam(
	  @RequestParam("id") long id,
	  @RequestParam("nom") String nom) {

		StringBuilder builder = new StringBuilder();
		builder.append("id = " + id);
		builder.append("nom = " + nom);
		return builder.toString();
	}
	
	
	
	
	
	
	
	
	
	

}
