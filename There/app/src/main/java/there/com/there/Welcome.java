package there.com.there;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener ;
import android.widget.Button;

//    --------------------------------THIS IS WELCOME SCREEN-----------------------------------------
//    -----------------------------------------------------------------------------------------------
public class Welcome extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Button letsRoll = (Button)findViewById(R.id.start);
        Button AboutApp = (Button)findViewById(R.id.about);
        letsRoll.setOnClickListener(rolling);
        AboutApp.setOnClickListener(app);
    }

    final OnClickListener rolling = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent in = new Intent(getBaseContext(),MainActivity.class);
            startActivity(in);
        }
    };

    final OnClickListener app = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent in = new Intent(getBaseContext(),AboutApp.class);
            startActivity(in);
        }
    };
}
