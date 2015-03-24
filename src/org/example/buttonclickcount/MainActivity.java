package org.example.buttonclickcount;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button mButton;
	TextView mTextView;
	
	MyOnClickListener myListener = new MyOnClickListener(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mButton = (Button) findViewById(R.id.button1);
		mButton.setOnClickListener(myListener);
		
		mTextView = (TextView) findViewById(R.id.textView1);
		printInit(mTextView);
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
		if (id == R.id.action_reset) {
			Toast toastMessage = Toast.makeText(this, 
					mTextView.getText() + " when\nSettings menu item was tapped.", 
					Toast.LENGTH_LONG);
			toastMessage.show();
			myListener.setCount(0);
			printInit(mTextView);
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void printInit(TextView mTextView) {
		mTextView.setText("Button tapped " + myListener.getCount() + " times");
	}
}
