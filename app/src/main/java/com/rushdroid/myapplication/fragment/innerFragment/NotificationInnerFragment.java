package com.rushdroid.myapplication.fragment.innerFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rushdroid.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationInnerFragment extends Fragment {


    public NotificationInnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notif3, container, false);
    }

}
