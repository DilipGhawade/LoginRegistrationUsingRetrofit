package com.meteorsoftech.loginregistration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.meteorsoftech.loginregistration.fragment.Fragment_Home;
import com.meteorsoftech.loginregistration.fragment.Fragment_Registration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replacementFragment(new Fragment_Home(),true);
    }
    public void replacementFragment(Fragment fragment, boolean addToBack)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Main_Container,fragment,fragment.getClass().getName());
        if(addToBack)
            ft.addToBackStack(null);
        ft.commit();
    }

}
