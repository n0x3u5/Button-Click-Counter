package org.example.buttonclickcount;

import android.view.View;
import android.view.View.OnClickListener;

public class MyOnClickListener implements OnClickListener{
	
	MainActivity caller;
	private int count = 0;
	
	public MyOnClickListener() {
		this.count = 0;
	}
	
	public MyOnClickListener(MainActivity caller) {
		
		this();
		this.caller = caller;
		
	}
	
	@Override
	public void onClick(View view) {
		
		count++;
		String outputString = "Button tapped " + count + " time";
		if(count!=1)
			outputString += "s";
		
		caller.mTextView.setText(outputString);
		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
