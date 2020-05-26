package com.example.mvvmnews.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmnews.R;
import com.example.mvvmnews.bean.NewBean;
import com.example.mvvmnews.databinding.ItemNewsBinding;

import java.util.List;

/**
 * @author huanglinqing
 * @project MvvmNews
 * @date 2020/5/26
 * @desc
 */
public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<NewBean.ResultBean.DataBean> dataBeans;

    private Context mContext;

    public NewsAdapter(List<NewBean.ResultBean.DataBean> dataBeans, Context mContext) {
        this.dataBeans = dataBeans;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_news, parent, false);
        ViewHolderItemNews viewHolderItemNews = new ViewHolderItemNews(itemNewsBinding);
        return viewHolderItemNews;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemNewsBinding itemNewsBinding = ((ViewHolderItemNews) holder).getViewDataBinding();
        itemNewsBinding.setNews(dataBeans.get(position));
        itemNewsBinding.setItemClick(new ClickBinding());
        itemNewsBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }


    private class ViewHolderItemNews extends RecyclerView.ViewHolder {

        private ItemNewsBinding viewDataBinding;

        public ItemNewsBinding getViewDataBinding() {
            return viewDataBinding;
        }

        public void setViewDataBinding(ItemNewsBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }

        public ViewHolderItemNews(ItemNewsBinding inflate) {
            super(inflate.getRoot());
            this.viewDataBinding = inflate;
        }
    }
}
