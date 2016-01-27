package com.example.sd;

import java.util.ArrayList;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.Toast;



public class MainActivity extends Activity {
	GifView gifView;
	private EditText edt;
	private TableRow tr;
	String names[];
	private Button btn;
	ImageButton img_button;
		private String imgName;
		private String x;
		private int icon;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
       
        edt=(EditText) findViewById(R.id.editText1);
       tr=(TableRow) findViewById(R.id.tableRow1);
         btn=(Button) findViewById(R.id.button1);
         img_button=(ImageButton) findViewById(R.id.imageButton1);
 btn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {	
				
				View_gifImage();
    		                    	  
			}
			});
 img_button.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {	
			
			View_gifImage();
		                    	  
		}
		});
	}
	public void View_gifImage(){
		 tr.removeAllViews();
		imgName=edt.getText().toString().trim().toLowerCase();
		names=imgName.split(" ");
		ArrayList<View> gifs=new ArrayList<View>();
	                    	   for (int i = 0; i < names.length; i++) {
	                    		   try{
	                    			  
	                    		   x=names[i];
	                    		   icon = getResources().getIdentifier(x, "raw", getPackageName());
	                    		   gifView=new GifView(MainActivity.this,icon);
	                    		   gifs.add(gifView);
        		     	            tr.addView(gifs.get(i));
	                    		   }catch(Exception e){
	                    			   Toast.makeText(MainActivity.this,x+" no such name ", Toast.LENGTH_SHORT).show();
	                    		   }
	                    	   }
	                    	
		
		
	}
}
