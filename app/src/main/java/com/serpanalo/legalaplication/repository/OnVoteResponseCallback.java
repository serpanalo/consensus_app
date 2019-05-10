package com.serpanalo.legalaplication.repository;

import com.serpanalo.legalaplication.model.Document;

public interface OnVoteResponseCallback {

    void onSuccess(Document document);
    void onError(String error);

}
