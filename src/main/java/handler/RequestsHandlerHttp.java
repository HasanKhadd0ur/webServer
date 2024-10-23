package handler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import singleton.TaskExecutor;
import singleton.TasksList;

import java.io.*;

public class RequestsHandlerHttp implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        Headers requestHeaders = httpExchange.getRequestHeaders();
        String response = "";

        String requestMethod = httpExchange.getRequestMethod();
        switch (requestMethod) {
            case "GET":
                response = TasksList.INSTANCE.list();
                break;
            case "POST":
                InputStream input = httpExchange.getRequestBody();
                StringBuilder params = new StringBuilder();
                new BufferedReader(new InputStreamReader(input))
                    .lines()
                    .forEach(s -> params.append(s));

                System.out.println("New request from " + requestHeaders.get("User-agent") + " -> " + params);
                response = TaskExecutor.INSTANCE.run(params.toString());
                break;
        }

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
