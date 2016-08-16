package com.example.megha.primeornot;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class PrimeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prime, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ////////////////////////////////////////////////////////////////
    //Logic to be performed during false click
    public void onFalseClick(View view) {
        TextView mquestion = (TextView) findViewById(R.id.question);
        String minput = mquestion.getText().toString();
        String marr[] = minput.split(" ");
        boolean mres = isTrueFalse(Integer.parseInt(marr[1]));
        Toast toast = new Toast(this);
        //If I entered true in this case then it will show that my decision is correct else incorrect
        if (mres == true) {
            toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            toast.setGravity(Gravity.TOP, 0, 0);
        } else {
            toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
            toast.setGravity(Gravity.TOP, 0, 0);
        }

    }

    /* Logic to be performed during true click  */
    public void onTrueClick(View view) {
        TextView mquestion = (TextView) findViewById(R.id.question);
        String minput = mquestion.getText().toString();
        String marr[] = minput.split(" ");
        boolean mres = isTrueFalse(Integer.parseInt(marr[1]));
        Toast toast = new Toast(this);
        // If I entered false in this case then it will show that my decision is correct else incorrect
        if (mres == true) {
            toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
            toast.setGravity(Gravity.TOP, 0, 0);
        } else {
            toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            toast.setGravity(Gravity.TOP, 0, 0);
        }
    }

    //Logic to be performed when clicks next
    public void onNextClick(View view) {
        TextView mquestion = (TextView) findViewById(R.id.question);
        Random mr = new Random();
        int mnum = mr.nextInt(1000) + 1;
        String minput = "Is " + mnum + " a Prime Number?";
        mquestion.setText(minput);
    }

    //Logic for prime check
    public boolean isTrueFalse(int mi) {
        if (mi == 1)
            return true;
        else {
            for (int mj = 2; mj < mi / 2; ++mj) {
                if (mi % mj == 0)
                    return true;
            }
            return false;
        }
    }
}
