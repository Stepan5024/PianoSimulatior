package bokarev.st.pianosimulatior.TransformActivities;

import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import bokarev.st.pianosimulatior.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // display the GUI defined in the activity_second.xml file
        setContentView(R.layout.activity_second);

        // get the Intent which caused the start of this activity
        Intent caller = getIntent();
        // get the rating passed by the first activity
        float rating = caller.getFloatExtra("nbStars", 0);

        // retrieve a reference to the View defined in the activity_second.xml
        TextView textView = (TextView) findViewById(R.id.textView);
        // set the text of the textView
        textView.setText("Welcome to the second activity! Your rating: " + rating);
    }
}
