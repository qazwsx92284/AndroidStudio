
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    }
}
