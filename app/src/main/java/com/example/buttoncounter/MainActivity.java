package com.example.buttoncounter;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput; //EditText : class, object, it is widget,so EditText!= editText
    // EditText, saying this is type of info.

    private TextView textView;
    private int numButtonClicked=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(""); //Delete "TextView" text, which was set by default.
        textView.setMovementMethod(new ScrollingMovementMethod()); // adding vertical scroll bar
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               numButtonClicked++;
               String result = "The button got tapped " + numButtonClicked + " time";
               if(numButtonClicked !=1) {
                    result+="s";
               }
                result +="\n";
                textView.append(result);
            }
        };
        button.setOnClickListener(ourOnClickListener);
    }
}