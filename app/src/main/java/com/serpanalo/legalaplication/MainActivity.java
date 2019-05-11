package com.serpanalo.legalaplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.serpanalo.legalaplication.Adapter.ArticleAdapter;
import com.serpanalo.legalaplication.holder.OnArticleAdapterClickListener;
import com.serpanalo.legalaplication.model.Article;
import com.serpanalo.legalaplication.model.Constants;
import com.serpanalo.legalaplication.model.Document;
import com.serpanalo.legalaplication.repository.OnDocumentResponseCallback;
import com.serpanalo.legalaplication.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observables.ConnectableObservable;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        OnDocumentResponseCallback,
        OnArticleAdapterClickListener {

    @BindView(R.id.articles_recycler)
    RecyclerView rvArticles;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private RecyclerView.LayoutManager rlayoutManager;
    private ArticleAdapter articleAdapter;
    private List<Article> articleList = new ArrayList<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private String documentId = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        loadDocument();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_validate) {
            gotoVote();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.active_document) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.about) {

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void readUser() {

    }

    private void loadDocument() {
        ConnectableObservable<Document> documentConnectableObservable = Repository.getActiveDocument().publish();
        disposable.add(Repository.loadDocument(documentConnectableObservable, this));
        documentConnectableObservable.connect();
    }


    @Override
    public void onSuccess(Document document) {


        if (document != null) {
            documentId = document.getId();

            if (document.getTitle() != null) {
                toolbar.setTitle(document.getTitle());
            }

            if (document.getArticles() != null) {
                articleList = document.getArticles();
                initAdapter();
            }

        }


    }

    @Override
    public void onError(String error) {

    }


    private void initAdapter() {

        articleAdapter = new ArticleAdapter(articleList, this, this);
        RecyclerView.LayoutManager sharesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvArticles.setLayoutManager(sharesLayoutManager);
        rvArticles.setItemAnimator(new DefaultItemAnimator());
        rvArticles.setAdapter(articleAdapter);
    }

    private void gotoVote() {//TODO ACtivityFOrREsult

        Intent intent = new Intent(this, VoteActivity.class);
        intent.putExtra(Constants.DOCUMENT_ID, documentId);
        startActivity(intent);
    }


    @Override
    public void onArticleValidateClicked(Article article, int position) {
        ArticleDialogFragment articleDialogFragment = ArticleDialogFragment.newInstance(article);
        articleDialogFragment.show(getSupportFragmentManager(), "dialogFragment");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
