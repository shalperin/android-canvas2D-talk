package samhalperin.com.canvasexercises.index;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import samhalperin.com.canvasexercises.R;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void onButtonPress(View view) {
        new Controller(this).launch(view.getId());
    }

}


