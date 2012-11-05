package com.example.searcher1;

import java.util.ArrayList;
import java.util.List;
 
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.View;
	
	
import com.example.searcher1.Video;
import com.example.searcher1.YouTube;
import com.example.searcher1.YouTubeException;
	 
public class JsonParsingActivity extends Activity  {
	         
		
		//ListView that will hold our items references back to main.xml
	    ListView lstTest;
	    //Array Adapter that will hold our ArrayList and display the items on the ListView
	    AlertsAdapter arrayAdapter;
	     
	    //List that will  host our items and allow us to modify that array adapter
	    ArrayList<Video> alrts=null;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.youtube_list);
	        
	        String username = null;      
	        Bundle extras = getIntent().getExtras();
	        
	        if(extras != null)
	        {
	            username = extras.getString("searchterm");
	        }
	                
	       //Initialize ListView
	        lstTest= (ListView)findViewById(R.id.list);
	        
	      //Initialize our ArrayList
	        alrts = new ArrayList<Video>();
	       
	       //Initialize our array adapter notice how it references the listitems.xml layout
	        arrayAdapter = new AlertsAdapter(JsonParsingActivity.this, R.layout.youtube_list_item,alrts);
	        
	      //Set the above adapter as the adapter of choice for our list
	        lstTest.setAdapter(arrayAdapter);
	        
	        List<Video> lst = null;
			try {
				lst = new YouTube().getVideos(username);
			} catch (YouTubeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	        
	        for (Video l : lst)
	        {
	        alrts.add(l);	
	        }
	        
            arrayAdapter.notifyDataSetChanged();
	         
	    

	 // listening to single list item on click
        lstTest.setOnItemClickListener(new OnItemClickListener() {
          public void onItemClick(AdapterView<?> parent, View view,
              int position, long id) {
 
         	  String s = Video.getId(position);
        	  Intent intent = new Intent(Intent.ACTION_VIEW, 
                      Uri.parse("vnd.youtube://" 
                    + s ));
              startActivity(intent); 
	
        	  
        	  
	
}
        });
	    }
	}
	