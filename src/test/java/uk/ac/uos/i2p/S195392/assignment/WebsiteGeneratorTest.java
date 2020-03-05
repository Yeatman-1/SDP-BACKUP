package uk.ac.uos.i2p.S195392.assignment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uk.ac.uos.i2p.S195392.assignment.WebsiteGenerator;

class WebsiteGeneratorTest {

	@Test
			void testFileGrabber() {
			String folderPath = System.getProperty("user.dir") + "\\src\\main\\resources\\templates";
			WebsiteGenerator wg = new WebsiteGenerator();
			assertEquals(3, WebsiteGenerator.fileGrabber(folderPath).size());
	
	}

}
