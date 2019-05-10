package com.serpanalo.legalaplication;

import com.serpanalo.legalaplication.model.User;

public interface OnLoginResponseCallback {

    void onSuccess(User user);
    void onError(String error);

}
