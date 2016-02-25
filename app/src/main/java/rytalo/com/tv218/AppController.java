package rytalo.com.tv218;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.android.volley.cache.plus.ImageCache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.cache.plus.ImageLoader;
import com.android.volley.toolbox.Volley;


import java.util.ArrayList;

import rytalo.com.tv218.Networking.BitmapCache;
import rytalo.com.tv218.drawing.TransparentProgressDialog;
import rytalo.com.tv218.model.Category;
import rytalo.com.tv218.model.Video;

/**
 * Created by dinamounib on 2/22/16.
 */
public class AppController extends Application{
    public static final String TAG = AppController.class.getSimpleName();
    private static AppController mInstance;
    private static Context mContext;
    public static ConnectivityManager cm;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    TransparentProgressDialog trasparentPD;
    public ArrayList<Category> categories;
    public ArrayList<Video> videos;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mContext = getApplicationContext();
        cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

    }

    public AppController() {
        // TODO Auto-generated constructor stub
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    (ImageCache) new BitmapCache());

        }

        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public static Context getmContext() {
        return mContext;
    }

    public void opentransparentProgressDialog(Context activity) {
        trasparentPD = new TransparentProgressDialog(activity,
                R.drawable.spinner);
        trasparentPD.show();
        trasparentPD.setCancelable(true);
    }

    public void closetransparentProgressDialog() {
        trasparentPD.dismiss();
    }

    public static boolean hasConnection(FragmentActivity activity) {
        NetworkInfo wifiNetwork = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }

        NetworkInfo mobileNetwork = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }
        //
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }

        openDialog("Message", "Please check your internet connection.",
                activity);
        return false;
    }

    public static void openDialog(String title, String msg, Context con) {
        // TODO Auto-generated method stub
        new AlertDialog.Builder(con).setTitle(title).setMessage(msg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

    }
}
