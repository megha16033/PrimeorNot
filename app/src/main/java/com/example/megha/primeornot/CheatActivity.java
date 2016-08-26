package com.example.megha.primeornot;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CheatActivity extends ActionBarActivity {

    private boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cheat, menu);
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
     * Displays the correct result after checking the number.
     */
    public void onCheatClick(View view)
    {
        Bundle basket = getIntent().getExtras();
        String cheat;
        String num="";
        if(basket != null) {
            num = basket.getString("number");
        }
        boolean res = isNotPrime(Integer.parseInt(num));
        flag=true;
        TextView cheat_text = (TextView) findViewById(R.id.cheattext);
        if(res)
            cheat = num + " is not prime..";
        else
            cheat = num + " is prime..";
        cheat_text.setText(cheat);
    }

    /**
     * Finding prime or not.
     */

    public boolean isNotPrime(int mi) {
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

    /**
     *  Returning value to the main activity.
     */

    public void onBackClick(View view){
        Intent primeIntent = new Intent(CheatActivity.this, PrimeActivity.class);
        if(flag)
        {
            primeIntent.putExtra("cheating",1);
        }
        else
        {
            primeIntent.putExtra("cheating",0);
        }
        setResult(RESULT_OK,primeIntent);
        finish();
    }
}
