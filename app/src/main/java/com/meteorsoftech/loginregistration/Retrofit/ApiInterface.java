package com.meteorsoftech.loginregistration.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Dilip on 22-Nov-17.
 */

public interface ApiInterface  {

  @FormUrlEncoded
  @POST("register")
  Call <Result>createUser(@Field("name") String name,
                          @Field("email") String email,
                          @Field("password") String password,
                          @Field("gender") String gender);

  @FormUrlEncoded
  @POST("login")
  Call<Result> userLogin(
    @Field("email") String email,
    @Field("password") String password
  );
}
