package Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.example.hasan.fragments_with_navigator.R;

import Fragments.BackFragments.*;
import Fragments.BackInner.*;
import Fragments.FrondFragments.*;

public class ChangeFragment {
    Context cxt;

    public ChangeFragment(Context cxt) {
        this.cxt = cxt;
    }

    private void change_addstack(Fragment fragment) {
        ((FragmentActivity) cxt).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
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
        change(obj(fragments));
    }

    public void replace_fragment(Fragments fragments, Context cxt) {
        this.cxt = cxt;
        replace_fragment(fragments);
    }

    public void add_fragment(Fragments fragments) {
        change_addstack(obj(fragments));
    }

    private Fragment obj(Fragments fragments) {
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
        return fragment;
    }
}
