package com.serpanalo.legalaplication.repository;

import com.serpanalo.legalaplication.Utils;
import com.serpanalo.legalaplication.model.Article;
import com.serpanalo.legalaplication.repository.api.ApiClient;
import com.serpanalo.legalaplication.repository.api.ApiService;
import com.serpanalo.legalaplication.model.Document;
import com.serpanalo.legalaplication.model.User;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static ApiService apiService = ApiClient.getClient().create(ApiService.class);

    public static void postLogin(final String user, final String pass, final OnLoginResponseCallback onLoginResponseCallback) {

        Call<User> call = apiService.login(user, pass);

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


    public static void postVote(final String documentId,
                                boolean structure_negative,
                                boolean structure_positive,
                                boolean redaction_positive,
                                boolean redaction_negative,
                                boolean implication_negative,
                                boolean implication_positive,
                                final OnVoteResponseCallback onVoteResponseCallback) {

        Call<Document> call = apiService.postVote(Utils.getToken(),
                documentId, structure_negative,
                structure_positive,
                redaction_positive,
                redaction_negative,
                implication_negative,
                implication_positive);

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



    public static void postVoteArticle(final String articleId,
                                boolean structure_negative,
                                boolean structure_positive,
                                boolean redaction_positive,
                                boolean redaction_negative,
                                boolean implication_negative,
                                boolean implication_positive,
                                final OnVoteArticleResponseCallback onVoteArticleResponseCallback) {

        Call<Article> call = apiService.postVoteArticle(Utils.getToken(),
                articleId, structure_negative,
                structure_positive,
                redaction_positive,
                redaction_negative,
                implication_negative,
                implication_positive);

        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {

                if (response.code() == 200) {
                    onVoteArticleResponseCallback.onSuccess(response.body());
                } else {
                    onVoteArticleResponseCallback.onError("Not success");
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {
                onVoteArticleResponseCallback.onError(t.toString());
            }
        });
    }



    public static DisposableObserver<Document> loadDocument(ConnectableObservable<Document> cancionesObservable, final OnDocumentResponseCallback onDocumentResponseCallback) {

        return cancionesObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Document>() {

                                   @Override
                                   public void onNext(Document document) {
                                       onDocumentResponseCallback.onSuccess(document);
                                   }

                                   @Override
                                   public void onError(Throwable e) {
                                       onDocumentResponseCallback.onError(e.toString());
                                   }

                                   @Override
                                   public void onComplete() {

                                   }
                               }

                );
    }

    public static Observable<Document> getActiveDocument() {

        return apiService.getActiveDocument(Utils.getToken())
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
