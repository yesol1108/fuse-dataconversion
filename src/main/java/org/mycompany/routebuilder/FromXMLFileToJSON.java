package org.mycompany.routebuilder;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.mycompany.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FromXMLFileToJSON extends RouteBuilder{
	
	private static final Logger logger = LoggerFactory.getLogger(FromXMLFileToJSON.class);
	private static int count = 0;

	@EndpointInject(ref="xmlDirectory")
	Endpoint sourceUri;
	
	@Override
	public void configure() throws Exception {
			
		// XML Data Format
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Employee.class);
		xmlDataFormat.setContext(con);
			
		// JSON Data Format
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
		
		from(sourceUri).routeId("jsonformat")
		.log("### Employee : ${body}")
		.unmarshal(xmlDataFormat)
		.bean("employeeBean")
		.marshal(jsonDataFormat)
		.log("### Employee Registered : ${body}");
		
	}

}
