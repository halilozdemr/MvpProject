package com.halilozdemr.mvpproject.rest.repository;

import com.halilozdemr.mvpproject.rest.model.User;
import com.halilozdemr.mvpproject.rest.model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiClient {

    String BASE_URL = "https://www.keyencryptedmessenger.com/";

    @POST("test/deneme")
    Observable<UserResponse> getUser(@Body User user);

}
