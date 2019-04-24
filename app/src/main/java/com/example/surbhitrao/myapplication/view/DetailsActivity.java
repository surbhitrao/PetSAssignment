package com.example.surbhitrao.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.surbhitrao.myapplication.R;
import com.squareup.picasso.Picasso;


public class DetailsActivity extends AppCompatActivity {
    private TextView titleTextView;
    private ImageView imageView;
    private TextView OverviewText;
    private TextView UserRating;
    private TextView ReleaseDate;

    Toolbar tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);


        String title = getIntent().getStringExtra("title");
        actionBar.setTitle(title);
        String image = getIntent().getStringExtra("backd");
        Log.i("hghg",image);
        String overview = getIntent().getStringExtra("overview");
        String votes = getIntent().getStringExtra("votes");
        String r_dates = getIntent().getStringExtra("r_dates");
        titleTextView = (TextView) findViewById(R.id.title);
        OverviewText = (TextView) findViewById(R.id.overview);
        UserRating=(TextView) findViewById(R.id.votes);
        ReleaseDate=(TextView) findViewById(R.id.dates);
        imageView = (ImageView) findViewById(R.id.grid_item_image);
        titleTextView.setText(Html.fromHtml(title));
        OverviewText.setText(Html.fromHtml(overview));
        UserRating.setText(Html.fromHtml(votes));
        ReleaseDate.setText(Html.fromHtml(r_dates));

        Picasso.with(this).load(image).into(imageView);
    }




}
