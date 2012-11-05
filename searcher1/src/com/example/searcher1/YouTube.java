package com.example.searcher1;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.searcher1.YouTubeException;

public class YouTube {
	
public ArrayList<Video> getVideos(String username) throws YouTubeException {
String rawJSON = fetchJSON(username);
ArrayList<Video> videos;

try {
JSONObject resultSet = new JSONObject(rawJSON);
JSONArray results = resultSet.getJSONObject("data").getJSONArray("items");
videos = new ArrayList<Video>(results.length());
for (int i = 0; i<results.length(); i++)
videos.add(new Video(results.getJSONObject(i)));

} catch(JSONException e) {
throw new YouTubeException(e);
}

return videos;
}

private String fetchJSON(String username) throws YouTubeException {
String url = feedUrl(username);
HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", "Sunlight's Congress Android App (http://github.com/sunlightlabs/congress");

        DefaultHttpClient client = new DefaultHttpClient();
        
        try {
HttpResponse response = client.execute(request);
int statusCode = response.getStatusLine().getStatusCode();

if (statusCode == HttpStatus.SC_OK) {
String body = EntityUtils.toString(response.getEntity());
return body;
} else {
throw new YouTubeException("Bad status code on fetching news");
}
        } catch (Exception e) {
throw new YouTubeException(e);
}
}

private String feedUrl(String username) {
return "https://gdata.youtube.com/feeds/api/videos?v=2&alt=jsonc&q=" + username + "&max-results=10&orderby=relevance";
}
}