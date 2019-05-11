package com.serpanalo.legalaplication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.serpanalo.legalaplication.model.Article;
import com.serpanalo.legalaplication.model.Constants;
import com.serpanalo.legalaplication.repository.OnVoteArticleResponseCallback;
import com.serpanalo.legalaplication.repository.Repository;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ArticleDialogFragment extends DialogFragment implements OnVoteArticleResponseCallback {

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
    Unbinder unbinder;

    private String articleId;
    private Article article;

    public ArticleDialogFragment() {

    }

    public static ArticleDialogFragment newInstance(Article article) {
        ArticleDialogFragment frag = new ArticleDialogFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.ARTICLE, article);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_fragment, container);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog d = getDialog();
        if (d != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            d.getWindow().setLayout(width, height);
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        loadInfo();
    }


    private void loadInfo() {

        Bundle extras = getArguments();
        if (extras != null) {
            if(extras.containsKey(Constants.ARTICLE)) {
                article = extras.getParcelable(Constants.ARTICLE);

                if(article.getId()!=null){
                  articleId= article.getId();
                }
            }

        }
    }

    @OnClick({R.id.send_button, R.id.close_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.send_button:
                sendVote();
                break;
            case R.id.close_image:
                dismiss();
                break;
        }
    }



    private void sendVote() {

        Repository.postVoteArticle(articleId,
                rbStructureNegative.isChecked(), rbStruturePos.isChecked(),
                rbRedactionPos.isChecked(), rbRedactionNegative.isChecked(),
                rbImplicationNegative.isChecked(), rbImplicationPos.isChecked(), this);

    }


    @Override
    public void onSuccess(Article article) {
        dismiss();
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}