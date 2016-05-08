package com.xizz.resolutioninfo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DisplayMetrics metrics = getResources().getDisplayMetrics();
		float screenWidthInches = metrics.widthPixels / (float) metrics.densityDpi;
		float screenHeightInches = metrics.heightPixels / (float) metrics.densityDpi;
		float screenWidthDp = metrics.widthPixels / metrics.density;
		float screenHeightDp = metrics.heightPixels / metrics.density;
		double diagonal = Math.sqrt(Math.pow(screenWidthInches, 2) + Math.pow(screenHeightInches, 2));

		TextView diagonalText = (TextView) findViewById(R.id.text_diagonal);
		TextView sizeText = (TextView) findViewById(R.id.text_size);
		TextView resolutionDpText = (TextView) findViewById(R.id.text_resolution_dp);
		TextView resolutionPxText = (TextView) findViewById(R.id.text_resolution_px);
		TextView densityText = (TextView) findViewById(R.id.text_density);

		NumberFormat format = new DecimalFormat("#.#");

		diagonalText.setText(format.format(diagonal));
		sizeText.setText(getString(R.string.x_formatted,
				format.format(screenWidthInches), format.format(screenHeightInches)));
		resolutionDpText.setText(getString(R.string.x_formatted,
				format.format(screenWidthDp), format.format(screenHeightDp)));
		resolutionPxText.setText(getString(R.string.x_formatted,
				metrics.widthPixels, metrics.heightPixels));
		densityText.setText(String.valueOf(metrics.densityDpi));
	}
}
