//S195932 - SDP - 15/01/2020

package uk.ac.uos.i2p.S195392.assignment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import uk.ac.uos.i2p.S195392.assignment.TemplateProcessor;

public class ExampleTemplateProcessor implements TemplateProcessor {
	
	// Declares a private Map named 'templatesMap' which is only accessible within this class.
	private Map<String, String> templatesMap;
	
	// A no argument constructor which initialises the declares templatesMap as a HashMap.
	
	/// S195392
	public ExampleTemplateProcessor() {
		this.templatesMap = new HashMap<String, String>();
	}
	
	@Override
	// Takes a template's name and contents and stores both in the initialised 'templatesMap'.
	// The template's name is stored as the Map entry's key and the template's contents are stored as the Map entry's value.
	public void loadTemplate(String name, String template) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(template + "\\" + name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String templateContent = new String(encoded, StandardCharsets.US_ASCII);
		templatesMap.put(name, templateContent);
	}

	@Override
	// Merges provided templates Map with initialised templatesMap private variable.
	public void loadTemplates(Map<String, String> templates) {
		templates.forEach(
			    (key, value) -> templatesMap.merge( key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2)
		);
	}

	@Override
	// Iterates through each locally stored template entry in the HashMap to find the name of the target template.
	// Swaps placedholders in the target template with the provided context.
	public String expandTemplate(Map<String, Object> context) {
        StringBuffer result = new StringBuffer();
		for (Entry<String, String> entry : templatesMap.entrySet()) {
			if (entry.getKey().equals(context.get("$template"))) {
	            Matcher m = Pattern.compile("\\$\\{(.*?)}").matcher(entry.getValue());
	            while (m.find()) {
	            	
	                if (!m.group(1).isEmpty()) {
	                m.appendReplacement(result, context.get(m.group(1)).toString());
	                }
	                else {
	                   m.appendReplacement(result, m.group(0));
	                }
	            }
			}
		}
		return result.toString();


	}
}
