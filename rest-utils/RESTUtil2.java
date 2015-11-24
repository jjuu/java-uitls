import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class RESTUtil2 {

    public String load(String url, String query) throws Exception {

        URL restURL = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();

        conn.setRequestMethod("POST");

        conn.setDoOutput(true);

        conn.setAllowUserInteraction(false);

        PrintStream ps = new PrintStream(conn.getOutputStream());

        ps.print(query);

        ps.close();

        BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line, resultStr = "";

        while (null != (line = bReader.readLine())) {
            resultStr += line;
        }

        bReader.close();

        return resultStr;
    }

    public static void main(String[] args) {

        try {
            RESTUtil restUtil = new RESTUtil();
            String resultString = restUtil.load("http://58.33.45.112:port/TrafficflowCommon/Handler.ashx", "param1=d&param2=e");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print(e.getMessage());
        }
    }
}
