
package com.example.buttoncounter;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput; //EditText : class, object, it is widget,so EditText!= editText
    // EditText, saying this is type of info.

    private TextView textView;
    private static final String TAG = "MainActivity";
    private final String   TEXT_CONTENTS = "TextContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(""); //Delete "TextView" text, which was set by default.
        userInput.setText(""); // Clear the contents of the EditText when the app runs
        textView.setMovementMethod(new ScrollingMovementMethod()); // adding vertical scroll bar
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = userInput.getText().toString();
                //Solution 1.
                //String result = userInput.getText().toString();
                //userInput.getText() type is Editable
                //so use .toString to change type to String
                //Solution 2.
                //Editable e = userInput.getText();
                //String result = e.toString(); , solution 1 is more common.
                result = result + "\n";
                textView.append(result);
                userInput.setText(""); // Clear the contents of the EditText after a user click on button
            }
        };
        if (button != null) {
            button.setOnClickListener(ourOnClickListener);
        }
        Log.d(TAG, "onCreate: out");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
//        String savedString = savedInstanceState.getString(TEXT_CONTENTS);
//        textView.setText(savedString);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        //shortcut way to save
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onPause();
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onStop();
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onDestroy();
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onStart();
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onResume();
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString()) ;
    //save the current value of whatever is in the textview into that bundle so that we can get access to that somewhere else
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestart();
        Log.d(TAG, "onRestoreInstanceState: out");

    }
}
