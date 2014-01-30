/* 
 ============================================================================
 Name        : XmlPath.java
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

import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlPath extends XmlDoc {
	public XmlPath(String fileArg) throws SAXException {
		super(fileArg);
	}
	public String getXmlPathAttr(String xpathArg) throws SAXException {
		String oStrReturn = null;
		try {
			XPathExpression expr = XPathFactory.newInstance().newXPath().compile(xpathArg);
			oStrReturn = expr.evaluate(getDoc(), XPathConstants.STRING).toString();
			if(oStrReturn.isEmpty())
				throw new SAXException("Missing attribute > " + xpathArg);
		} catch (XPathExpressionException ex) {
			throw new SAXException(ex);
		}
	return(oStrReturn);
	}	
	public Object[] getXmlPathText(String xpathArg) throws SAXException {
		List<String> list = new ArrayList<>();
		try {
			XPathExpression expr = XPathFactory.newInstance().newXPath().compile(xpathArg);
			NodeList nodeList = (NodeList)expr.evaluate(getDoc(), XPathConstants.NODESET);
			for(int i = 0; i < nodeList.getLength(); i++)
				list.add(nodeList.item(i).getNodeValue());
			if(list.isEmpty())
				throw new SAXException("Missing node > " + xpathArg);
		} catch (XPathExpressionException ex) {
			throw new SAXException(ex);
		}
	return(list.toArray());
	}
}
