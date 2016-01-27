package com.example.sd;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

public class GifView extends View{

	private InputStream gifInputStream;
	private Movie gifMovie;
	private int movieWidth, movieHeight;
	private long movieDuration;
	private long movieStart;

	public GifView(Context context,int img) {
		super(context);
		
		init(context,img);
	
		
	}

	
	public GifView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		
	}
	
	public GifView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
				
		
	}
	
	public  void init(Context context,int img) {
		setFocusable(true);
		gifInputStream = context.getResources().openRawResource(img);
	
		gifMovie = Movie.decodeStream(gifInputStream);
		movieWidth = gifMovie.width();
		movieHeight = gifMovie.height();
		movieDuration = gifMovie.duration();
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(movieWidth, movieHeight);
	}
	
	public int getMovieWidth() {
		return movieWidth;
	}
	
	public int getMovieHeight() {
		return movieHeight;
	}
	
	public long getMovieDuration() {
		return movieDuration;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
		long now = SystemClock.uptimeMillis();
		
		if(movieStart == 0) {
			movieStart = now;
		}
		if(gifMovie != null) {
			//int dur = gifMovie.duration();
			// int relTime = (int)((now - movieStart)%dur); infinite loop 
			int relTime = (int)((now - movieStart));    //loop one time (shalla)
			gifMovie.setTime(relTime);
			gifMovie.draw(canvas, 0, 0);
			invalidate();
		}
	}
}
