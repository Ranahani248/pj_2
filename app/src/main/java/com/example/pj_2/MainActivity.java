package com.example.pj_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    private MeowBottomNavigation bottomNavigation;
    private static final int home = 1; // Changed 'final static' to 'static final'
    private static final int profile = 2; // Changed 'final static' to 'static final'
    private static final int favorite = 3; // Changed 'final static' to 'static final'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_nav);
        bottomNavigation.show(home, true);
        bottomNavigation.add(new MeowBottomNavigation.Model(home, R.drawable.baseline_add_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(profile, R.drawable.baseline_person_2_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(favorite, R.drawable.baseline_favorite_border_24));
        LoadAndReplaceFragment(new HomeFragment());


        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Fragment fragment = null;
                if (model.getId() == home) {
                    fragment = new HomeFragment();
                } else if (model.getId() == profile) {
                    fragment = new ProfileFragment();
                } else fragment = new FavouriteFragment();
                LoadAndReplaceFragment(fragment);
                return null;
            }
        });

    }



        private void LoadAndReplaceFragment(Fragment fragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
}
