package Fragments.Abstract;

import android.annotation.SuppressLint;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.hasan.fragments_with_navigator.R;

public abstract class ABackInnerFrag extends Fragment {

    public void config() {
        hideDrawer();
        hideFloating();
        changeDrawerIcon();
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

    private void changeDrawerIcon() {
        DrawerLayout drawer = getActivity().findViewById(R.id.drawer_layout);


        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_white_black_24dp);
        setHasOptionsMenu(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() != null) {
                    Toast.makeText(getActivity(), "Hasan123", Toast.LENGTH_SHORT).show();
                    getActivity().onBackPressed();
                }
            }
        });
    }
}
