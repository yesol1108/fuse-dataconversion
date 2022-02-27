package org.mycompany.routebuilder;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.mycompany.model.FixedDao;
import org.mycompany.model.FixedLengthRequest;
import org.mycompany.model.JsonDataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FromJsonToFixed extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(FromJsonToFixed.class);
    private static int count = 0;

    @EndpointInject(ref = "jsonDirectory")
    Endpoint sourceUri;

    public void configure() throws Exception {

        JacksonDataFormat jsonDataFormat = new JacksonDataFormat(JsonDataRequest.class);
        DataFormat fixedFormat = new BindyFixedLengthDataFormat(FixedLengthRequest.class);

        from(sourceUri).routeId("fixedformat")
                .log("@@@ Input Json Data (to Fixed) : ${body}")
                .unmarshal().json(JsonLibrary.Jackson, JsonDataRequest.class)
                .bean("jsonToFixedBean")
                .marshal(fixedFormat)
                .log("@@@ Fruit Registered : ${body}");

    }
}
