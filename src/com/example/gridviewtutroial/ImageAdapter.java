package com.example.gridviewtutroial;

import java.io.File;
import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter{
	private Activity mContext;
	ArrayList<String> files;

    public ImageAdapter(Activity c, ArrayList<String> files) {
        mContext = c;
        this.files = files;
    }

    public int getCount() {
        return files.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }
    
    static class ViewHolder {
        protected ImageView view;
        protected CheckBox checkbox;
        
      }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ImageView imageView;
    	 View view = null;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
        	 LayoutInflater inflator = mContext.getLayoutInflater();
             view = inflator.inflate(R.layout.rowlayout, null);
             final ViewHolder viewHolder = new ViewHolder();
             viewHolder.view = (ImageView) view.findViewById(R.id.icon);
             viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);
             viewHolder.checkbox
                 .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                   @Override
                   public void onCheckedChanged(CompoundButton buttonView,
                       boolean isChecked) {

                   }
                 });
             view.setTag(viewHolder);
             viewHolder.checkbox.setTag(files.get(position));
           
        } else {
        	view = convertView;
            ((ViewHolder) view.getTag()).checkbox.setTag(files.get(position));
        }
        /*File f = new File(files.get(position));
        System.out.println(f.toString());
        Bitmap bitmap = BitmapFactory.decodeFile(files.get(position));
        imageView.setImageBitmap(bitmap);
        //imageView.setImageResource(mThumbIds[position]);
        return imageView;*/
        File f = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "MyCameraApp");
        System.out.println(f.getAbsolutePath() + File.separator + files.get(position));
        
        
        
        /*BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(f.getAbsolutePath() + File.separator + files.get(position), bounds);
        if ((bounds.outWidth == -1) || (bounds.outHeight == -1))
            return null;

        int originalSize = (bounds.outHeight > bounds.outWidth) ? bounds.outHeight
                : bounds.outWidth;

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = originalSize / 64;
        
        */
        Bitmap b = BitmapFactory.decodeFile(f.getAbsolutePath() + File.separator + files.get(position));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(b, 300, 300, false);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.view.setImageBitmap(resizedBitmap);
        //holder.view.setImageBitmap(BitmapFactory.decodeFile(f.getAbsolutePath() + File.separator + files.get(position), opts));
        //holder.view.setImageBitmap(BitmapFactory.decodeFile(f.getAbsolutePath() + File.separator + files.get(position)));
        return view;
    }

   
    
    


}
