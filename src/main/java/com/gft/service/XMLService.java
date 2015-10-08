package com.gft.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.copy.HierarchicalStreamCopier;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.XppReader;
@Component
public class XMLService {
	
public String XMLtoJson ( )
{
	
	String xml=null;
	try {
		xml = readFile("src/Data/PhoneBook.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	HierarchicalStreamReader sourceReader = new XppReader(new StringReader(xml));

    StringWriter buffer = new StringWriter();
    JettisonMappedXmlDriver jettisonDriver = new JettisonMappedXmlDriver();
    jettisonDriver.createWriter(buffer);
    HierarchicalStreamWriter destinationWriter = jettisonDriver.createWriter(buffer);

    HierarchicalStreamCopier copier = new HierarchicalStreamCopier();
    copier.copy(sourceReader, destinationWriter);
    System.out.println(buffer.toString());
return buffer.toString();
}
public String readFile(String path) throws IOException{
    StringBuilder sb = new StringBuilder();
try {
String sCurrentLine=null;
BufferedReader br = new BufferedReader(new FileReader(path));
while ((sCurrentLine=(br.readLine())) != null) {
    sb.append(sCurrentLine);
}
}
catch ( Exception e ){


}


return sb.toString();  
}

}
