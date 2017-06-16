package com.example.chipmunk.coffeestore.Search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chipmunk.coffeestore.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchPage extends Fragment {


    public SearchPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.search, container, false);
    }

}
