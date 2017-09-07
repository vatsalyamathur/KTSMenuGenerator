package com.darthvatslabs.ktsmenugenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.darthvatslabs.util.utility;

public class BreakfastMenuDisplay extends AppCompatActivity {

    //Layout Objects
    private RelativeLayout m_breakfastMenuDisplayLayout;
    private TextView m_menuDisplayText;
    private Button m_copyClipboardButton;

    private RelativeLayout.LayoutParams m_menuDisplayText_Param;
    private RelativeLayout.LayoutParams m_clipboardButton_Param;

    private String m_breakfastMenuDish;
    private int m_breakfastPrice;

    private utility utilObj;

    private void m_initWidgets()
    {
        m_breakfastMenuDisplayLayout = new RelativeLayout(this);

        m_menuDisplayText = new TextView(this);
        m_menuDisplayText.setId(R.id.menuDisplay);

        m_menuDisplayText_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        m_copyClipboardButton = new Button(this);
        m_copyClipboardButton.setId(R.id.copyClipboard);

        m_clipboardButton_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        utilObj = new utility();
    }

    private void m_styleWidgets()
    {
        m_breakfastMenuDisplayLayout.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

        String currentDayOfWeek = utilObj.getCurrentDay();

        Resources res = getResources();

        m_menuDisplayText.setText(res.getString(R.string.menuHeadline, currentDayOfWeek, res.getString(R.string.breakfast)) + '\n'
                + res.getString(R.string.breakfastMenuLine, m_breakfastMenuDish, m_breakfastPrice) + '\n'
                + res.getString(R.string.breakfastMenuEnd) + '\n' + res.getString(R.string.signature));

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
                Toast.makeText(getApplicationContext(), "Menu Copied to Clipboard", Toast.LENGTH_LONG).show();
            }
        });

        m_breakfastMenuDisplayLayout.addView(m_menuDisplayText, m_menuDisplayText_Param);
        m_breakfastMenuDisplayLayout.addView(m_copyClipboardButton, m_clipboardButton_Param);
    }

    private void m_getBundleData()
    {
        Bundle breakfastInputBundle = getIntent().getExtras();
        m_breakfastMenuDish = breakfastInputBundle.getString("breakfastMenu");
        m_breakfastPrice = breakfastInputBundle.getInt("breakfastPrice", 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_initWidgets();
        m_getBundleData();
        m_styleWidgets();
        setContentView(m_breakfastMenuDisplayLayout);
    }
}