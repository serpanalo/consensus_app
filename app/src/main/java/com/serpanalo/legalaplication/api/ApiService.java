package com.serpanalo.legalaplication.api;

import com.serpanalo.legalaplication.model.Document;
import com.serpanalo.legalaplication.model.User;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    @GET("active_document")
    Single<Document> getActiveDocument(@Header("token") String token);

    @POST("login")
    @FormUrlEncoded
    Call<User> login(@Header("uuid") String token, @Field("user") String user, @Field("pass") String pass);


}
