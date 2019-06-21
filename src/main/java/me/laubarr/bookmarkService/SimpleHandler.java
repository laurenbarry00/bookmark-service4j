package me.laubarr.bookmarkService;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleHandler implements RequestHandler<Object, SimpleResponse> {

    @Override
    public SimpleResponse handleRequest(Object input, Context context) {
      context.getLogger().log("Input: " + input);
      context.getLogger().log("Returning response...");

      String body = "{'message': 'Hello world!'}";

      return new SimpleResponse(200, null, false, body);
    }
}
