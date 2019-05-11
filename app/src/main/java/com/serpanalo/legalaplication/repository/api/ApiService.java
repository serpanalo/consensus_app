package com.serpanalo.legalaplication.repository.api;

import com.serpanalo.legalaplication.model.Article;
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

    @POST("user/login")
    @FormUrlEncoded
    Call<User> login(@Field("user") String user, @Field("pass") String pass);

    @GET("document/active_document")
    Single<Document> getActiveDocument(@Header("uuid") String token);

    @POST("document/vote")
    @FormUrlEncoded
    Call<Document> postVote(@Header("uuid") String token,
                     @Field("document_id") String id,
                     @Field("structure_negative") boolean structure_negative ,
                     @Field("structure_positive")boolean structure_positive ,
                     @Field("redaction_positive")boolean redaction_positive ,
                     @Field("redaction_negative") boolean redaction_negative ,
                     @Field("implication_negative")boolean implication_negative ,
                     @Field("implication_positive") boolean implication_positive );


    @POST("article/vote")
    @FormUrlEncoded
    Call<Article> postVoteArticle(@Header("uuid") String token,
                                  @Field("article_id") String id,
                                  @Field("structure_negative") boolean structure_negative ,
                                  @Field("structure_positive")boolean structure_positive ,
                                  @Field("redaction_positive")boolean redaction_positive ,
                                  @Field("redaction_negative") boolean redaction_negative ,
                                  @Field("implication_negative")boolean implication_negative ,
                                  @Field("implication_positive") boolean implication_positive );

}
