package rytalo.com.tv218.model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by dinamounib on 2/23/16.
 */
public class Program {

    String TAG = "program model";
    public String  id,source_id,title_ar,title_en,description_ar,description_en,supplier,
            synapsis,year,facebook,twitter,instagram,parent_id,cover,thumbnail,icon,
            bg,ischannel,smartTV,publish,featured,premium,geo_countries,geo_status,
            channel_id,order,schedule,eschedule,deleted,create_time,update_time,user_id,
            geo_zone,
            channel;

    public void populateProgram(JSONObject obj)
    {
        try {

            id = obj.getString("id");
            source_id  = obj.getString("source_id");
            title_ar = obj.getString("title_ar");
            title_en = obj.getString("title_en");
            description_ar = obj.getString("description_ar");
            description_en = obj.getString("description_en");
            supplier = obj.getString("supplier");
            synapsis = obj.getString("synapsis");
            year = obj.getString("year");
            facebook = obj.getString("facebook");
            twitter = obj.getString("twitter");
            instagram = obj.getString("instagram");
            parent_id = obj.getString("parent_id");
            cover = obj.getString("cover");
            thumbnail = obj.getString("thumbnail");
            icon = obj.getString("icon");
            bg = obj.getString("bg");
            ischannel = obj.getString("ischannel");
            smartTV = obj.getString("smartTV");
            publish = obj.getString("publish");
            featured = obj.getString("featured");
            premium = obj.getString("premium");
            geo_countries = obj.getString("geo_countries");
            geo_status = obj.getString("geo_status");
            channel_id = obj.getString("channel_id");
            order = obj.getString("order");
            schedule = obj.getString("schedule");
            eschedule = obj.getString("eschedule");
            deleted = obj.getString("deleted");
            create_time = obj.getString("create_time");
            update_time = obj.getString("update_time");
            user_id = obj.getString("user_id");
            geo_zone = obj.getString("geo_zone");
            channel = obj.getString("channel");
        }catch (Exception e)
        {
            Log.i(TAG,e.getMessage());
        }
    }
}
