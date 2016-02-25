package rytalo.com.tv218.model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by dinamounib on 2/23/16.
 */
public class News {

    String TAG = "News model";

    public String vid,uid,title,log,status,comment,promote,sticky,nid,type,language,created,changed,tnid,translate,
    revision_timestamp,revision_uid,bodyDescription,bodyImage;
//    body":{"und":[{"value,summary,format}]},
//        field_author":{"und":[{"target_id":"356"}]}," +
//        ""field_image":[],"field_section":[],"field_tags":[]," +
//        ""rdf_mapping":{"rdftype":["sioc:Item","foaf:Document"]," +
//        ""title":{"predicates":["dc:title"]},"created":{"predicates":["dc:date","dc:created"],"datatype":"xsd:dateTime","callback":"date_iso8601"},"changed":{"predicates":["dc:modified"],"datatype":"xsd:dateTime","callback":"date_iso8601"},"body":{"predicates":["content:encoded"]},"uid":{"predicates":["sioc:has_creator"],"type":"rel"},"name":{"predicates":["foaf:name"]},"comment_count":{"predicates":["sioc:num_replies"],"datatype":"xsd:integer"},"last_ac  tivity":{"predicates":["sioc:last_activity_date"],"datatype":"xsd:dateTime","callback":"date_iso8601"}}," +
//        ""cid":"0","last_comment_timestamp":"1455975719","last_comment_name":null,"last_comment_uid":"0","comment_count":"0","name":"","picture":"0","data":null}

    public void populateNews(JSONObject obj)
    {
        try {

            vid = obj.getString("vid");
            uid = obj.getString("uid");
            title = obj.getString("title");
            log = obj.getString("log");
            status = obj.getString("status");
            comment = obj.getString("comment");
            promote = obj.getString("promote");
            sticky = obj.getString("sticky");
            nid = obj.getString("nid");
            type = obj.getString("type");
            language = obj.getString("language");
            created = obj.getString("created");
            changed = obj.getString("changed");
            tnid = obj.getString("tnid");
            translate = obj.getString("translate");
            revision_timestamp = obj.getString("revision_timestamp");
            revision_uid = obj.getString("revision_uid");

            bodyDescription = obj.getJSONObject("body").getJSONArray("und").getJSONObject(0).getString("value");
            bodyImage = obj.getJSONObject("field_image").getJSONArray("und").getJSONObject(0).getString("filename");

        }catch (Exception e)
        {
            Log.i(TAG,e.getMessage());
        }
    }
}
