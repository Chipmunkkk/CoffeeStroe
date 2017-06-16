package com.example.chipmunk.coffeestore.Me;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chipmunk.coffeestore.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MePage extends Fragment {


    public MePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.me, container, false);
    }

}
