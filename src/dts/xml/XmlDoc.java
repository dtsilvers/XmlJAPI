/* 
 ============================================================================
 Name        : XmlDoc.java
 Author      : dtsilvers@aol.com
 Date        : 2014-01-30
 Version     : 1.00
 License     : MIT - SEE: http://opensource.org/licenses/MIT
 Copyright   : Copyright (c) 2014 by David T. Silvers Sr.
 Description : XmlJAPI reduces several calls down to a couple lines of code.
               SEE ALSO: dist/TestXJAPI.java
 ============================================================================
*/
package dts.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public abstract class XmlDoc {
	private Document doc;
	protected XmlDoc(String fileArg) throws SAXException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setIgnoringComments(true);
		docFactory.setIgnoringElementContentWhitespace(true);
		File file = new File(fileArg);
		if(!file.exists()) // In case jar is run from <project>\bin or <project>\dist
			file = new File(".." + File.separator + file);
		try {
			doc = docFactory.newDocumentBuilder().parse(file.getPath());
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			throw new SAXException(ex);
		}
	}
	protected Document getDoc() { return doc; }
}
