package test.xml;

import java.io.ByteArrayInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Xml2Pojo {

		//convert the xml to a pojo
		public static AceCalcStrutsData xml2pojo(String xml) throws JAXBException {
			JAXBContext jaxbContext;
			
			//set the pojo in a new instance of JaxbContext
			jaxbContext = JAXBContext.newInstance(AceCalcStrutsData.class);
			
			Unmarshaller um = jaxbContext.createUnmarshaller();
			ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
			
			/*
			 * this method has no parameter as String,so we must get the bytes from a String,and create a ByteArrayInputStream
			 * by the bytes.
			 */
			AceCalcStrutsData message = (AceCalcStrutsData) um.unmarshal(is);
	
			return message;
		}

	
}
