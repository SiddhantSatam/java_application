package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URI;


public class ApacheHttpHelper implements HttpHelper{

    private HttpClient httpClient;
    org.apache.http.HttpResponse response;

    public String CONSUMER_KEY = System.getenv("consumerKey");
    public String CONSUMER_SECRET = System.getenv("consumerSecret");
    public String ACCESS_TOKEN = System.getenv("accessToken");
    public String TOKEN_SECRET = System.getenv("tokenSecret");

    public ApacheHttpHelper() {

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        httpClient = new DefaultHttpClient();

    }

    @Override
    public HttpResponse httpPost(URI uri) throws Exception {

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

        try {
            HttpPost post = new HttpPost(uri);
            consumer.sign(post);
            response = httpClient.execute(post);
        } catch (HttpResponseException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public HttpResponse httpGet(URI uri) throws Exception {

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

        try {
            HttpGet get = new HttpGet(uri);
            consumer.sign(get);
            response = httpClient.execute(get);
        } catch (HttpResponseException e) {
            e.printStackTrace();
        }
        return response;
    }

}
