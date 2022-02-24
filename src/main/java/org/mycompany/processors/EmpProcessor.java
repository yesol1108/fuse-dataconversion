package org.mycompany.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.Employee;

public class EmpProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Employee employee = exchange.getIn().getBody(Employee.class);
		employee.setEmpName("JavaInUse Rocks");
		exchange.getIn().setBody(employee);
	}

}