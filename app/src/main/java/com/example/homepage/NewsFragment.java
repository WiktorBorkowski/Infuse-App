package com.example.homepage;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    String api = "c6ab9f0172164417ac9b5c0aaa524e2a";

    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;

    String keyword = "Ericsson";

    private RecyclerView recyclerViewOfNews;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newsfragment, null);

        recyclerViewOfNews = view.findViewById(R.id.recycler_view_of_news);
        modelClassArrayList = new ArrayList<>();
        recyclerViewOfNews.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelClassArrayList);

        recyclerViewOfNews.setAdapter(adapter);

        findNews();


        return view;
    }

    private void findNews() {
        // change getNews to getCountryNews
        ApiUtilities.getApiInterface().getCategoryNews(keyword, "en", 20, "relevancy", api).enqueue(new Callback<ericssonNews>()
        {
            @Override
            public void onResponse(Call<ericssonNews> call, Response<ericssonNews> response) {

                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
                else {
                }
            }

            @Override
            public void onFailure(Call<ericssonNews> call, Throwable t) {


            }
        });
    }
}
