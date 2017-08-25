package there.com.there;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutapp);

        TextView fbPage = (TextView) findViewById(R.id.facebook);
        fbPage.setMovementMethod(LinkMovementMethod.getInstance());

        TextView LiPage = (TextView) findViewById(R.id.linkedin);
        LiPage.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
