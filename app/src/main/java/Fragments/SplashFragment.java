package Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hasan.fragments_with_navigator.R;


public class SplashFragment extends Frond_Fragment implements IFragmentFabrikasi, View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fullScreen(getActivity());
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvSplash = getActivity().findViewById(R.id.tvSplash);
        tvSplash.setOnClickListener(this);
    }

    @Override
    public Fragment getInstance(Enum fragmentAdi) {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSplash:
                Toast.makeText(getContext(), "Basıldı", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
