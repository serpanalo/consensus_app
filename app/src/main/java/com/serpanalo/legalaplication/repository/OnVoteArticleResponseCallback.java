package com.serpanalo.legalaplication.repository;

import com.serpanalo.legalaplication.model.Article;

public interface OnVoteArticleResponseCallback {

    void onSuccess(Article article);
    void onError(String error);

}
