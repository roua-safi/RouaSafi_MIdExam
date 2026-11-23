package com.example.rouasafi_midexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;






import com.example.rouasafi_midexam.databinding.ActivityArtworkDetailsBinding;


public class ArtworkDetailsActivity extends AppCompatActivity {
    private ActivityArtworkDetailsBinding binding ;

    private static final String ARTWORK_URL = "https://www.google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityArtworkDetailsBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String title = getIntent().getStringExtra(MainActivity.EXTRA_TITLE);
        String artist = getIntent().getStringExtra(MainActivity.EXTRA_ARTIST);
        String year = getIntent().getStringExtra(MainActivity.EXTRA_YEAR);

        String TitleText = "Title: " + (title != null ? title : "") ;
        String ArtistText = "Artist: " + (artist != null ? artist : "") ;
        String YearText = "Year: " + (year != null ? year : "") ;

        binding.artDetailTitle.setText(TitleText);
        binding.artArtist.setText(ArtistText);
        binding.artYear.setText(YearText);

        binding.btnBack.setOnClickListener(v -> finish());

        binding.btnVisitWebsite.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ARTWORK_URL));
            startActivity(browserIntent);
        });

    }


}