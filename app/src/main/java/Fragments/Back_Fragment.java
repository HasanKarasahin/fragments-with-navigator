package Fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.WindowManager;

import com.example.hasan.fragments_with_navigator.R;

public abstract class Back_Fragment extends Fragment {

    public void config(Activity activity) {
        appBarShow(activity);
        showFloating();
        showDrawer();
    }

    private void appBarShow(Activity activity) {
        AppBarLayout appBarLayout = activity.findViewById(R.id.appbar);
        appBarLayout.setVisibility(View.VISIBLE);
    }

    @SuppressLint("RestrictedApi")
    private void showFloating() {
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);

        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        p.setAnchorId(View.NO_ID);
        fab.setLayoutParams(p);
        fab.setVisibility(View.VISIBLE);
    }

    private void showDrawer() {
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
    }
}
