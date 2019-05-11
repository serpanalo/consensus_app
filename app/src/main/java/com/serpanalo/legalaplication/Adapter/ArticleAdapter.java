package com.serpanalo.legalaplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.serpanalo.legalaplication.R;
import com.serpanalo.legalaplication.holder.ArticleHolder;
import com.serpanalo.legalaplication.holder.OnArticleAdapterClickListener;
import com.serpanalo.legalaplication.model.Article;

import java.util.List;

import butterknife.BindView;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleHolder> {

    private List<Article> articles;
    private Context context;
    private OnArticleAdapterClickListener onArticleAdapterClickListener;


    public ArticleAdapter(List<Article> articleList, Context context, OnArticleAdapterClickListener onArtistAdapterClickListener) {
        this.articles = articleList;
        this.context = context;
        this.onArticleAdapterClickListener = onArtistAdapterClickListener;
    }

    @NonNull
    @Override
    public ArticleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleHolder(itemView, onArticleAdapterClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleHolder holder, int position) {

        Article article = articles.get(position);
        holder.setItem(article, position);

        if (article.getDescription() != null) {
            holder.tvDescription.setText(article.getDescription());
        }

        if (article.getTitle() != null) {
            holder.tvCap.setText(article.getTitle());
        }

       // holder.positionText.setText(position + "de" + articles.size());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


}
