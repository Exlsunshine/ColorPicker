package com.exlsunshine.colorpicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.colorpicker.R;
import com.exlsunshine.colorpicker.ColorPickView.OnColorChangedListener;

public class MainActivity extends Activity
{
	private TextView txtColor;
	private ColorPickView myView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}