package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        FragmentOne.OnFragmentInteractionListener
         {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_main);
             FragmentManager fragmentManager = getSupportFragmentManager();
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             FragmentOne fragment = FragmentOne.newInstance();
             fragmentTransaction.add(R.id.FragmentOne, fragment);
             fragmentTransaction.commit();
}

    @Override
    public void onFragmentInteraction(String text, int colorId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTwo fragment = FragmentTwo.newInstance(text, colorId);
        fragmentTransaction.replace(R.id.FragmentTwo, fragment);
        fragmentTransaction.commit();

    }
}

