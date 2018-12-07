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

    private void change(Enum fragmentIsmı, Fragment fragment) {
        ((FragmentActivity) cxt).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragmentIsmı.name())
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();


        Toast.makeText(cxt, ":" + fragmentIsmı.name(), Toast.LENGTH_SHORT).show();
        cxt = null;
    }

    //stack e atmaz
    private void change(Fragment fragment) {
        ((FragmentActivity) cxt).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

        cxt = null;
    }

    public void replace_fragment(Fragments fragments) {
        Fragment fragment;
        switch (fragments) {
            case Frond_Splash:
                fragment = new FrondSplashFragment();
                break;
            case Frond_Mode:
                fragment = new FrondModeFragment();
                break;
            case Frond_Login:
                fragment = new FrondLoginFragment();
                break;
            case Back_Home:
                fragment = new BackHomeFragment();
                break;
            case Back_Import:
                fragment = new BackImportFragment();
                break;
            case Back_Tools:
                fragment = new BackToolsFragment();
                break;
            case Back_Gallery:
                fragment = new BackGalleryFragment();
                break;
            case Back_Slideshow:
                fragment = new BackSlideshowFragment();
                break;
            case Back_Inner_Gallery:
                fragment = new BackInnerGalleryDetailFragment();
                break;
            default:
                fragment = new FrondSplashFragment();
                break;
        }
        change(fragment);
    }

    public void replace_fragment(Fragments fragments, Context cxt) {
        this.cxt = cxt;
        replace_fragment(fragments);
    }
}
