package org.mycompany.routebuilder;

import org.apache.camel.Endpoint;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.mycompany.model.JsonDataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FromJsonToFixed extends RouteBuilder {

    private static final Logger logger = LoggerFactory.getLogger(FromJsonToFixed.class);
    private static int count = 0;

    @EndpointInject(ref = "jsonDirectory")
    Endpoint sourceUri;

    public void configure() throws Exception {

        JacksonDataFormat jsonDataFormat = new JacksonDataFormat(JsonDataRequest.class);
        BindyFixedLengthDataFormat fixedFormat = new BindyFixedLengthDataFormat(JsonDataRequest.class);

        from(sourceUri).routeId("fixedformat")
                .log("@@@ Input Json Data (to Fixed) : ${body}")
                .unmarshal(jsonDataFormat)
                .marshal(fixedFormat)
                .log("@@@ Fruit Registered : ${body}");

    }
}
