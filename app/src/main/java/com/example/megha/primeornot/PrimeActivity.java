package com.example.megha.primeornot;
import android.content.Intent;
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


    //by default method
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

    /**
     * overriding this function, which will handle that result is coming from which activity
     * @param requestcode
     * @param resultcode
     * @param data
     */
    @Override
    public void onActivityResult(int requestcode , int resultcode, Intent data){
        if(requestcode == 1)
        {
            int value = data.getIntExtra("hintused" , 0);
            if(value == 1)
            {
                Toast.makeText(this, "You have used the hint...", Toast.LENGTH_SHORT ).show();
            }
        }
        else if(requestcode == 2)
        {
            int value = data.getIntExtra("cheating" , 0);
            if(value == 1)
            {
                Toast.makeText(this, "You are a cheater...", Toast.LENGTH_SHORT ).show();
            }
            else
            {
                Toast.makeText(this, "You are an honest person...", Toast.LENGTH_SHORT ).show();
            }

        }
    }
    ////////////////////////////////////////////////////////////////
    /**
     * Display correct if number is not prime and you click on false
     */
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

    /**
     *  Display correct if number is not prime and you click on true
     */
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

    /**
     * Display next prime number
     * @param view
     */
    public void onNextClick(View view) {
        TextView mquestion = (TextView) findViewById(R.id.question);
        Random mr = new Random();
        int mnum = mr.nextInt(1000) + 1;
        String minput = "Is " + mnum + " a Prime Number?";
        mquestion.setText(minput);
    }

    /**
     * Perform the process as suggested on hint click
     */
    public void onHintClick(View view) {
        Intent hintIntent = new Intent(PrimeActivity.this, HintActivity.class);
        startActivityForResult(hintIntent, 1);
    }

    /**
     * Perform the logic as suggested on cheat click
     * @param view
     */
    public void onCheatClick(View view) {
        Intent cheatIntent = new Intent(PrimeActivity.this, CheatActivity.class);
        TextView mquestion = (TextView) findViewById(R.id.question);
        String minput = mquestion.getText().toString();
        String marr[] = minput.split(" ");
        cheatIntent.putExtra("number", marr[1]);
        startActivityForResult(cheatIntent, 2);
    }

    /**
     * Check whether number is prime or not
     * @param mi
     * @return
     */
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
