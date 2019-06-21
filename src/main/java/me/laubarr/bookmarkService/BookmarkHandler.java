package me.laubarr.bookmarkService;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class BookmarkHandler implements RequestHandler<Object, BookmarkResponse> {

    @Override
    public BookmarkResponse handleRequest(Object input, Context context) {
      context.getLogger().log("Input: " + input);
      context.getLogger().log("Returning response...");

      String body = "{'name':'java-sam-links','links':['https://google.com','https://openjdk.java.net']}";

      return new BookmarkResponse(200, null, false, body);
    }
}
