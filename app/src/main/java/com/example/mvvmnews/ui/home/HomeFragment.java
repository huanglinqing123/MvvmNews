package com.example.mvvmnews.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmnews.R;
import com.example.mvvmnews.bean.NewBean;
import com.google.gson.Gson;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private View root;

    private String appKey = "04ea095cbea56775e2d1669713f34cc2";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory(appKey)).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        initView();

        homeViewModel.getNews("top");
        homeViewModel.newsBean.observe(getActivity(), new Observer<NewBean>() {
            @Override
            public void onChanged(NewBean newBean) {
                if (newBean != null) {
                    if (newBean.getError_code() == 0) {
                        NewsAdapter newsAdapter = new NewsAdapter(newBean.getResult().getData(), getActivity());
                        recyclerView.setAdapter(newsAdapter);
                    }
                }
            }
        });


        return root;
    }

    private void initView() {
        recyclerView = root.findViewById(R.id.recycleView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
    }
}
