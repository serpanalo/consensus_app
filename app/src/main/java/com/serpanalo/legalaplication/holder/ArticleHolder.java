package com.serpanalo.legalaplication.holder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.serpanalo.legalaplication.R;
import com.serpanalo.legalaplication.model.Article;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.description_text)
    public TextView tvDescription;

    @BindView(R.id.cap_text)
    public TextView tvCap;

    @BindView(R.id.fab_article_vote)
    FloatingActionButton fabArticleVote;

    private Article article;
    private int position;

    OnArticleAdapterClickListener onArtistAdapterClickListener;

    public ArticleHolder(View itemView, final OnArticleAdapterClickListener articleAdapterClickListener) {
        super(itemView);

        this.onArtistAdapterClickListener = articleAdapterClickListener;

        ButterKnife.bind(this, itemView);

        fabArticleVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                articleAdapterClickListener.onArticleValidateClicked(article, position);

            }
        });

    }

    public void setItem(Article item, int position) {
        this.article = item;
        this.position = position;
    }
}