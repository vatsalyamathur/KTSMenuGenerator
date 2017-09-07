package com.darthvatslabs.ktsmenugenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.darthvatslabs.util.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DinnerMenuDisplay extends AppCompatActivity {

    // Layout Objects
    private RelativeLayout m_dinnerDisplayLayout;
    private TextView m_menuDisplayText;
    private Button m_copyClipboardButton;

    private RelativeLayout.LayoutParams m_menuDisplayText_Param;
    private RelativeLayout.LayoutParams m_clipboardButton_Param;

    // class variables
    private String m_pulseDish;
    private String m_paneerDish;
    private String m_vegDish;

    private int m_paneerMealPrice;
    private int m_vegMealPrice;

    private utility utilObj;

    private void m_initWidgets()
    {
        //init Layout
        m_dinnerDisplayLayout = new RelativeLayout(this);
        m_dinnerDisplayLayout.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        m_menuDisplayText = new TextView(this);
        m_menuDisplayText.setId(R.id.menuDisplay);

        m_copyClipboardButton = new Button(this);
        m_copyClipboardButton.setId(R.id.copyClipboard);

        m_menuDisplayText_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_clipboardButton_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        utilObj = new utility();
    }

    private void m_styleWidgets()
    {
        String currentDayOfWeek = utilObj.getCurrentDay();

        Resources res = getResources();
        m_menuDisplayText.setText(res.getString(R.string.menuHeadline, currentDayOfWeek, res.getString(R.string.dinner)) + '\n'
                + res.getString(R.string.dinnerMenuLine, m_pulseDish, m_paneerDish, m_paneerMealPrice)
                + '\n' + res.getString(R.string.dinnerMenuLine, m_pulseDish,m_vegDish, m_vegMealPrice) + '\n' + res.getString(R.string.dinnerMenuEnd)
                + "\n\n" + res.getString(R.string.signature));

        m_menuDisplayText.setTextColor(Color.BLUE);

        m_copyClipboardButton.setText("Copy Menu");
        m_clipboardButton_Param.addRule(RelativeLayout.BELOW, m_menuDisplayText.getId());
        m_clipboardButton_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_clipboardButton_Param.setMargins(50,50,50,50);

        m_copyClipboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String breakfastMenu = m_menuDisplayText.getText().toString();

                // using ClipboardManager and ClipData classes to implement Copy to Clipboard Functionality
                ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                ClipData clipboardData;
                clipboardData = ClipData.newPlainText("breakfastMenu", breakfastMenu);
                clipboardManager.setPrimaryClip(clipboardData);

                // making Application Toast [simple feedback about an operation in a small popup]
                int i1 = (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + 1);

                Toast.makeText(getApplicationContext(), "Menu Copied to Clipboard", Toast.LENGTH_LONG).show();
            }
        });

        m_dinnerDisplayLayout.addView(m_menuDisplayText, m_menuDisplayText_Param);
        m_dinnerDisplayLayout.addView(m_copyClipboardButton, m_clipboardButton_Param);
    }

    private void m_getBundleData()
    {
        // get EditText data from Intent
        Bundle dinnerDisplayBundle = getIntent().getExtras();

        m_pulseDish = dinnerDisplayBundle.getString("pulseDish");
        m_paneerDish = dinnerDisplayBundle.getString("paneerDish");
        m_vegDish = dinnerDisplayBundle.getString("vegDish");

        m_paneerMealPrice = dinnerDisplayBundle.getInt("paneerMealPrice", 0);
        m_vegMealPrice = dinnerDisplayBundle.getInt("vegMealPrice", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_initWidgets();
        m_getBundleData();
        m_styleWidgets();
        setContentView(m_dinnerDisplayLayout);
    }
}