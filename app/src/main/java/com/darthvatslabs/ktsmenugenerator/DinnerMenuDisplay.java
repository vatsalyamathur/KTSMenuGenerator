package com.darthvatslabs.ktsmenugenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DinnerMenuDisplay extends AppCompatActivity {

    // Layout Objects
    private RelativeLayout m_dinnerDisplayLayout;
    private TextView m_headlineText;

    // class variables
    private String m_pulseDish;
    private String m_paneerDish;
    private String m_vegDish;

    private int m_paneerMealPrice;
    private int m_vegMealPrice;

    private Date m_currentDateTimeString;
    private SimpleDateFormat m_currentDayString;
    private String m_dayOfTheWeek;

    Intent m_dinnerDisplayIntent;

    private void m_initWidgets()
    {
        //init Layout
        m_dinnerDisplayLayout = new RelativeLayout(this);

        m_headlineText = new TextView(this);

        // get EditText data from Intent
        Bundle dinnerDisplayBundle = getIntent().getExtras();

        m_currentDayString = new SimpleDateFormat("EEEE");

        m_dinnerDisplayLayout.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        m_pulseDish = dinnerDisplayBundle.getString("pulseDish");
        m_paneerDish = dinnerDisplayBundle.getString("paneerDish");
        m_vegDish = dinnerDisplayBundle.getString("vegDish");

        m_paneerMealPrice = dinnerDisplayBundle.getInt("paneerMealPrice", 0);
        m_vegMealPrice = dinnerDisplayBundle.getInt("vegMealPrice", 0);


        m_currentDateTimeString = new Date();
        m_dayOfTheWeek = m_currentDayString.format(m_currentDateTimeString);

        Resources res = getResources();
        m_headlineText.setText(res.getString(R.string.dinnerMenuHeadline, m_dayOfTheWeek) + '\n' + res.getString(R.string.dinnerMenuLine, m_pulseDish, m_paneerDish, m_paneerMealPrice)
                + '\n' + res.getString(R.string.dinnerMenuLine, m_pulseDish,m_vegDish, m_vegMealPrice) + '\n' + res.getString(R.string.dinnerMenuEnd));

        m_dinnerDisplayLayout.addView(m_headlineText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_initWidgets();
        setContentView(m_dinnerDisplayLayout);
    }
}
