package com.example.androiddeezer2020;

import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.androiddeezer2020.adapter.AlbumAdapter;
import com.example.androiddeezer2020.service.DeezerService;
import com.example.androiddeezer2020.service.data.DataSearchAlbum;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class ListAlbumsActivity extends AppCompatActivity {
    private static final String TAG = "ListAlbumsActivity";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_album);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String artist = getIntent().getStringExtra("artist");

        recyclerView = (RecyclerView) findViewById(R.id.album_recycler_view);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Response.Listener<DataSearchAlbum> rep = new Response.Listener<DataSearchAlbum>() {
            @Override
            public void onResponse(DataSearchAlbum response) {
                Log.d(TAG, "searchAlbum Found " + response.getTotal() + " album");
                AlbumAdapter albumAdapter = new AlbumAdapter(response.getData());
                recyclerView.setAdapter(albumAdapter);
            }
        };
        final Response.ErrorListener error = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "searchAuthor onErrorResponse: " + error.getMessage());
            }
        };

        DeezerService.searchAlbum(artist, rep, error, ListAlbumsActivity.this);
    }
}