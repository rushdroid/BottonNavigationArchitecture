package com.rushdroid.myapplication.fragment.innerFragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rushdroid.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeInnerFragment extends Fragment {


    public HomeInnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.txtHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Navigation.findNavController(v).navigate(R.id.toNH3);
            }
        });
    }
}
