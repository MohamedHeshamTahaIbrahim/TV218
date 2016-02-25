package rytalo.com.tv218.view.news;

import java.util.Locale;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import rytalo.com.tv218.AppController;
import rytalo.com.tv218.MainActivity;
import rytalo.com.tv218.R;


public class PlanetFragment extends Fragment {
    public static final String ARG_PLANET_NUMBER = "planet_number";

    public PlanetFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_planet, container,
                false);
        int i = getArguments().getInt(ARG_PLANET_NUMBER);
        String planet = AppController.getInstance().categories.get(i).name;

        int imageId = getResources().getIdentifier(
                planet.toLowerCase(Locale.getDefault()), "drawable",
                getActivity().getPackageName());
        ((ImageView) rootView.findViewById(R.id.image))
                .setImageResource(R.drawable.drawer_shadow);
        getActivity().setTitle(planet);

       // View mCustomView = mInflater.inflate(R.layout.header, null);
        TextView menuBtn = (TextView) rootView.findViewById(R.id.menuButton);
        TextView mTitleTextView = (TextView) rootView.findViewById(R.id.logo);
        mTitleTextView.setText(planet);
        menuBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (MainActivity.mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    MainActivity.mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    MainActivity.mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
            }
        });
        return rootView;
    }
}