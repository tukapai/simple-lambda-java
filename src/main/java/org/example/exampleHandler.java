package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Map;

// Handler value: example.Handler
public class exampleHandler implements RequestHandler<Map<String,String>, APIGatewayProxyResponseEvent>{

    @Override
    public APIGatewayProxyResponseEvent handleRequest(Map<String,String> event, Context context)
    {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        try{
            // エラーの検証のためRuntimeExceptionを発生させる。
            throw new RuntimeException();
        }catch (RuntimeException e){
            response.setStatusCode(500);
            response.setBody("Error: SampleHandler is failed");
            return response;
        }
    }
}