package there.com.there;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//    --------------------------------THIS IS INPUT SCREEN-------------------------------------------
//    -----------------------------------------------------------------------------------------------

public class MainActivity extends AppCompatActivity {

    public static ArrayList<MainActivity> data = new ArrayList<>();
    static EditText getName, getAmount;
    static ListView listView;
    protected String name = null;
    protected int amount = 0;
    private TextView tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextButton = (Button) findViewById(R.id.next);
        Button doneButton = (Button) findViewById(R.id.Launch);
        Button cancelButton = (Button) findViewById(R.id.Refresh);
        getName = (EditText) this.findViewById(R.id.Name);
        getAmount = (EditText) this.findViewById(R.id.Amount);
        tip = (TextView) findViewById(R.id.amountTip);
        nextButton.setOnClickListener(NEXT);
        doneButton.setOnClickListener(DONE);
        cancelButton.setOnClickListener(cancel);
    }

    final OnClickListener DONE = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if ((getName.getText().toString()).equals("")) {

                //If both field is empty then moving to Calculation Phase--->
                new Calculation();

                //Displaying the results--->
                Intent in = new Intent(getBaseContext(), Results.class);
                startActivity(in);
            } else {

                //If user entered the details, then adding this to Array list
                getAndAdd();
                //then moving to Calculation phase
                new Calculation();

                //Displaying the results--->
                Intent in = new Intent(getBaseContext(), Results.class);
                startActivity(in);
            }
        }
    };

    boolean visibleTip = true;

    final OnClickListener NEXT = new OnClickListener() {
        @Override
        public void onClick(View view) {
            //If name field is empty-->
            if ((getName.getText().toString()).equals("")) {
                Toast.makeText(getBaseContext(), "Name feild is empty", Toast.LENGTH_SHORT).show();
            } else {

                //Taking user's input--->
                getAndAdd();
            }

            if (visibleTip) {
                tip.setText(null);
                visibleTip = false;
            }
        }
    };

    public void getAndAdd() {
        //Getting new person object-->
        MainActivity currentPerson = new MainActivity();

        //Taking name of current person
        currentPerson.name = getName.getText().toString();
        try {
            //Taking current person's amount contributed--->
            currentPerson.amount = Integer.parseInt(getAmount.getText().toString());
        } catch (NumberFormatException e) {
            //If amount field is left empty, setting it to '0'
            currentPerson.amount = 0;
            Toast.makeText(getBaseContext(), "Amount set to 0", Toast.LENGTH_SHORT).show();
        }
        //Adding this person to Array List--->
        data.add(currentPerson);

        //Moving cursor back to 'Name' field
        setToNull();
        getName.requestFocus();
    }

    //For clearing all the fields--->
    private void setToNull() {
        getAmount.setText(null);
        getName.setText(null);
    }

    //To clear the Array list--->
    final OnClickListener cancel = new OnClickListener() {
        @Override
        public void onClick(View view) {
            data.clear();
            setToNull();
            Toast.makeText(getBaseContext(), "Erased", Toast.LENGTH_SHORT).show();
        }
    };

    //Exiting the application with AlertDialog
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
            exitDialog.setMessage("Exit Application?");
            exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    moveTaskToBack(true);
                    finish();
                    int pid = android.os.Process.myPid();
                    android.os.Process.killProcess(pid);
                }
            });
            exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity m = new MainActivity();
                    m.moveTaskToBack(true);
                }
            });
            exitDialog.show();
        }
        return true;
    }
}
