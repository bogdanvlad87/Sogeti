package Utils;

import com.google.common.base.Stopwatch;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApiUtils {

    // bw/stuttgart
    public List getResponse(String endpoint) {
        String endpointUrl = "http://api.zippopotam.us/" + endpoint;
        List response = new ArrayList();

        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            ResponseHandler<String> handler = new BasicResponseHandler();
            HttpGet get = new HttpGet(endpointUrl);
            // Pass local context as a parameter
            // Pass local context as a parameter
            get.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            Stopwatch stopwatch = Stopwatch.createStarted();
            HttpResponse res = httpclient.execute(get);
            long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);

            response.add(res.getStatusLine().getStatusCode());
            response.add(handler.handleResponse(res));
            response.add(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
