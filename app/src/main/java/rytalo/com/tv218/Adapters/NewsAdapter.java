package rytalo.com.tv218.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageViewPlus;

import java.util.ArrayList;

import rytalo.com.tv218.AppController;
import rytalo.com.tv218.R;
import rytalo.com.tv218.model.Category;

/**
 * Created by dinamounib on 2/23/16.
 */
public class NewsAdapter extends BaseAdapter {


    Context context;
    ArrayList<Category> categories;
    NetworkImageViewPlus categoryImage;
    TextView categoryText;
    public NewsAdapter(Context cont, ArrayList<Category> categories) {
        context = cont;
        this.categories = categories;

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater
                    .inflate(R.layout.category_item, parent, false);

            categoryImage = (NetworkImageViewPlus) convertView
                    .findViewById(R.id.categoryImage);
            categoryText = (TextView) convertView.findViewById(R.id.categoryText);

            categoryText.setText(categories.get(position).name);
            categoryImage.setImageUrl(categories.get(position).uri, AppController.getInstance().getImageLoader());
        } catch (Exception e) {
            // TODO: handle exception
        }
        return convertView;
    }
}
