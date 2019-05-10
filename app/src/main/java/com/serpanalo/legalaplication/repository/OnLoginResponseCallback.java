package com.serpanalo.legalaplication.repository;

import com.serpanalo.legalaplication.model.User;

public interface OnLoginResponseCallback {

    void onSuccess(User user);
    void onError(String error);

}
