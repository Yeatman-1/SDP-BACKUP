//S195932 - SDP - 15/01/2020

package uk.ac.uos.i2p.S195392.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import uk.ac.uos.i2p.S195392.assignment.TemplateProcessor;

class TemplateProcessorTest {

	@Test
	// Tests that the .loadTemplate() method correctly loads the given template and context.
	// Tests that the loaded template's placeholders are correctly swapped with the relevant context.
 /*   void testLoadTemplate() {
		TemplateProcessor processor = new ExampleTemplateProcessor();
		processor.loadTemplate("NASA_Expedition.txt", System.getProperty("user.dir") + "\\src\\main\\resources\\templates");
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("name", "George");
		context.put("amount", 20);
		context.put("$template", "NASA_Expedition.txt");
		String result = processor.expandTemplate(context);
		assertEquals("<html>\r\n" + 
				"<div style=\"background-image: url('https://i.pinimg.com/originals/11/3b/a4/113ba4f4a6ab9817069ca3a3bb4a1b1b.jpg');\">\r\n" + 
				"<head>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<center> \r\n" + 
				"<img src=\"https://www.nasa.gov/sites/default/files/styles/side_image/public/thumbnails/image/nasa-logo-web-rgb.png?itok=uDhKSTb1\" alt=\"LOGO\"></a>\r\n" + 
				"<font color=\"white\">	<centre> <h1>YOU'RE IN!</h1>\r\n" + 
				"<h2>Welcome to the NASA Space Expedition Program</h2>\r\n" + 
				"<br>\r\n" + 
				"Thanks for your application George.\r\n" + 
				"<br> <br>\r\n" + 
				"The cost of this programme is GBP 20", result);
		System.out.println(result);
    }
	*/
	
	void testOffer() {
		TemplateProcessor processor = new ExampleTemplateProcessor();
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("name", "George");
		context.put("amount", 20);
		context.put("$template", "offer");
		String result = processor.expandTemplate(context);
		assertEquals("Dear Arthur, We are happy to offer you a bonus £20", result);
		System.out.println(result);
	}
	
	
	
	
	
	
	
	
}





	/*
	@Test
	// Tests that the .loadTemplates() method correctly loads multiple templates.
	// Tests that the correct template is loaded and that its placeholders are correctly swapped with the relevant context.
    void testLoadTemplates() {
		TemplateProcessor processor = new ExampleTemplateProcessor();
		Map<String, String> templates = new HashMap<String, String>();
		templates.put("discount", "Dear ${name}, We are happy to offer you a discount of Â£${amount}");
		templates.put("bonus", "Dear ${name}, We are happy to offer you a bonus of Â£${amount}");
		processor.loadTemplates(templates);
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("name", "George");
		context.put("amount", 40);
		context.put("$template", "bonus");
		String result = processor.expandTemplate(context);
		assertEquals("Dear George, We are happy to offer you a bonus of Â£40", result);
    }

	// @Test
  void testExapandTemplate() {
		TemplateProcessor processor = new ExampleTemplateProcessor();
		processor.loadTemplate("Loyalty", "Dear ${name}, We are happy to offer you an exclusive loyalty discount of £${amount}.");
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("name", "Frank");
		context.put("amount", 1);
		context.put("$template", "Loyalty");
		String result = processor.expandTemplate(context);
		assertEquals("Dear Frank, We are happy to offer you an exclusive loyalty discount of £1", result);
	
	}
}
*/