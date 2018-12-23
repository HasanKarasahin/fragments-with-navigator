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
                fragment = new FrondFragSplash();
                break;
            case Frond_Mode:
                fragment = new FrondFragMode();
                break;
            case Frond_Login:
                fragment = new FrondFragLogin();
                break;
            case Back_Home:
                fragment = new BackFragHome();
                break;
            case Back_Import:
                fragment = new BackFragImport();
                break;
            case Back_Tools:
                fragment = new BackFragTools();
                break;
            case Back_Gallery:
                fragment = new BackFragGallery();
                break;
            case Back_Slideshow:
                fragment = new BackFragSlideshow();
                break;
            case Back_Inner_Gallery:
                fragment = new BackInFragGalleryDetail();
                break;
            default:
                fragment = new FrondFragSplash();
                break;
        }
        return fragment;
    }
}
