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
public class ProgramVideo {

    String TAG = "ProgramVideo Controller";
    ResultStatus resultobject;
    Context context;
    String ID;

    public ProgramVideo(Context con, Object obj,String categoryID)
    {
        context = con;
        resultobject = (ResultStatus) obj;
        ID = categoryID;
        getnewscategorieswebservice();
    }
    public void getnewscategorieswebservice() {

        VolleyJSONObjectRequest areasrequest = new VolleyJSONObjectRequest(
                context.getResources().getString(R.string.URL_PROGRAM_VIDEOS)+context.getResources().getString(R.string.PROGRAMS_KEY)+"&cat_id="+ID,
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
