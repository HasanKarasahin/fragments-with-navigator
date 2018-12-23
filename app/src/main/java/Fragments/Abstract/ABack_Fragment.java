package Fragments.Abstract;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.hasan.fragments_with_navigator.R;

import Fragments.Fragments;
import Fragments.ChangeFragment;

public abstract class ABack_Fragment extends Fragment implements View.OnClickListener {

    public void config(Activity activity) {
        appBarShow(activity);
        showFloating();
        showDrawer();
        changeDrawerIcon();
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

    private void changeDrawerIcon() {
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);


        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        setHasOptionsMenu(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }


    public void changeFragment(Fragments fragments) {
        ChangeFragment changeFragment = new ChangeFragment(getActivity());
        changeFragment.replace_fragment(fragments);
    }

    public void addFragment(Fragments fragments) {
        ChangeFragment changeFragment = new ChangeFragment(getActivity());
        changeFragment.add_fragment(fragments);
    }
}
