package rytalo.com.tv218.Networking;

/**
 * Created by dinamounib on 2/22/16.
 */
import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.error.ParseError;
import com.android.volley.toolbox.HttpHeaderParser;

public class VolleyStringRequest extends Request<String> {

    private Listener<String> listener;
    private Map<String, String> params;

    public VolleyStringRequest(String url, Map<String, String> params,
                               Listener<String> reponseListener, ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }

    public VolleyStringRequest(int method, String url,
                               Map<String, String> params, Listener<String> reponseListener,
                               ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }



    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new String(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(String response) {
        // TODO Auto-generated method stub
        listener.onResponse(response);
    }
}
