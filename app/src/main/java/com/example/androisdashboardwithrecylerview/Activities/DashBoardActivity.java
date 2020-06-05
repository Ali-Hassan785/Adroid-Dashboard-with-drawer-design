package com.example.androisdashboardwithrecylerview.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.androisdashboardwithrecylerview.Adapter.DashboarAdapter;
import com.example.androisdashboardwithrecylerview.Models.DashBoardModel;
import com.example.androisdashboardwithrecylerview.R;
import com.example.androisdashboardwithrecylerview.Tools.Tools;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private  NavigationView navigationView;
    protected Context context;
    List<DashBoardModel> dashboardata = new ArrayList<>();
    public Toolbar toolbar;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        navigationView = findViewById(R.id.nv);
        recyclerView = findViewById(R.id.recycler_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.homedl);
        getData();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
//        facebookAdsUtils = new FacebookAdsUtils(this);
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
        recyclerView.hasFixedSize();
//recyclerView.setAdapter();
        recyclerView.setAdapter(new DashboarAdapter(this, dashboardata));
        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        final int spacing = getResources().getDimensionPixelSize(R.dimen.recycler_spacing) / 2;

        recyclerView.setPadding(spacing, spacing, spacing, spacing);
        recyclerView.setClipToPadding(false);
        recyclerView.setClipChildren(false);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(spacing, spacing, spacing, spacing);
            }
        });
        recyclerView.setLayoutManager(glm);
    }

    private void getData() {
        dashboardata.add(new DashBoardModel("Home", R.drawable.ic_home_black_24dp, R.color.colorAccent));
        dashboardata.add(new DashBoardModel("Rating", R.drawable.ic_star_black_24dp, R.color.colorAccent));
        dashboardata.add(new DashBoardModel("Share", R.drawable.ic_share_black_24dp, R.color.colorAccent));
        dashboardata.add(new DashBoardModel("More App", R.drawable.ic_more_horiz_black_24dp, R.color.colorAccent));
        dashboardata.add(new DashBoardModel("Exit App", R.drawable.ic_exit_to_app_black_24dp, R.color.colorAccent));


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        drawerLayout.closeDrawers();
        switch (id) {
            case R.id.share:
                Tools.ShareApp(context);
//                Toast.makeText(HomeActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.privacypolicy:
                Tools.PrivacyPolicy(context);
                break;
            case R.id.moreapp:
                Tools.MoreApp(context);
                break;
            case R.id.rateus:
//                Toast.makeText(HomeActivity.this, "My Cart", Toast.LENGTH_SHORT).show();
                Tools.Rateus(context);
                break;
            default:
                return true;
        }
        return true;
    }
}
