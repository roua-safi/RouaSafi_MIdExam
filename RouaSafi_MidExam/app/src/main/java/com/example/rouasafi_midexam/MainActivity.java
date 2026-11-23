package com.example.rouasafi_midexam;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rouasafi_midexam.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static ActivityMainBinding binding ;





    private static final String KEY_CURRENT_INDEX = "current_index";

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_ARTIST = "extra_artist";
    public static final String EXTRA_YEAR = "extra_year";

    private int currentIndex = 0;


    private final int[] imageResIds = {
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6
    };

    private final String[] titles = {
            "Mauve Horizon",
            "Amber Solitude",
            "Rose Reverie",
            "Starlight Tea",
            "Night Express",
            "Pure Canvas"
    };

    private final String[] artists = {
            "Clara Vance",
            "Mateo Silva",
            "Hana Sato",
            "Liam O'Connor",
            "Nadia Haddad",
            "Julian Weber"
    };

    private final String[] years = {
            "2021",
            "2019",
            "2023",
            "2020",
            "2018",
            "2024"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX, 0);
        }

        updateArtworkDisplay();

        binding.prevbtn.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateArtworkDisplay();
            }
        });

        binding.nextbtn.setOnClickListener(v -> {
            if (currentIndex < imageResIds.length - 1) {
                currentIndex++;
                updateArtworkDisplay();
            }

        });
        binding.artimg.setOnClickListener(v -> {
            Intent in = new Intent(this, ArtworkDetailsActivity.class);
            in.putExtra(EXTRA_TITLE, titles[currentIndex]);
            in.putExtra(EXTRA_ARTIST, artists[currentIndex]);
            in.putExtra(EXTRA_YEAR, years[currentIndex]);
            startActivity(in);
        });





    }

    private void updateArtworkDisplay() {

        int total = imageResIds.length;


        binding.counter.setText((currentIndex + 1) + " / " + total);


        binding.artimg.setImageResource(imageResIds[currentIndex]);
        binding.artTitle.setText(titles[currentIndex]);
        binding.artArtist.setText(artists[currentIndex] + " (" + years[currentIndex] + ")");



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_INDEX, currentIndex);
    }
}