package Fragments;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.WindowManager;

import com.example.hasan.fragments_with_navigator.R;

public class Frond_Fragment extends Fragment {

    public void fullScreen(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        //setHasOptionsMenu(true);
        //toolbar.setVisibility(View.INVISIBLE);

        AppBarLayout appBarLayout = activity.findViewById(R.id.appbar);
        appBarLayout.setVisibility(View.GONE);
    }

}
