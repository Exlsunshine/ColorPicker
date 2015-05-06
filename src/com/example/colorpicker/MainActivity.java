package com.example.colorpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.colorpicker.ColorPickView.OnColorChangedListener;

public class MainActivity extends Activity {

	private TextView txtColor;
	private ColorPickView myView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myView = (ColorPickView) findViewById(R.id.color_picker_view);
		txtColor = (TextView) findViewById(R.id.txt_color);
		myView.setOnColorChangedListener(new OnColorChangedListener() 
		{
			@Override
			public void onColorChange(int color)
			{
				txtColor.setTextColor(color);
			}
		});
		
		/*CircleColorPickerView ccp = new CircleColorPickerView(this);
		ccp = (CircleColorPickerView) findViewById(R.id.circle_color_picker_view);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
