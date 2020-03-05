//S195392 - SDP

package uk.ac.uos.i2p.S195392.assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import uk.ac.uos.i2p.S195392.assignment.ExampleTemplateProcessor;

public class WebsiteGenerator {
	
	private static String contextPath;
	private static String templatePath;
	private static String outputPath;
	
	// Recursively Searching Parent Folders and sub-folders for files - F represents the collection of found files 'f'
	
	public static List<File> fileGrabber(String dirPath) {
        File dir = new File(dirPath);
        List<File> files = new ArrayList<File>();
        if (dir == null || dir.listFiles() == null ) {
        	return files;
        }
        for (File file : dir.listFiles()) {
        	if (file.isFile()) {
        		files.add(file);
        	}
        	else files.addAll(fileGrabber(file.getAbsolutePath()));
        }
        return files;
	}

	public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); 
        System.out.println("**Please Wait...");
        contextPath = System.getProperty("user.dir") + "\\src\\main\\resources\\context";; 
        templatePath = System.getProperty("user.dir") + "\\src\\main\\resources\\templates";
        outputPath = System.getProperty("user.dir") + "\\src\\main\\resources\\output";
        generate(outputPath);
        input.close();
       
	}
	
	private static void generate(String desiredPath) throws UnsupportedEncodingException, IOException {
		
		// The below is going through each context file in order to locate X template file(s)
		
		for (File contextFile : fileGrabber(contextPath)) {
			System.out.println("Processing Template via Website Generator...");
			ExampleTemplateProcessor tp = new ExampleTemplateProcessor();
			tp.loadTemplate(valueLoader(contextFile).get("$template").toString(), templatePath);
			Map<String, Object> vl = valueLoader(contextFile);
			String templateName = vl.get("$template").toString();
            File template = findTemplate(templateName, templatePath);
            String fileName = contextFile.getName().split("\\.")[0];
            String filePath = outputPath + "\\" + fileName + ".html";
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath));
            //System.out.println(vl);
            String content = tp.expandTemplate(vl);
            System.out.println("Finished!");
            bw.write(content);
            bw.close();

		}

	
	}
	
	public static File findTemplate(String name, String dir) {
        File file = null;
        List<File> templates = new ArrayList<File>(fileGrabber(dir));
        for (File template : templates) {
                        if (template.getName().contentEquals(name)) {
                                        file = template;
                        }
        }
        return file;
	}
		
	public static Map<String, Object> valueLoader(File contextFile) throws UnsupportedEncodingException, IOException {
		Map<String, Object> context = new HashMap<>();
        String lines[] = new String(Files.readAllBytes(Paths.get(contextFile.getPath())),"UTF-8").split("\\r?\\n|\\r"); 
        for (String line : lines) {
                      String[] parts = line.split("=", 2);
                        
                       if (parts.length >= 2) {
                    	   String key = parts[0].trim();
                    	   String value = parts[1].trim();
                    	   context.put(key, value);
                       }
        }
		return context;
	}	
}