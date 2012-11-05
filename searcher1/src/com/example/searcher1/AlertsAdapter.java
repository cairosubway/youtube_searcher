package com.example.searcher1;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

		 
	public class AlertsAdapter extends ArrayAdapter<Video> {
	 
	    int resource;
	    String response;
	    Context context;
	    
	    //Initialize adapter
	    public AlertsAdapter(Context context, int resource, List<Video> videos) {
	        super(context, resource, videos);
	        this.resource=resource;
	 
	    }
	     
	     
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent)
	    {
	        LinearLayout alertView;
	        //Get the current alert object
	        Video al = getItem(position);
	        	         
	        //Inflate the view
	        if(convertView==null)
	        {
	            alertView = new LinearLayout(getContext());
	            String inflater = Context.LAYOUT_INFLATER_SERVICE;
	            LayoutInflater vi;
	            vi = (LayoutInflater)getContext().getSystemService(inflater);
	            vi.inflate(resource, alertView, true);
	        }
	        else
	        {
	            alertView = (LinearLayout) convertView;
	        }
	        
	        //Get the text boxes from the listitem.xml file
	        TextView alertText = (TextView)alertView.findViewById(R.id.txtAlertText);
	        TextView videoDate = (TextView)alertView.findViewById(R.id.txtVideoDate);
	        ImageView thumb = (ImageView)alertView.findViewById(R.id.thumbnail);
	        
	        //Assign the appropriate data from our alert object above
	        alertText.setText(al.title);
	        videoDate.setText(al.uploader);
	        
	       String thumbnailUrl = al.thumbnailUrl;
	        
	       ImageLoader imageLoader = new ImageLoader(context);
	       
	       imageLoader.DisplayImage(thumbnailUrl, thumb); 
	       
	       return alertView;
	    }


		

			
		}
	 
	
	
	

