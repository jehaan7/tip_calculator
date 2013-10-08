package com.awesome.tip_calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

	public void onCalculateTip10(View v) {
		processTip(10);
	}
	public void onCalculateTip15(View v) {
		processTip(15);
	}
	public void onCalculateTip20(View v) {
		processTip(20);
	}
	
	private void processTip(int percent){
		EditText etAmount = (EditText) findViewById(R.id.etAmount);
		TextView txtTipAmount = (TextView) findViewById(R.id.txtTipAmount);

		try {
			String preTipAmount = etAmount.getText().toString();
			float tip = Float.parseFloat(preTipAmount) * percent / 100;
			txtTipAmount.setText("Tip is: $" + tip);

		} catch (Exception e) {
			Toast.makeText(this, "Amount Missing! " + "", Toast.LENGTH_SHORT)
					.show();
			e.printStackTrace();
		}
	}
}
