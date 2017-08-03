package com.darthvatslabs.ktsmenugenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BreakfastMenuInput extends AppCompatActivity {
    //Layout Objects
    private RelativeLayout m_breakfastInputLayout;
    private TextView m_headlineText;
    private EditText m_breakfastDishInput;
    private EditText m_breakfastPriceInput;
    private Button m_submitButton;

    private RelativeLayout.LayoutParams textV_Param;
    private RelativeLayout.LayoutParams m_breakfastDish_Param;
    private RelativeLayout.LayoutParams m_breakfastPrice_Param;
    private RelativeLayout.LayoutParams m_submitButton_Param;

    //class functions
    private void m_initWidgets()
    {
        // init Layout
        m_breakfastInputLayout = new RelativeLayout(this);
        m_breakfastInputLayout.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        // init TextView
        m_headlineText = new TextView(this);
        m_headlineText.setId(R.id.headlineText); //Check importance of setting id value

        Resources res = getResources();

        //set display and position Attributes for TextView
        m_headlineText.setText(res.getString(R.string.headlineInput,res.getString(R.string.breakfast)));
        m_headlineText.setTextColor(Color.BLUE);

        textV_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textV_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textV_Param.setMargins(30,30,30,0);
        m_headlineText.setLayoutParams(textV_Param);

        // init Edit Text Box
        m_breakfastDishInput = new EditText(this);
        m_breakfastDishInput.setId(R.id.breakfastEditText);

        //set display and position Attributes for EditText Box
        m_breakfastDishInput.setHint(res.getString(R.string.breakfastEditText, res.getString(R.string.breakfast)));
        //m_dinnerMealButton.setAllCaps(false);
        m_breakfastDish_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_breakfastDish_Param.addRule(RelativeLayout.BELOW, m_headlineText.getId());
        m_breakfastDish_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_breakfastDish_Param.setMargins(30,30,30,0);
        m_breakfastDishInput.setLayoutParams(m_breakfastDish_Param);

        // init Edit Text Box
        m_breakfastPriceInput = new EditText(this);
        m_breakfastPriceInput.setId(R.id.breakfastPriceInput);

        //set display and position Attributes for EditText Box
        m_breakfastPriceInput.setHint(res.getString(R.string.breakfastPriceInput,res.getString(R.string.breakfast)));
        //m_dinnerMealButton.setAllCaps(false);
        m_breakfastPrice_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_breakfastPrice_Param.addRule(RelativeLayout.BELOW, m_breakfastDishInput.getId());
        m_breakfastPrice_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_breakfastPrice_Param.setMargins(30,30,30,0);
        m_breakfastPriceInput.setLayoutParams(m_breakfastPrice_Param);

        // init Submit Button
        m_submitButton = new Button(this);
        m_submitButton.setId(R.id.submitButton);

        //set display and position for Button
        m_submitButton.setText(R.string.submitButton);
        m_submitButton_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_submitButton_Param.addRule(RelativeLayout.BELOW, m_breakfastPriceInput.getId());

        m_submitButton_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_submitButton_Param.setMargins(50,50,50,0);
        m_submitButton.setLayoutParams(m_submitButton_Param);

        // override onclick listener for button
        m_submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent breakfastInputIntent = new Intent(getApplicationContext(), BreakfastMenuDisplay.class);
                Bundle breakfastInputBundle = new Bundle();
                breakfastInputBundle.putString("breakfastMenu", m_breakfastDishInput.getText().toString());
                breakfastInputBundle.putInt("breakfastPrice", Integer.parseInt(m_breakfastPriceInput.getText().toString()));
                breakfastInputIntent.putExtras(breakfastInputBundle);
                startActivity(breakfastInputIntent);
            }
        });
        // add widget to Layout
        m_breakfastInputLayout.addView(m_headlineText, textV_Param);
        m_breakfastInputLayout.addView(m_breakfastDishInput, m_breakfastDish_Param);
        m_breakfastInputLayout.addView(m_breakfastPriceInput, m_breakfastPrice_Param);
        m_breakfastInputLayout.addView(m_submitButton, m_submitButton_Param);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.m_initWidgets();
        setContentView(m_breakfastInputLayout);
    }
}
