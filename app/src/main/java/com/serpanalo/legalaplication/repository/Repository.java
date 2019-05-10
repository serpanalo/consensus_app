package com.serpanalo.legalaplication.repository;

import com.serpanalo.legalaplication.repository.api.ApiClient;
import com.serpanalo.legalaplication.repository.api.ApiService;
import com.serpanalo.legalaplication.model.Document;
import com.serpanalo.legalaplication.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static ApiService apiService = ApiClient.getClient().create(ApiService.class);

    public static void postLogin(final String user,final String pass, final OnLoginResponseCallback onLoginResponseCallback) {

        Call<User> call = apiService.login("token",user, pass);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.code() == 200) {
                    onLoginResponseCallback.onSuccess(response.body());
                } else {
                    onLoginResponseCallback.onError("Not success");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                onLoginResponseCallback.onError(t.toString());
            }
        });
    }



    public static void postVote(final String token, final String documentId,
                                boolean structure_negative ,
                                boolean structure_positive ,
                                boolean redaction_positive ,
                                boolean redaction_negative ,
                                boolean implication_negative ,
                                boolean implication_positive,
                                final OnVoteResponseCallback onVoteResponseCallback) {

        Call<Document> call = apiService.postVote(token,
                documentId, structure_negative,
                structure_positive ,
                redaction_positive ,
                redaction_negative ,
                implication_negative ,
                implication_positive );

        call.enqueue(new Callback<Document>() {
            @Override
            public void onResponse(Call<Document> call, Response<Document> response) {

                if (response.code() == 200) {
                    onVoteResponseCallback.onSuccess(response.body());
                } else {
                    onVoteResponseCallback.onError("Not success");
                }
            }

            @Override
            public void onFailure(Call<Document> call, Throwable t) {
                onVoteResponseCallback.onError(t.toString());
            }
        });
    }
}
