package com.meteorsoftech.loginregistration.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.meteorsoftech.loginregistration.R;
import com.meteorsoftech.loginregistration.Retrofit.ApiInterface;
import com.meteorsoftech.loginregistration.Retrofit.AppUrl;
import com.meteorsoftech.loginregistration.Retrofit.Result;
import com.meteorsoftech.loginregistration.Retrofit.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Delete on 8/9/2017.
 */

public class Fragment_Registration extends Fragment implements View.OnClickListener{
  private Button buttonSignUp;
  private EditText editTextName, editTextEmail, editTextPassword;
  private RadioGroup radioGender;
  Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_fragment,container,false);

      buttonSignUp = (Button)view.findViewById(R.id.buttonSignIn);
      editTextName = (EditText)view.findViewById(R.id.editTextName);
      editTextEmail = (EditText)view.findViewById(R.id.editTextEmail);
      editTextPassword = (EditText)view.findViewById(R.id.editTextPassword);
      radioGender = (RadioGroup)view.findViewById(R.id.radioGender);
      buttonSignUp.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
      if (v==buttonSignUp)
      {
        userSignUp();
      }

    }
    public void userSignUp()
    {
      final ProgressDialog pd = new ProgressDialog(getContext());
      pd.setTitle("SignUp");
      pd.show();

      final RadioButton radioSex = (RadioButton)getView().findViewById(radioGender.getCheckedRadioButtonId());


      String name = editTextName.getText().toString().trim();
      String email = editTextEmail.getText().toString().trim();
      String password = editTextPassword.getText().toString().trim();
      final String gender = radioSex.getText().toString().trim();

      Retrofit retrofit = new Retrofit.Builder().baseUrl(AppUrl.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build();

      ApiInterface apiInterface = retrofit.create(ApiInterface.class);
      User user = new User(name,email,password,gender);

      Call<Result> call = apiInterface.createUser(
        user.getName(),
        user.getEmail(),
        user.getPassword(),
        user.getGender()
      );

      call.enqueue(new Callback<Result>() {
        @Override
        public void onResponse(Call<Result> call, Response<Result> response) {
          pd.dismiss();



          Toast.makeText(getActivity(),response.body().getMessage(),Toast.LENGTH_LONG).show();
        }

        @Override
        public void onFailure(Call<Result> call, Throwable t) {

          Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_LONG).show();

        }
      });


    }
}
