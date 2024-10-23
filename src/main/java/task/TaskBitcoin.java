package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TaskBitcoin extends TaskImpl {

    @Override
    public void execute() {
        try {
            int times = Integer.valueOf(input);
            result = getInfo(times);
        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
        }
    }

    public String getInfo(int times) {
        List<String> values = new ArrayList<>();
        String info;
        try {
            for (int i = 0; i < times; i++) {
                info = getRequest("https://www.bitstamp.net/api/v2/ticker/btcusd");
                info = info.substring(info.indexOf("\"last\": \""), info.indexOf(", \"times")).trim();
                values.add(info);
                Thread.sleep(1000);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return values.toString();
    }

    private String getRequest(String url) throws IOException {
        StringBuilder response = new StringBuilder();

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        if (in != null) in.close();

        return response.toString();
    }
}
