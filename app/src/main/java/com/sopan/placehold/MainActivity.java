package com.sopan.placehold;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.View;


import com.sopan.placeholderview.PlaceHolderView;
import com.sopan.placehold.drawer.DrawerHeader;
import com.sopan.placehold.drawer.DrawerMenuItem;
import com.sopan.placehold.gallery.ImageTypeBig;
import com.sopan.placehold.gallery.ImageTypeSmallPlaceHolder;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawerView)
    public PlaceHolderView mDrawerView;

    @BindView(R.id.drawerLayout)
    public DrawerLayout mDrawer;

    @BindView(R.id.toolbar)
    public Toolbar mToolbar;

    @BindView(R.id.galleryView)
    public PlaceHolderView mGalleryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupDrawer();
        setupGallery();
    }

    private void setupDrawer(){
        mDrawerView
                .addView(new DrawerHeader())
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()))
                .addView(new DrawerMenuItem(this.getApplicationContext()));

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void setupGallery(){

//        mGalleryView.getBuilder()
//                .setHasFixedSize(false)
//                .setItemViewCacheSize(10)
//                .setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//                .setLayoutManager(new GridLayoutManager(this, 3));
//        for (Image image : imageList){
//            mGalleryView.addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, image.getUrl()));
//        }

        List<Image> imageList = Utils.loadImages(this.getApplicationContext());
        List<Image> newImageList = new ArrayList<>();
        for (int i = 0; i <  (imageList.size() > 10 ? 10 : imageList.size()); i++) {
            newImageList.add(imageList.get(i));
        }
        mGalleryView.addView(new ImageTypeSmallPlaceHolder(this.getApplicationContext(), newImageList));

        for (int i = imageList.size() - 1; i >= 0; i--) {
            mGalleryView.addView(new ImageTypeBig(this.getApplicationContext(), mGalleryView, imageList.get(i).getUrl()));
        }
    }
}
