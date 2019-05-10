package com.serpanalo.legalaplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.serpanalo.legalaplication.model.Document;
import com.serpanalo.legalaplication.repository.OnVoteResponseCallback;
import com.serpanalo.legalaplication.repository.Repository;

import butterknife.ButterKnife;

public class VoteActivity extends AppCompatActivity implements OnVoteResponseCallback {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        ButterKnife.bind(this);
        sendVote();
    }

    private void sendVote() {

        Repository.postVote(Utils.getToken(), "1",
                false, true,
                false, true,
                false, true,this);

    }

    @Override
    public void onSuccess(Document document) {

        if (document != null) {
            Log.d("XX","ok");
        }

    }

    @Override
    public void onError(String error) {

    }
}
