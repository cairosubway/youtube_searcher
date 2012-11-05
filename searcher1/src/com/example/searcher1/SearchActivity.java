package com.example.searcher1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.searcher1.JsonParsingActivity;

public class SearchActivity extends Activity {

	private Button button;
	private EditText result;
	final Context context = this;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
     // components from main.xml
     		button = (Button) findViewById(R.id.buttonPrompt);
     		result = (EditText) findViewById(R.id.editTextResult);
      
     		// add button listener
     		button.setOnClickListener(new OnClickListener() {
      
     			@Override
     			public void onClick(View arg0) {
      
     				     				
                     String Data = result.getText().toString();
                   
                     Intent i = new Intent(context, JsonParsingActivity.class);
                     Bundle extras = new Bundle();
                     extras.putString("searchterm", Data);
                     i.putExtras(extras);
                     startActivityForResult(i, 1);
    
    
    
    }
});
    }
}
