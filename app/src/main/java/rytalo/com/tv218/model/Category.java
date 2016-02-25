package rytalo.com.tv218.model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by dinamounib on 2/23/16.
 */
public class Category {

    String TAG = "category model";
    public String tid,vid,name,description,format,weight,uri;

    public void populateCategory(JSONObject obj)
    {
        try {

            tid = obj.getString("tid");
            vid = obj.getString("vid");
            name = obj.getString("name");
            description = obj.getString("description");
            format = obj.getString("format");
            weight = obj.getString("weight");
            uri = obj.getString("uri");

        }catch (Exception e)
        {
            Log.i(TAG,e.getMessage());
        }
    }
}
