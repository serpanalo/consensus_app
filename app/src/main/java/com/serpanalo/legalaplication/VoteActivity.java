package com.serpanalo.legalaplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.serpanalo.legalaplication.model.Constants;
import com.serpanalo.legalaplication.model.Document;
import com.serpanalo.legalaplication.repository.OnVoteResponseCallback;
import com.serpanalo.legalaplication.repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VoteActivity extends AppCompatActivity implements OnVoteResponseCallback {


    @BindView(R.id.rb_struture_pos)
    RadioButton rbStruturePos;
    @BindView(R.id.rb_structure_negative)
    RadioButton rbStructureNegative;
    @BindView(R.id.rg_structure)
    RadioGroup rgStructure;
    @BindView(R.id.rb_redaction_pos)
    RadioButton rbRedactionPos;
    @BindView(R.id.rb_redaction_negative)
    RadioButton rbRedactionNegative;
    @BindView(R.id.rg_redaction)
    RadioGroup rgRedaction;
    @BindView(R.id.rb_implication_pos)
    RadioButton rbImplicationPos;
    @BindView(R.id.rb_implication_negative)
    RadioButton rbImplicationNegative;
    @BindView(R.id.rg_implications)
    RadioGroup rgImplications;
    @BindView(R.id.pBar)
    ProgressBar pBar;

    private String documentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        ButterKnife.bind(this);
        loadInfo();
    }

    private void loadInfo() {

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            documentId = extras.getString(Constants.DOCUMENT_ID);
        }

    }

    private void sendVote() {

        pBar.setVisibility(View.VISIBLE);

        Repository.postVote(documentId,
                rbStructureNegative.isChecked(), rbStruturePos.isChecked(),
                rbRedactionPos.isChecked(), rbRedactionNegative.isChecked(),
                rbImplicationNegative.isChecked(), rbImplicationPos.isChecked(), this);
    }

    @Override
    public void onSuccess(Document document) {

        pBar.setVisibility(View.GONE);

        if (document != null) {
            Log.d("XX", "ok");
        }

    }

    @Override
    public void onError(String error) {
        pBar.setVisibility(View.GONE);

    }

    public boolean checkSelection() {

        boolean error = false;

        if (!rbImplicationNegative.isSelected() && !rbImplicationPos.isSelected()) {
            error = true;
        }
        if (!rbRedactionNegative.isSelected() && !rbRedactionPos.isSelected()) {
            error = true;
        }

        if (!rbStructureNegative.isSelected() && !rbImplicationNegative.isSelected()) {
            error = true;
        }

        return error;

    }


    @OnClick(R.id.send_button)
    public void onViewClicked() {

        // if (!checkSelection()) {
        sendVote();
        // }
    }
}
