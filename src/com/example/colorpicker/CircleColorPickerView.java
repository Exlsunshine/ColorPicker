package com.example.colorpicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleColorPickerView extends View
{
	private Context context;
	private Bitmap bmp = null;

	public CircleColorPickerView(Context context) {
		super(context);
		this.context = context;
	}

	public CircleColorPickerView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawLineWithAngle(canvas, 100, 100, 900, 900);
	}

	private void drawLineWithAngle(Canvas canvas, float left, float top, float right, float bottom) 
	{
		int swapAngle = 2;
		RectF rect = new RectF(left, top, right, bottom);
		Paint paint = new Paint();
		paint.setStyle(Paint.Style.FILL);

		// RGB
		// FF0000 R
		// FFFF00 RG
		int angle = 0;
		for (int g = 0; g < 0xFF; g += 4)
		{
			if (angle >= 60)
				break;
			paint.setColor(Color.rgb(0xff, g, 00));
			canvas.drawArc(rect, angle, swapAngle, true, paint);
			angle++;
		}

		// FFFF00 RG
		// 00FF00 G
		for (int r = 0xFF; r >= 0; r -= 4)
		{
			if (angle >= 120)
				break;
			paint.setColor(Color.rgb(r, 0xFF, 00));
			canvas.drawArc(rect, angle, swapAngle, true, paint);
			angle++;
		}

		// 00FF00 G
		// 00FFFF GB
		for (int b = 0; b < 0xFF; b += 4) 
		{
			if (angle >= 180)
				break;
			paint.setColor(Color.rgb(0, 0xFF, b));
			canvas.drawArc(rect, angle, swapAngle, true, paint);
			angle++;
		}

		// 00FFFF GB
		// 0000FF B
		for (int g = 0xFF; g >= 0; g -= 4)
		{
			if (angle >= 240)
				break;
			paint.setColor(Color.rgb(0, g, 0xFF));
			canvas.drawArc(rect, angle, swapAngle, true, paint);
			angle++;
		}

		// 0000FF B
		// FF00FF BR
		for (int r = 0; r < 0xFF; r += 4)
		{
			if (angle >= 300)
				break;
			paint.setColor(Color.rgb(r, 0, 0xFF));
			canvas.drawArc(rect, angle, swapAngle, true, paint);
			angle++;
		}

		// FF00FF BR
		// FF0000
		for (int b = 0xFF; b >= 0; b -= 4) 
		{
			if (angle >= 360)
				break;
			paint.setColor(Color.rgb(0xFF, 0, b));
			canvas.drawArc(rect, angle, swapAngle, true, paint);
			angle++;
		}
		
		bmp = Bitmap.createBitmap((int)(right - left), (int)(bottom - top), Bitmap.Config.ARGB_8888);
		canvas.setBitmap(bmp);
	}
	
	public Bitmap getBitmap()
	{
		return bmp;
	}
}