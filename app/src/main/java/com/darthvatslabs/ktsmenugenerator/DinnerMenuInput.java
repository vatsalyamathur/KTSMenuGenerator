package com.darthvatslabs.ktsmenugenerator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DinnerMenuInput extends AppCompatActivity {

    //Layout Objects
    private RelativeLayout m_dinnerInputLayout;
    private TextView m_headlineText;
    private EditText m_pulseDishInput;
    private EditText m_paneerDishInput;
    private EditText m_vegDishInput;
    private EditText m_paneerMealPriceInput;
    private EditText m_vegMealPriceInput;
    private Button m_submitButton;

    private RelativeLayout.LayoutParams textV_Param;
    private RelativeLayout.LayoutParams m_pulseDish_Param;
    private RelativeLayout.LayoutParams m_paneerDish_Param;
    private RelativeLayout.LayoutParams m_vegDish_Param;
    private RelativeLayout.LayoutParams m_paneerMealPrice_Param;
    private RelativeLayout.LayoutParams m_vegMealPrice_Param;
    private RelativeLayout.LayoutParams m_submitButton_Param;

    //class functions
    private void m_initWidgets()
    {
        // init Layout
        m_dinnerInputLayout = new RelativeLayout(this);
        m_dinnerInputLayout.setLayoutParams(
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));

        // init TextView
        m_headlineText = new TextView(this);
        m_headlineText.setId(R.id.headlineText); //Check importance of setting id value

        //set display and position Attributes for TextView
        m_headlineText.setText(R.string.headlineInput);
        m_headlineText.setTextColor(Color.BLUE);

        textV_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textV_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textV_Param.setMargins(30,30,30,0);
        m_headlineText.setLayoutParams(textV_Param);

        // init Edit Text Box
        m_pulseDishInput = new EditText(this);
        m_pulseDishInput.setId(R.id.pulseEditText);

        //set display and position Attributes for EditText Box
        m_pulseDishInput.setHint(R.string.pulseEditText);
        //m_dinnerMealButton.setAllCaps(false);
        m_pulseDish_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_pulseDish_Param.addRule(RelativeLayout.BELOW, m_headlineText.getId());
        m_pulseDish_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_pulseDish_Param.setMargins(30,30,30,0);
        m_pulseDishInput.setLayoutParams(m_pulseDish_Param);

        // init Edit Text Box
        m_paneerDishInput = new EditText(this);
        m_paneerDishInput.setId(R.id.paneerEditText);

        //set display and position Attributes for EditText Box
        m_paneerDishInput.setHint(R.string.paneerEditText);
        m_paneerDish_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_paneerDish_Param.addRule(RelativeLayout.BELOW, m_pulseDishInput.getId());
        m_paneerDish_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_paneerDish_Param.setMargins(30,30,30,0);
        m_paneerDishInput.setLayoutParams(m_paneerDish_Param);

        // init Edit Text Box
        m_paneerMealPriceInput = new EditText(this);
        m_paneerMealPriceInput.setId(R.id.paneerMealPriceEditText);

        //set display and position Attributes for EditText Box
        m_paneerMealPriceInput.setHint(R.string.paneerMealPriceEditText);
        m_paneerMealPriceInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        m_paneerMealPrice_Param= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_paneerMealPrice_Param.addRule(RelativeLayout.BELOW, m_paneerDishInput.getId());
        m_paneerMealPrice_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_paneerMealPrice_Param.setMargins(30,30,30,0);
        //m_paneerMealPriceInput.setLayoutParams(m_paneerDish_Param);

        // init Edit Text Box
        m_vegDishInput = new EditText(this);
        m_vegDishInput.setId(R.id.vegEditText);

        //set display and position Attributes for EditText Box
        m_vegDishInput.setHint(R.string.vegEditText);
        m_vegDish_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_vegDish_Param.addRule(RelativeLayout.BELOW, m_paneerMealPriceInput.getId());
        m_vegDish_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_vegDish_Param.setMargins(30,30,30,0);
        //m_vegDishInput.setLayoutParams(m_vegDish_Param);

        // init Edit Text Box
        m_vegMealPriceInput = new EditText(this);
        m_vegMealPriceInput.setId(R.id.vegMealPriceEditText);

        //set display and position Attributes for EditText Box
        m_vegMealPriceInput.setHint(R.string.vegMealPriceEditText);
        m_vegMealPriceInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        m_vegMealPrice_Param= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_vegMealPrice_Param.addRule(RelativeLayout.BELOW, m_vegDishInput.getId());
        m_vegMealPrice_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_vegMealPrice_Param.setMargins(30,30,30,0);
        m_vegMealPriceInput.setLayoutParams(m_paneerDish_Param);

        // init Submit Button
        m_submitButton = new Button(this);
        m_submitButton.setId(R.id.submitButton);

        //set display and position for Button
        m_submitButton.setHint(R.string.submitButton);
        m_submitButton_Param = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        m_submitButton_Param.addRule(RelativeLayout.BELOW, m_vegMealPriceInput.getId());
        m_submitButton_Param.addRule(RelativeLayout.CENTER_HORIZONTAL);
        m_submitButton_Param.setMargins(50,50,50,0);
        m_submitButton.setLayoutParams(m_submitButton_Param);

        // override onclick listener for button
        m_submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dinnerInputIntent = new Intent(getApplicationContext(), DinnerMenuDisplay.class);
                dinnerInputIntent.putExtra("pulseDish", m_pulseDishInput.getText().toString());
                dinnerInputIntent.putExtra("paneerDish", m_paneerDishInput.getText().toString());
                dinnerInputIntent.putExtra("vegDish", m_vegDishInput.getText().toString());
                dinnerInputIntent.putExtra("paneerMealPrice", m_paneerMealPriceInput.getText().toString());
                dinnerInputIntent.putExtra("vegMealPrice", m_vegMealPriceInput.getText().toString());
                startActivity(dinnerInputIntent);
            }
        });
        // add widget to Layout
        m_dinnerInputLayout.addView(m_headlineText, textV_Param);
        m_dinnerInputLayout.addView(m_pulseDishInput, m_pulseDish_Param);
        m_dinnerInputLayout.addView(m_paneerDishInput, m_paneerDish_Param);
        m_dinnerInputLayout.addView(m_vegDishInput, m_vegDish_Param);
        m_dinnerInputLayout.addView(m_paneerMealPriceInput, m_paneerMealPrice_Param);
        m_dinnerInputLayout.addView(m_vegMealPriceInput, m_vegMealPrice_Param);
        m_dinnerInputLayout.addView(m_submitButton, m_submitButton_Param);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.m_initWidgets();
        setContentView(m_dinnerInputLayout);

    }
}