package there.com.there;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//    --------------------------------THIS IS RESULTS SCREEN-----------------------------------------
//    -----------------------------------------------------------------------------------------------
public class Results extends Calculation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputlayout);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listdisplay, result);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            data.clear();
            Intent in = new Intent(this,MainActivity.class);
            startActivity(in);
        }
        return true;
    }
}
