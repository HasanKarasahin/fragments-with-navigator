package Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.example.hasan.fragments_with_navigator.R;

public class ChangeFragment {
    Context cxt;

    public ChangeFragment(Context cxt) {
        this.cxt = cxt;
    }

    public void change(Enum fragmentIsmı, IFragmentFabrikasi fragmentFabrikasi) {
        Fragment fragment = fragmentFabrikasi.getInstance(fragmentIsmı);
        ((FragmentActivity) cxt).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragmentIsmı.name())
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();


        Toast.makeText(cxt, ":" + fragmentIsmı.name(), Toast.LENGTH_SHORT).show();
        cxt = null;
    }
}
