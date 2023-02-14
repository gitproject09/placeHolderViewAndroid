package com.sopan.placehold;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.sopan.placeholderview.ExpandablePlaceHolderView;
import com.sopan.placehold.R;
import com.sopan.placehold.expandable.ChildItem;
import com.sopan.placehold.expandable.ParentItem;


public class ExpandableActivity extends AppCompatActivity {

    ParentItem parentItem;
    @BindView(R.id.toolbar)
    public Toolbar mToolbar;
    @BindView(R.id.expandableView)
    public ExpandablePlaceHolderView mExpandableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        parentItem = new ParentItem(this.getApplicationContext());

        mExpandableView
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(parentItem)
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ParentItem(this.getApplicationContext()))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView))
                .addView(new ChildItem(mExpandableView));
    }

//    @OnClick(R.id.collapse)
//    void onCollapse() {
//        try {
//            mExpandableView.collapse(0);
//        }catch (Resources.NotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    @OnClick(R.id.expand)
//    void onExpand() {
//        try {
//            mExpandableView.expand(0);
//        }catch (Resources.NotFoundException e){
//            e.printStackTrace();
//        }
//    }

    @OnClick(R.id.collapse)
    void onCollapse() {
        try {
            mExpandableView.collapse(parentItem);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.expand)
    void onExpand() {
        try {
            mExpandableView.expand(parentItem);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }
}
