package com.xizz.resolutioninfo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DisplayMetrics metrics = getResources().getDisplayMetrics();
		float density = metrics.density * 160;
		float width = metrics.widthPixels / density;
		float height = metrics.heightPixels / density;
		double diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));


		TextView txtDiagonal = (TextView) findViewById(R.id.textViewDiagonal);
		TextView txtSize = (TextView) findViewById(R.id.textViewSize);
		TextView txtResolution = (TextView) findViewById(R.id.textViewResolution);
		TextView txtDensity = (TextView) findViewById(R.id.textViewDensity);

		txtDiagonal.setText(String.format("%.1f", diagonal));
		txtSize.setText(String.format("%.1f", width) + " x "
				+ String.format("%.1f", height));
		txtResolution.setText(metrics.widthPixels + " x " + metrics.heightPixels);
		txtDensity.setText(String.format("%.0f", density));
	}
}
