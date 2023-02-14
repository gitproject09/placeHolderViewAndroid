package com.sopan.placehold;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;


import com.sopan.placeholderview.InfinitePlaceHolderView;
import com.sopan.placehold.gallery.ImageTypeBig;
import com.sopan.placehold.infinite.LoadMoreView;

import java.util.List;


public class LoadMoreActivity extends AppCompatActivity {

    @BindView(R.id.loadMoreView)
    public InfinitePlaceHolderView mLoadMoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more_test);
        ButterKnife.bind(this);
        setupView();
    }

    private void setupView(){

        List<Image> imageList = Utils.loadImages(this.getApplicationContext());
        for (int i = 0; i <  LoadMoreView.LOAD_VIEW_SET_COUNT && imageList.size() > i; i++) {
            mLoadMoreView.addView(new ImageTypeBig(this.getApplicationContext(), mLoadMoreView, imageList.get(i).getUrl()));
        }
//        mLoadMoreView.setLoadMoreResolver(new LoadMoreView(mLoadMoreView, imageList));
    }
}
