package com.example.searcher1;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
    // TabSpec Names
    private static final String YOUTUBE_SPEC = "YouTube";
    
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        TabHost tabHost = getTabHost();
 
        // Inbox Tab
        TabSpec YTSpec = tabHost.newTabSpec(YOUTUBE_SPEC);
        // Tab Icon
        YTSpec.setIndicator(YOUTUBE_SPEC, getResources().getDrawable(R.drawable.ic_launcher));
        Intent youtubeIntent = new Intent(this, JsonParsingActivity.class);
        // Tab Content
        YTSpec.setContent(youtubeIntent);
        
            
 
                // Adding all TabSpec to TabHost
        tabHost.addTab(YTSpec); // Adding Inbox tab
    }

}