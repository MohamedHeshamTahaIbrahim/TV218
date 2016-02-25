package rytalo.com.tv218.model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by dinamounib on 2/23/16.
 */
public class FeaturesVideo {

    String TAG = "features video model";

    public String id,url,img,title,title_en,title_ar,recorder_date,first_start,start_time,stop_time,duration,islocked,tags,
    bitrates,smil,youtube_link,youtube_views,wowza_views,today_views,description_en,
    description_ar,publish,publish_time,category_id,channel_id,smartTV,featured,premium,vip,parental_control,vod,catchup,edited
    ,order,schedule,eschedule,protectedd,deleted,create_time,update_time,user_id,geo_status,geo_countries,geo_zone,autoplay,
    external_url,author_id,shub_id,group_tags,from_featured,to_featured,featured_schedule,aid,author_name,author_img,cat_id,cat_en,cat_ar;

    public void populateVideo(JSONObject obj)
    {
        try{

            id = obj.getString("id");
            url = obj.getString("url");
            img = obj.getString("img");
            title = obj.getString("title");
            title_en = obj.getString("title_en");
            title_ar = obj.getString("title_ar");
            recorder_date = obj.getString("recorder_date");
            first_start = obj.getString("first_start");
            start_time = obj.getString("start_time");
            stop_time = obj.getString("stop_time");
            duration = obj.getString("duration");
            islocked = obj.getString("islocked");
            tags = obj.getString("tags");
            bitrates = obj.getString("bitrates");
            smil = obj.getString("smil");
            youtube_link = obj.getString("youtube_link");
            youtube_views = obj.getString("youtube_views");
            wowza_views = obj.getString("wowza_views");
            today_views = obj.getString("today_views");
            description_en = obj.getString(description_en);
            description_ar = obj.getString("description_ar");
            publish = obj.getString("publish");
            publish_time = obj.getString("publish_time");
            category_id = obj.getString("category_id");
            channel_id = obj.getString("channel_id");
            smartTV = obj.getString("smartTV");
            featured = obj.getString("featured");
            premium = obj.getString("premium");
            vip = obj.getString("vip");
            parental_control = obj.getString("parental_control");
            vod = obj.getString("vod");
            catchup = obj.getString("catchup");
            edited = obj.getString("edited");
            order = obj.getString("order");
            schedule = obj.getString("schedule");
            eschedule = obj.getString("eschedule");
            protectedd = obj.getString("protected");
            deleted = obj.getString("deleted");
            create_time = obj.getString("create_time");
            update_time = obj.getString("update_time");
            user_id = obj.getString("user_id");
            geo_status = obj.getString("geo_status");
            geo_countries = obj.getString("geo_countries");
            geo_zone = obj.getString("geo_zone");
            autoplay = obj.getString("autoplay");
            external_url = obj.getString("external_url");
            author_id = obj.getString("author_id");
            shub_id = obj.getString("shub_id");
            group_tags = obj.getString("group_tags");
            from_featured = obj.getString("from_featured");
            to_featured = obj.getString("to_featured");
            featured_schedule = obj.getString("featured_schedule");
            aid = obj.getString("aid");
            author_name = obj.getString("author_name");
            author_img = obj.getString("author_img");
            cat_id = obj.getString("cat_id");
            cat_en = obj.getString("cat_en");
            cat_ar = obj.getString("cat_ar");


        }catch (Exception e)
        {
            Log.i(TAG,e.getMessage());
        }
    }
}
