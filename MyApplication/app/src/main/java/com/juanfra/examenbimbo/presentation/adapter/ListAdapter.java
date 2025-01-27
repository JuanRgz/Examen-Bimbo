package com.juanfra.examenbimbo.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.juanfra.examenbimbo.R;
import com.juanfra.examenbimbo.databinding.ListItemBinding;
import com.juanfra.examenbimbo.domain.model.GameModel;
import com.juanfra.examenbimbo.presentation.utils.OnClickList;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<GameModel> items = new ArrayList<>();
    private OnClickList onClickList;

    public ListAdapter(OnClickList onClickList) {
        this.onClickList = onClickList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding view = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false
        );
        return new ViewHolder(view);
    }

    public void addData(List<GameModel> list) {
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }

    private GameModel getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListItemBinding listItem;

        public ViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            listItem = (ListItemBinding) dataBinding;
        }

        public void onBind(GameModel item) {
            listItem.tvName.setText(item.getShortDescription());
            Glide.with(listItem.ivLogo).load(item.getThumbnail()).into(listItem.ivLogo);
            itemView.setOnClickListener(v -> onClickList.goToView(item.getId(), v));
        }

    }
}
