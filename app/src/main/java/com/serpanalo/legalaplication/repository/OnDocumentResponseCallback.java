package com.serpanalo.legalaplication.repository;

import com.serpanalo.legalaplication.model.Document;

public interface OnDocumentResponseCallback {

    void onSuccess(Document document);
    void onError(String error);

}
