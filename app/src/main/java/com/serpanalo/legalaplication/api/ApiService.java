package com.serpanalo.legalaplication.api;

import com.serpanalo.legalaplication.model.Document;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {

    @GET("active_document")
    Single<Document> getActiveDocument(@Header("token") String token);

}
