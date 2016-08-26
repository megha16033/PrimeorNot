package com.example.megha.primeornot;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class HintActivity extends ActionBarActivity {

    private TextView hint_text;
    private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hint, menu);
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
     * Printing of hint when clicked show hint
     * @param view
     */

    public void onShowHintClick(View view){
        hint_text = (TextView) findViewById(R.id.hinttext);
        String hint = "If a number is divisible only by itself and 1, then its a Prime number!!";
        hint_text.setText(hint);
        flag = true;
    }

    /**
     * Returns the result back to main activity , showing message if hint has been used
     * @param view
     */
    public void onBackClick(View view){
        Intent primeIntent = new Intent(HintActivity.this, PrimeActivity.class);
        if(flag)
        {
            primeIntent.putExtra("hintused",1);
        }
        else
        {
            primeIntent.putExtra("hintused",0);
        }
        setResult(RESULT_OK,primeIntent);
        finish();
    }




}
