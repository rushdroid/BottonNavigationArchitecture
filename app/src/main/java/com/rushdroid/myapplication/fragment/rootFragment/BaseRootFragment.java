package com.rushdroid.myapplication.fragment.rootFragment;

import android.os.Bundle;
import android.view.View;

import com.rushdroid.myapplication.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class BaseRootFragment extends Fragment {
    private NavController navController;

    public NavController getNavController() {
        return navController;
    }

    public void setNavController(NavController navController) {
        this.navController = navController;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view.findViewById(R.id.fragmentNavHost));
    }
}
