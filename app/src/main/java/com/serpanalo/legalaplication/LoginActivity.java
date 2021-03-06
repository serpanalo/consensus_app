package com.serpanalo.legalaplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.serpanalo.legalaplication.repository.OnLoginResponseCallback;
import com.serpanalo.legalaplication.repository.Repository;
import com.serpanalo.legalaplication.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements OnLoginResponseCallback {

    @BindView(R.id.til_user)
    TextInputLayout tilUser;
    @BindView(R.id.til_pass)
    TextInputLayout tilPass;
    @BindView(R.id.logo_image)
    ImageView ivlogoImage;
    @BindView(R.id.ti_user)
    TextInputEditText tiUser;
    @BindView(R.id.ti_pass)
    TextInputEditText tiPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    private void verifyData() {

        boolean errors = false;

        String user = tiUser.getText().toString();
        String pass = tiPass.getText().toString();

        if (TextUtils.isEmpty(user)) {
            tilUser.setError(getResources().getString(R.string.no_user));
            errors = true;
        }

        if (TextUtils.isEmpty(pass)) {
            tilUser.setError(getResources().getString(R.string.no_pass));
            errors = true;
        }

        if (!errors) {
            sendLogin(user, pass);
        }

    }

    public void sendLogin(String user, String pass) {

        Repository.postLogin(user, pass, this);
    }


    @OnClick(R.id.login_button)
    public void onViewClicked() {
        verifyData();
    }


    @Override
    public void onSuccess(User user) {

        if (user != null) {
            Log.d("XX", "Login Ok " + user.toString());
            Utils.saveToken(user.getToken());
            launchHome();
        } else {

        }


    }

    @Override
    public void onError(String error) {
        //TODO toast hay un error

    }


    private void launchHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
