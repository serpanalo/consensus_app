package com.serpanalo.legalaplication;

import com.serpanalo.legalaplication.api.ApiClient;
import com.serpanalo.legalaplication.api.ApiService;
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
}
