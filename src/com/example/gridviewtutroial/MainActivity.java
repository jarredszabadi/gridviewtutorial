package com.example.gridviewtutroial;

import java.io.File;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<String> FilesInFolder = GetFiles("mnt/sdcard/Pictures/MyCameraApp/");
		GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this, FilesInFolder));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public ArrayList<String> GetFiles(String DirectoryPath) {
		
		

		
		
		
	    ArrayList<String> MyFiles = new ArrayList<String>();
	    File f = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "MyCameraApp");

	    

	    f.mkdirs();
	    File[] files = f.listFiles();
	    if (files.length == 0){
	    	System.out.println("hi: "+f.toString());
	        return null;
	    }
	    else {
	        for (int i=0; i<files.length; i++) {
	        	//System.out.println(f.getAbsolutePath() + File.separator + files[i]);
	            MyFiles.add(files[i].getName());
	        }
	    }

	    return MyFiles;
	}

}
