

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class CreateDOM {
    
	
	public static Document getDOM() throws SAXException,ParserConfigurationException,IOException, URISyntaxException{
            Document dom=null;
            File quizFile=null;
 	    quizFile=new File("question.xml");               	   
 	         
	   DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	   DocumentBuilder db=dbf.newDocumentBuilder();
        try{
	    dom=db.parse(quizFile);
        }catch(FileNotFoundException fileNotFound){
		   
            JOptionPane.showMessageDialog(null, "Error : Quiz File Not Found "+fileNotFound);
	   }
	   dom.getDocumentElement().normalize();
	   return dom;
	}
        
        
    
}
