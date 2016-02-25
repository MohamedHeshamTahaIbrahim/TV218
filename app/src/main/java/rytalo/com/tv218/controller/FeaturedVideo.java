package rytalo.com.tv218.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.error.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import rytalo.com.tv218.AppController;
import rytalo.com.tv218.Networking.VolleyJSONArrayRequest;
import rytalo.com.tv218.Networking.VolleyJSONObjectRequest;
import rytalo.com.tv218.R;
import rytalo.com.tv218.interfaces.ResultStatus;

/**
 * Created by dinamounib on 2/22/16.
 */
public class FeaturedVideo {

    String TAG = "FeaturedVideo Controller";
    ResultStatus resultobject;
    Context context;

    public FeaturedVideo(Context con, Object obj)
    {
        context = con;
        resultobject = (ResultStatus) obj;
        getnewscategorieswebservice();
    }
    public void getnewscategorieswebservice() {

        VolleyJSONArrayRequest areasrequest = new VolleyJSONArrayRequest(
                context.getResources().getString(R.string.URL_FEATURED_VIDEOS)+context.getResources().getString(R.string.PROGRAMS_KEY),
                null, this.createRequestSuccessListener(),
                createRequestErrorListener());
        AppController.getInstance().addToRequestQueue(areasrequest,
                TAG);
    }

    private Response.ErrorListener createRequestErrorListener() {
        // TODO Auto-generated method stub
        return new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error: " + error.getMessage());
                resultobject.setresult_onfailed(error.toString());
            }
        };
    }

    private Response.Listener<JSONArray> createRequestSuccessListener() {

        // TODO Auto-generated method stub
        return new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.i(TAG, response.toString());
                    resultobject.setresult_onsucceed(response.toString());
                } catch (Exception e) {
                    resultobject.setresult_onfailed(response.toString());
                    e.printStackTrace();
                    return;
                }
            }
        };

    }

}
