package com.serpanalo.legalaplication;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

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

        String email = tiUser.getText().toString();
        String password = tiPass.getText().toString();

        if (TextUtils.isEmpty(email)) {
            tilUser.setError(getResources().getString(R.string.no_user));
            errors = true;
        }

        if (TextUtils.isEmpty(password)) {
            tilUser.setError(getResources().getString(R.string.no_pass));
            errors = true;
        }

        if (!errors){
            sendLogin();
        }

    }

    public void sendLogin(){

        //TODO UserRepository.sendLoginRequest("","",this);
    }


    @OnClick(R.id.login_button)
    public void onViewClicked() {
        verifyData();
    }


}
