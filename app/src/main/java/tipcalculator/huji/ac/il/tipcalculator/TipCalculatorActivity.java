package tipcalculator.huji.ac.il.tipcalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class TipCalculatorActivity extends Activity {

    DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        final EditText eText = (EditText) findViewById(R.id.amountInput);

        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bill = Integer.parseInt(eText.getText().toString());
                double tip = bill * 0.12;
                Context context = getApplicationContext();
//                Toast toast = Toast.makeText(context, "tip is: " + tip + "$", Toast.LENGTH_SHORT);
                CheckBox chkBx = (CheckBox) findViewById(R.id.chkRound);
                if (chkBx.isChecked()){
                    ((TextView)findViewById (R.id.tipTxt)).setText ("Tip: $" + (int) Math.round(tip));
                }else {
                    ((TextView) findViewById(R.id.tipTxt)).setText("Tip: $" + df.format(tip));
                }
//                toast.show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
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
}
