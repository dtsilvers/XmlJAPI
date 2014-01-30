/* 
 ============================================================================
 Name        : TestXJAPI.java
 Author      : dtsilvers@aol.com
 Date        : 2014-01-30
 Version     : 1.00
 License     : MIT - SEE: http://opensource.org/licenses/MIT
 Copyright   : Copyright (c) 2014 by David T. Silvers Sr.
 Description : XmlJAPI reduces several calls down to a couple lines of code.
               SEE: src/dts/xml/XmlDoc.java and src/dts/xml/XmlPath.java
 ============================================================================
*/

import dts.xml.XmlPath;
import org.xml.sax.SAXException;

public class TestXJAPI {
	public static void main(String[] args) {
		try { 
			XmlPath xmlPath = new XmlPath("config.xml");
			for(Object o : xmlPath.getXmlPathText("//databases/schema/text()")) 
					System.out.println(o.toString());
			System.out.println(xmlPath.getXmlPathAttr("//log/@file"));
		} catch (SAXException ex) {
			System.err.println("SAXException: Dice.main() > Configuration error: " + ex.getMessage());
			ex.printStackTrace(System.err);
		}		
	}
}
