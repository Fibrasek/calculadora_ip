package com.gabrielbellon.calculadoraip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText ip0, ip1, ip2, ip3;
	Spinner subnet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ip0 = (EditText) findViewById(R.id.ip0);
		ip0.setFilters(new InputFilter[] { new InputFilterMinMax("0", "255") });

		ip1 = (EditText) findViewById(R.id.ip1);
		ip1.setFilters(new InputFilter[] { new InputFilterMinMax("0", "255") });

		ip2 = (EditText) findViewById(R.id.ip2);
		ip2.setFilters(new InputFilter[] { new InputFilterMinMax("0", "255") });

		ip3 = (EditText) findViewById(R.id.ip3);
		ip3.setFilters(new InputFilter[] { new InputFilterMinMax("0", "255") });

		ArrayAdapter<CharSequence> spinAdapter = ArrayAdapter
				.createFromResource(this, R.array.subnet_bits,
						android.R.layout.simple_spinner_item);

		subnet = (Spinner) findViewById(R.id.subnetbits);
		subnet.setAdapter(spinAdapter);

		Button calc = (Button) findViewById(R.id.calcular);
		calc.setOnClickListener(this);

	}

	public void sendValues(String ip0, String ip1, String ip2, String ip3,
			String bits) {
		if (ip2.equals("") || ip3.equals("")) {
			Toast.makeText(this, "Você não entrou um IP válido :(",
					Toast.LENGTH_SHORT).show();
			return;
		}

		String ip = ip0 + "." + ip1 + "." + ip2 + "." + ip3;
		Log.e("IP", ip);

		Intent i = new Intent(this, ResultActivity.class);
		i.putExtra(ResultActivity.VALUE_IP, ip);
		i.putExtra(ResultActivity.VALUE_BITS, bits);
		i.putExtra(ResultActivity.VALUE_CIDRIP, ip + "/" + bits);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}

	@Override
	public void onClick(View v) {
		sendValues(ip0.getText().toString(), ip1.getText().toString(), ip2
				.getText().toString(), ip3.getText().toString(), subnet
				.getAdapter().getItem(subnet.getSelectedItemPosition())
				.toString());
	}

}
