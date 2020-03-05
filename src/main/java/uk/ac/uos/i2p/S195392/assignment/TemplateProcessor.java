//S195932 - SDP - 15/01/2020

package uk.ac.uos.i2p.S195392.assignment;

import java.util.Map;

public interface TemplateProcessor {
	void loadTemplate(String name, String template);
	void loadTemplates(Map<String, String> templates);
	String expandTemplate(Map<String, Object> context);
}

