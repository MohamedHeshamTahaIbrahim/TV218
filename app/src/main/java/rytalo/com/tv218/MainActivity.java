package rytalo.com.tv218;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

import rytalo.com.tv218.controller.FeaturedVideo;
import rytalo.com.tv218.interfaces.ResultStatus;
import rytalo.com.tv218.model.Category;
import rytalo.com.tv218.model.Video;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements ResultStatus {
        ListView list_Images_lv;
        private static final String TAG = MainActivity.class.getSimpleName();
        ArrayList<Video> video;
        CustomListAdapter customListAdapter;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            final ProgramsController programsController=new ProgramsController();
            new FeaturedVideo(getActivity(),getActivity());
            list_Images_lv=(ListView)rootView.findViewById(R.id.list);
            customListAdapter=new CustomListAdapter(getActivity(),video);

            list_Images_lv.setAdapter(customListAdapter);
            return rootView;
        }

        @Override
        public void setresult_onsucceed(String result) {
            try {
                video = new ArrayList<Video>();

                JSONArray arr =new JSONArray(result);
                Video vid;
                for(int i=0;i<arr.length();i++)
                {
                    vid = new Video();
                    vid.populateVideo(arr.getJSONObject(i));
                    video.add(vid);
                }
                AppController.getInstance().getImageLoader();
            }
            catch (Exception e){
                Log.i("video screen", e.getMessage());
            }
            }

        }

        @Override
        public void setresult_onfailed(String result) {

        }
    }
}
