package rytalo.com.tv218;

/**
 * Created by محمد on 25/02/2016.
 */
import android.content.Context;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageViewPlus;

import java.util.ArrayList;

import rytalo.com.tv218.model.Video;

/**
 * Created by محمد on 22/02/2016.
 */
public class CustomListAdapter extends BaseAdapter {


    //private final String[] des;
    ArrayList<Video> videos;
    Context context;
    NetworkImageViewPlus videoImage;
    TextView videoText;
    public CustomListAdapter(Context cont, ArrayList<Video> videos/*,String[] des*/) {
        context = cont;
        this.videos=videos;



    }

    @Override
    public int getCount() {
        return videos.size();
    }

    @Override
    public Object getItem(int position) {
        return videos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
@Override
    public View getView(int position,View convertView,ViewGroup parent) {
        try{
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.videos_list,parent,false);
            videoImage=(NetworkImageViewPlus)convertView.findViewById(R.id.videoImage);
            videoText=(TextView)convertView.findViewById(R.id.videoText);
            videoText.setText(videos.get(position).title);
            videoImage.setImageUrl(videos.get(position).img, AppController.getInstance().getImageLoader());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return convertView;

    };
}