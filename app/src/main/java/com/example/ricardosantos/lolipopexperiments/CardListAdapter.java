package com.example.ricardosantos.lolipopexperiments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ricardosantos.lolipopexperiments.model.Product;

import java.util.List;

/**
 * Created by ricardo.santos on 18/03/2015.
 */
public class CardListAdapter  extends RecyclerView.Adapter<CardListAdapter.ViewHolder>{


    public CardListAdapter(List<Product> listData) {
        this.listData = listData;
    }

    private List<Product> listData;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        // set the view's size, margins, paddings and layout parameters if necessary

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Product p = listData.get(position);
        holder.mTextTitle.setText(p.getTitle());
        holder.mTextDescription.setText(p.getDescription());
    }

    @Override
    public int getItemCount() {
        if(listData!=null){
            return listData.size();
        }else{
            return 0;
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView mTextTitle;
        public TextView mTextDescription;

        public ViewHolder(View v) {
            super(v);
            mTextTitle = (TextView) v.findViewById(R.id.title);
            mTextDescription = (TextView) v.findViewById(R.id.description);
        }
    }

}
