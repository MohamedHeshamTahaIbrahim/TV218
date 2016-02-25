package rytalo.com.tv218.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.error.VolleyError;

import org.json.JSONObject;

import rytalo.com.tv218.AppController;
import rytalo.com.tv218.Networking.VolleyJSONObjectRequest;
import rytalo.com.tv218.R;
import rytalo.com.tv218.interfaces.ResultStatus;

/**
 * Created by dinamounib on 2/22/16.
 */
public class MostReaded {

    String TAG = "mostreaded Controller";
    ResultStatus resultobject;
    Context context;

    public MostReaded(Context con, Object obj)
    {
        context = con;
        resultobject = (ResultStatus) obj;
        getnewscategorieswebservice();
    }
    public void getnewscategorieswebservice() {

        VolleyJSONObjectRequest areasrequest = new VolleyJSONObjectRequest(
                context.getResources().getString(R.string.URL_NEWS_MOST_READ)+context.getResources().getString(R.string.API_KEY),
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

    private Response.Listener<JSONObject> createRequestSuccessListener() {

        // TODO Auto-generated method stub
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
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
