package com.darthvatslabs.ktsmenugenerator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Vatsalya on 22-Jul-17.
 */

public class MenuGeneratorActivity extends AppCompatActivity {

    //Layout Objects
    private RelativeLayout m_mealSelectionLayout;
    private TextView m_headlineText;
    private Button m_dinnerMealButton;
    private Button m_breakfastMealButton;
    private RelativeLayout.LayoutParams textV_Param;
    private RelativeLayout.LayoutParams m_dinnerButton_Param;
    private RelativeLayout.LayoutParams m_breakfastButton_Param;

    //class functions
    private void m_initWidgets()
    {
        // init Layout
        m_mealSelectionLayout = new RelativeLayout(this);
        m_mealSelectionLayout.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        // init TextView
        m_headlineText = new TextView(this);
        m_headlineText.setId(R.id.headlineText); //Check importance of setting id value

        //set display and position Attributes for TextView
        m_headlineText.setText(R.string.headline);
        m_headlineText.setTextColor(Color.BLUE);

        textV_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        // textV_Param.addRule(RelativeLayout.ABOVE, m_dinnerMealButton.getId()); // reference to uninitialized object
        textV_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textV_Param.setMargins(30,30,30,0);
        m_headlineText.setLayoutParams(textV_Param);

        // init Buttons
        m_dinnerMealButton = new Button(this);
        m_dinnerMealButton.setId(R.id.dinnerMealButton);

        //set display and position Attributes for Button
        m_dinnerMealButton.setText(R.string.dinnerButton);
        m_dinnerMealButton.setAllCaps(false);
        m_dinnerButton_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_dinnerButton_Param.addRule(RelativeLayout.BELOW, m_headlineText.getId());
        m_dinnerButton_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_dinnerButton_Param.setMargins(30,30,30,0);
        m_dinnerMealButton.setLayoutParams(m_dinnerButton_Param);

        //add on click function call for Button
        m_dinnerMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dinnerMealIntent= new Intent(getApplicationContext(), DinnerMenuInput.class);
                startActivity(dinnerMealIntent);
            }
        });

        m_breakfastMealButton = new Button(this);
        m_breakfastMealButton.setId(R.id.breakfastMealButton);

        //set display and position Attributes for Button
        m_breakfastMealButton.setText(R.string.breakfastButton);
        m_breakfastMealButton.setAllCaps(false);
        m_breakfastButton_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_breakfastButton_Param.addRule(RelativeLayout.BELOW, m_dinnerMealButton.getId());
        m_breakfastButton_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_breakfastButton_Param.setMargins(30,30,30,0);
        m_breakfastMealButton.setLayoutParams(m_breakfastButton_Param);

        //add on click function call for Button
        m_breakfastMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent breakfastMealIntent = new Intent(getApplicationContext(), BreakfastMenuInput.class);
                startActivity(breakfastMealIntent);
            }
        });

        // add widget to Layout
        m_mealSelectionLayout.addView(m_headlineText, textV_Param);
        m_mealSelectionLayout.addView(m_dinnerMealButton);
        m_mealSelectionLayout.addView(m_breakfastMealButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.m_initWidgets();
        setContentView(m_mealSelectionLayout);
    }

}
