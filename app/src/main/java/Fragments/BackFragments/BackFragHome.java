package Fragments.BackFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasan.fragments_with_navigator.R;

import Fragments.Abstract.ABackFrag;


public class BackFragHome extends ABackFrag {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        config(getActivity());
        return inflater.inflate(R.layout.fragment_back_home, container, false);
    }

    @Override
    public void onClick(View v) {

    }
}
