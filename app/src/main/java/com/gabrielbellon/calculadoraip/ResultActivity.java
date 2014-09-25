package com.gabrielbellon.calculadoraip;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ResultActivity extends Activity {

	public final static String VALUE_CIDRIP = "VALUE_CIDRIP";
	public final static String VALUE_IP = "VALUE_IP";
	public final static String VALUE_BITS = "VALUE_BITS";

	private NetCalc net;
	private String cidrIP, ip, bits;

	private TextView netEnd, netMask, netBroadcast, netMax, netMin;

	private ListView hostList;

	private ListAdapter listAdap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		setupActionBar();
		initViews();
		initVars();
		loadNetInfo();
		
		this.setTitle("Resultados para " + cidrIP);
	}

	// Inicializa as Views
	public void initViews() {
		netEnd = (TextView) findViewById(R.id.net_end);
		netMask = (TextView) findViewById(R.id.net_mask);
		netBroadcast = (TextView) findViewById(R.id.net_broadcast);
		netMax = (TextView) findViewById(R.id.net_max);
		netMin = (TextView) findViewById(R.id.net_min);
		hostList = (ListView) findViewById(R.id.host_list);
	}

	public void initVars() {
		cidrIP = getIntent().getStringExtra(VALUE_CIDRIP);
		ip = getIntent().getStringExtra(VALUE_IP);
		bits = getIntent().getStringExtra(VALUE_BITS);
	}

	public void loadNetInfo() {
		net = new NetCalc(ip, bits);

		netEnd.setText(net.getNetAddress());
		netMask.setText(net.getNetmask());
		netBroadcast.setText(net.getBroadcast());
		netMax.setText(net.getHighAddress());
		netMin.setText(net.getLowAddress());

		listAdap = new ArrayAdapter<String>(this, R.layout.host_layout, net.getAllAddresses());
		
		hostList.setAdapter(listAdap);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
