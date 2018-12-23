package Fragments.BackFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hasan.fragments_with_navigator.R;

import Fragments.Abstract.ABack_Fragment;
import Fragments.Fragments;


public class BackGalleryFragment extends ABack_Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        config(getActivity());
        return inflater.inflate(R.layout.fragment_back_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn = getActivity().findViewById(R.id.btResim1);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btResim1:
                addFragment(Fragments.Back_Inner_Gallery);
                break;
        }
    }
}
