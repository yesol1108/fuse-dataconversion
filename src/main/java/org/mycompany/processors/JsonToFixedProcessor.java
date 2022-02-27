package org.mycompany.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.mycompany.model.FixedDao;
import org.mycompany.model.FixedLengthRequest;
import org.mycompany.model.JsonDataRequest;

import java.util.ArrayList;
import java.util.List;

public class JsonToFixedProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        JsonDataRequest body = exchange.getMessage()
                .getBody(JsonDataRequest.class);

        List<FixedLengthRequest> requests = new ArrayList<>();

        for(FixedDao it : body.noa) {
            FixedLengthRequest request = new FixedLengthRequest();
            request.blockType = body.blockType;
            request.blockTypeLength = body.blockTypeLength;
            request.blockId = body.blockId;
            request.totalNoOfTX = body.totalNoOfTX;
            request.msgblockType = body.msgblockType;
            request.messageLength = body.messageLength;
            request.artist = it.artist;
            request.title = it.title;
            request.itunesLink = it.itunesLink;
            requests.add(request);
        }

        exchange.getMessage().setBody(requests);
    }
}
