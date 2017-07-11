package com.example.androidtest;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener(){
        TextView text;
        String receive = "接收成功！";
        String openBluetooth = "打开蓝牙。。。";
        String searchDevice = "搜索设备。。。";
        String beginReceive="开始接收。。。";
        String error1="您的设备不支持蓝牙0.0";
		private BluetoothAdapter adapter;
        	@Override
        	public void onClick(View v){
        		text = (TextView)findViewById(R.id.textView1);
        		text.setText(openBluetooth);
        		adapter = BluetoothAdapter.getDefaultAdapter();
        		if(adapter==null){
        			text.setText(error1);
        		}
        		if(!adapter.isEnabled()){  
        			
        		}
        	}
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
