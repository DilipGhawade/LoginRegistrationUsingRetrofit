package com.meteorsoftech.loginregistration.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.meteorsoftech.loginregistration.R;

/**
 * Created by Dilip on 22-Nov-17.
 */

public class Fragment_Home extends Fragment implements View.OnClickListener {

  Button btnsignIn,btnsignUp;
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_home,container,false);
    return v;
  }


  public void replacementFragment(Fragment fragment, boolean addToBack)
  {
    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.Main_Container,fragment,fragment.getClass().getName());
    if(addToBack)
      ft.addToBackStack(null);
    ft.commit();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    btnsignIn = (Button)view.findViewById(R.id.buttonSignIn);
    btnsignUp = (Button)view.findViewById(R.id.buttonSignUp);
    btnsignUp.setOnClickListener(this);
    btnsignIn.setOnClickListener(this);

  }

  @Override
  public void onClick(View view) {
    switch (view.getId())
    {
      case R.id.buttonSignIn:
        replacementFragment(new Fragment_Login(),true);
        break;
      case R.id.buttonSignUp:
        replacementFragment(new Fragment_Registration(),true);
        break;
        default:
    }

  }
}
