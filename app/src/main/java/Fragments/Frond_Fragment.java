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

public abstract class Frond_Fragment extends Fragment implements View.OnClickListener {
    private ChangeFragment changeFragment;


    public void config(Activity activity) {
        fullScreen(activity);
        hideDrawer();
        hideFloating();
    }

    private void fullScreen(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        //setHasOptionsMenu(true);
        //toolbar.setVisibility(View.INVISIBLE);

        AppBarLayout appBarLayout = activity.findViewById(R.id.appbar);
        appBarLayout.setVisibility(View.GONE);
    }

    private void hideDrawer() {
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @SuppressLint("RestrictedApi")
    private void hideFloating() {
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);

        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        p.setAnchorId(View.NO_ID);
        fab.setLayoutParams(p);
        fab.setVisibility(View.GONE);
    }

    public void changeFragment(Fragment iFragmentFabrikasi) {
        changeFragment = new ChangeFragment(getActivity());
        changeFragment.change(iFragmentFabrikasi);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSplash:
                changeFragment(new ModeFragment());
                break;
            case R.id.tvMode:
                changeFragment(new LoginFragment());
                break;
            case R.id.tvLogin:
                changeFragment(new HomeFragment());
                break;
        }
    }
}
