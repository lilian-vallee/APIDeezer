package com.example.androiddeezer2020.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.androiddeezer2020.service.data.DataAlbum;
import com.example.androiddeezer2020.service.data.DataSearchAlbum;
import com.example.androiddeezer2020.service.data.DataSearchArtist;

import java.net.URLEncoder;

public class DeezerService {
    private static final String TAG = "DeezerService";

    private DeezerService() {

    }

    public static void searchAuthor(Context context,
                             String artist,
                             Response.Listener<DataSearchArtist> response,
                             Response.ErrorListener errorListener) {
        Log.d(TAG, ">>searchAuthor artist="+artist);

        final String url = "https://api.deezer.com/search/artist?q=" + URLEncoder.encode(artist);
        Log.d(TAG, "searchAuthor " + url);

        RequestQueue queue = Volley.newRequestQueue(context);

        GsonRequest<DataSearchArtist> gsonRequest = new GsonRequest<>(url, DataSearchArtist.class, null,
                response, errorListener);

        queue.add(gsonRequest);
    }

//    public static void searchAuthor(String name, Response.Listener<DataArtist> response, Response.ErrorListener errorListener, Context context){
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url ="https://api.deezer.com/search/artist?q="+ URLEncoder.encode(name);
//        GsonRequest<DataArtist> gsonRequest=new GsonRequest(url, DataArtist.class,null,response,errorListener);
//        queue.add(gsonRequest);
//    }

    public static void searchAlbum(String name, Response.Listener<DataSearchAlbum> response, Response.ErrorListener errorListener, Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        System.out.println("id : " + name);
        String url ="https://api.deezer.com/search/album?q="+ URLEncoder.encode(name);
        GsonRequest<DataAlbum> gsonRequest = new GsonRequest(url, DataAlbum.class,null,response,errorListener);
        queue.add(gsonRequest);
    }

//    public static void searchTrack(String name, Response.Listener<DataTrack> response, Response.ErrorListener errorListener, Context context){
//        RequestQueue queue = Volley.newRequestQueue(context);
//        System.out.println("id : " +name);
//        String url ="https://api.deezer.com/search/track?q="+ URLEncoder.encode(name);
//        GsonRequest<DataTrack> gsonRequest=new GsonRequest(url, DataTrack.class,null,response,errorListener);
//        queue.add(gsonRequest);
//    }
}
