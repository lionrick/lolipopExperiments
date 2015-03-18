package com.example.ricardosantos.lolipopexperiments;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ricardosantos.lolipopexperiments.model.Product;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;
import java.util.List;


public class CardListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SwipyRefreshLayout mSwipyrefreshlayout;


    public static CardListFragment newInstance() {
        CardListFragment fragment = new CardListFragment();

        return fragment;
    }

    public CardListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);

        mSwipyrefreshlayout = (SwipyRefreshLayout) view.findViewById(R.id.swipyrefreshlayout);

        mSwipyrefreshlayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection swipyRefreshLayoutDirection) {
                Toast.makeText(getActivity(), "Updated", Toast.LENGTH_SHORT);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Hide the refresh after 2sec
                        CardListFragment.this.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mSwipyrefreshlayout.setRefreshing(false);
                            }
                        });
                    }
                }, 2000);

            }
        });


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Product> listFoo = createList();


        mAdapter = new CardListAdapter(listFoo);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    private List<Product> createList() {
        List<Product> list = new ArrayList<>();

        for(int i = 0; i<10;i++){
            Product p = new Product();
            p.setTitle("Product "+(i+1));
            p.setDescription("Description " + (i + 1));

            list.add(p);
        }

        return list;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
