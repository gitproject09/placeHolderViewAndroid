package com.sopan.placehold;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.sopan.placeholderview.ExpandablePlaceHolderView;
import com.sopan.placehold.feed.HeadingView;
import com.sopan.placehold.feed.InfoView;
import com.sopan.placehold.feed.data.Feed;
import com.sopan.placehold.feed.data.Info;


public class FeedTestActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.expandableView)
    public ExpandablePlaceHolderView mExpandableView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_test);
        ButterKnife.bind(this);

        mContext = this.getApplicationContext();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        for(Feed feed : Utils.loadFeeds(this.getApplicationContext())){
            mExpandableView.addView(new HeadingView(mContext, feed.getHeading()));
            for(Info info : feed.getInfoList()){
                mExpandableView.addView(new InfoView(mContext, info));
            }
        }
    }
}
