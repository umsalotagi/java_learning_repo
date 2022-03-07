package com.ds.udemyspringone.xmlcontext;


// here we do not add any annotation as all the beans are specified in applicationCOntext xml file
// autowiring is also defined there.

// Defining Spring application context with xml. This was before spring 2.
// there are 3 ways to defone spring application context
// 1. spring boot way, 2. java core spring way , 3. xml way

public class XmlPersonDAO {
	
	public XmlJdbcConnection xmlJdbcConnection;

	public XmlJdbcConnection getXmlJdbcConnection() {
		return xmlJdbcConnection;
	}

	public void setXmlJdbcConnection(XmlJdbcConnection xmlJdbcConnection) {
		this.xmlJdbcConnection = xmlJdbcConnection;
	}

}
