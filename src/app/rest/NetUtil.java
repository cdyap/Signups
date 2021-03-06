package app.rest;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class NetUtil {


	public static String postJsonDataToUrl(String url, String json) throws Exception
	{
		DefaultHttpClient httpClient = new DefaultHttpClient();
		InputStream is = null;
		try {
	        HttpPost httpPost = new HttpPost(url);
	        httpPost.setEntity(new StringEntity(json));
	        httpPost.setHeader("Accept", "application/json");
	        httpPost.setHeader("Content-Type", "application/json");
	        
	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        is = httpEntity.getContent();           
	        InputStreamReader isr = new InputStreamReader(is);
	            
	        BufferedReader reader = new BufferedReader(isr);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	        }
	        
	        return sb.toString();
	    }
		finally
		{
			try
			{
				is.close();
			}
			catch(Exception e)
			{
			}
		}
	}
	
	public static String postToUrl(String url) throws Exception
	{
		DefaultHttpClient httpClient = new DefaultHttpClient();

		InputStream is = null;
		try {
	        HttpPost httpPost = new HttpPost(url);
	        
	        HttpResponse httpResponse = httpClient.execute(httpPost);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        is = httpEntity.getContent();           
	        InputStreamReader isr = new InputStreamReader(is);
	            
	        BufferedReader reader = new BufferedReader(isr);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	        }
	        
	        return sb.toString();
	    }
		finally
		{
			try
			{
				is.close();
			}
			catch(Exception e)
			{
			}
		}
	}
	
	public static String readUrlContentAsString(String url) throws Exception
	{
		DefaultHttpClient httpClient = new DefaultHttpClient();

		InputStream is = null;
		try
		{
			// Making HTTP request
	        HttpGet httpGet = new HttpGet(url);
	 
	        HttpResponse httpResponse = httpClient.execute(httpGet);
	        HttpEntity httpEntity = httpResponse.getEntity();
	        is = httpEntity.getContent();           
	        InputStreamReader isr = new InputStreamReader(is);
	            
	        BufferedReader reader = new BufferedReader(isr);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	                sb.append(line + "\n");
	        }
	        
	        return sb.toString();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch(Exception e)
			{
			}
		}		
	}
	
}
