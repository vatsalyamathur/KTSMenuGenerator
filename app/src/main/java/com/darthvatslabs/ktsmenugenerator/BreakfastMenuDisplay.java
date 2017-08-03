package com.darthvatslabs.ktsmenugenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.darthvatslabs.util.utility;

public class BreakfastMenuDisplay extends AppCompatActivity {

    //Layout Objects
    private RelativeLayout m_breakfastMenuDisplayLayout;
    private TextView m_menuDisplayText;

    private RelativeLayout.LayoutParams m_menuDisplayText_Param;

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

        utilObj = new utility();

    }

    private void m_getBundleData()
    {
        Bundle breakfastInputBundle = getIntent().getExtras();
        m_breakfastMenuDish = breakfastInputBundle.getString("breakfastMenu");
        m_breakfastPrice = breakfastInputBundle.getInt("breakfastPrice", 0);
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

        m_breakfastMenuDisplayLayout.addView(m_menuDisplayText, m_menuDisplayText_Param);
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
