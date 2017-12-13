package com.meteorsoftech.loginregistration.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.meteorsoftech.loginregistration.R;

import java.io.BufferedReader;

/**
 * Created by Dilip on 22-Nov-17.
 */

public class Fragment_Login extends Fragment {
  EditText edtemil,edtspassword;
  Button button;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_login,container,false);

    edtemil = (EditText)v.findViewById(R.id.editTextEmail);
    edtspassword = (EditText)v.findViewById(R.id.editTextPassword);
    button = (Button)v.findViewById(R.id.buttonSignIn);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        userLogin();
      }
    });
    return v;
  }
  public void userLogin()
  {

    

  }
}
