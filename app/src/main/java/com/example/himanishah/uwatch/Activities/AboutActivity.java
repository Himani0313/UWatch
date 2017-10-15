package com.example.himanishah.uwatch.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.himanishah.uwatch.R;


public class AboutActivity extends AppCompatActivity {

    private TextView textGooglePlus, textAppName, textAbout1, textAbout2, textCoder, textGithub;
    private ImageView back;
    private Typeface typeface;
    private SpannableString ss, ss1;
    private ClickableSpan span, span1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(this != null){
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }

        typeface = Typeface.createFromAsset(getAssets(), "fonts/Geomanist_Regular.otf");

        textAppName = (TextView) findViewById(R.id.tvAppName);
        textGooglePlus = (TextView) findViewById(R.id.tvGooglePlus);
        textAbout1 = (TextView) findViewById(R.id.tvAbout1);
        textAbout2 = (TextView) findViewById(R.id.tvAbout2);
        textCoder = (TextView) findViewById(R.id.tvCoder1);
        textGithub = (TextView) findViewById(R.id.tvGithub);
        back = (ImageView) findViewById(R.id.ivBack);

        textAppName.setTypeface(typeface);
        textGooglePlus.setTypeface(typeface);
        textAbout1.setTypeface(typeface);
        textAbout2.setTypeface(typeface);
        textCoder.setTypeface(typeface);
        textGithub.setTypeface(typeface);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ss = new SpannableString(getResources().getString(R.string.description2));

        span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.themoviedb.org"));
                startActivity(intent);
            }
        };

        ss.setSpan(span, 25, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textAbout2.setText(ss);
        textAbout2.setMovementMethod(LinkMovementMethod.getInstance());


        ss1 = new SpannableString(getResources().getString(R.string.github));

        span1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/prithvibhola"));
                startActivity(intent);
            }
        };

        ss1.setSpan(span1, 32, 38, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textGithub.setText(ss1);
        textGithub.setMovementMethod(LinkMovementMethod.getInstance());

        String htmlString = "<u>" + getResources().getString(R.string.google) +"</u>";
        textGooglePlus.setText(Html.fromHtml(htmlString));
        textGooglePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://plus.google.com/u/1/111463277012289416232"));
                startActivity(intent);
            }
        });
    }
}

