package com.csci3130.jbstks.password_validator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Joanna Bistekos (B00710704)
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Function to be called when the VALIDATE button is pressed by the user;
     * Updates textView with the text inputted by the user in the text field
     *
     * @param view the view object that was clicked
     */
    public void validate(View view) {
        Validator validator = new Validator();
        EditText pwField = findViewById(R.id.pwField);
        String pw = pwField.getText().toString();

        TextView textView = findViewById(R.id.output);
        if (validator.validate(pw) == 5) textView.setText("Strong password!");
        else textView.setText("Not strong enough!");
        textView.setVisibility(View.VISIBLE);
    }
}
