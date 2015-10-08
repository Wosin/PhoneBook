package com.gft.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;

import com.gft.model.User;
@Service
public class SearchingService {

	
	public static String SearchByNumber(String number,String Json) {
		JSONObject jsonOb = null;
		try {
			 jsonOb = new JSONObject(Json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject Users=null;
		
			Users = jsonOb.optJSONObject("PhoneBook");
	JSONArray numbers = null;
		try {
			 numbers = Users.getJSONArray("User");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// TODO Auto-generated catch block
		User us = null;
	
		JSONArray matches = new JSONArray();
	for(int i=0;i<numbers.length();i++)
	{
		
		try {
			JSONObject user = numbers.getJSONObject(i);
			String Number = user.getString("Number");
			String Name = user.getString("Name");
			String Prefix = user.getString("Prefix");
			int id = user.getInt("Id");
	
			if(Number.equals(number))
			{
				us = new User(id, Name, Prefix, Number);
				
				matches.put(user);
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	return matches.toString();
	}
	public static String SearchByPrefix(String number,String Json) {
		JSONObject jsonOb = null;
		try {
			 jsonOb = new JSONObject(Json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject Users=null;
		
			Users = jsonOb.optJSONObject("PhoneBook");
	JSONArray numbers = null;
		try {
			 numbers = Users.getJSONArray("User");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// TODO Auto-generated catch block
		User us = null;
	
		JSONArray matches = new JSONArray();
	for(int i=0;i<numbers.length();i++)
	{
		
		try {
			JSONObject user = numbers.getJSONObject(i);
			String Number = user.getString("Number");
			String Name = user.getString("Name");
			String Prefix = user.getString("Prefix");
			int id = user.getInt("Id");
	
			if(Prefix.equals(number))
			{
				us = new User(id, Name, Prefix, Number);
				
				matches.put(user);
			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	return matches.toString();
	}

	
}
