package com.dci.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class menu {
	
	
	private static String findItemMenu(String name) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("file/menu.json"));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    
		    JSONArray arr = new JSONArray(everything);

		    for(int i = 0; i < arr.length(); i++) {
		    	
		    	JSONObject obj = arr.getJSONObject(i);
		    	String itemName = obj.getString("name");
		    	if(itemName.equals(name)) {
		    		
		    		JSONObject itemObj = obj.getJSONObject("recipe");
		    		JSONObject itemIng = itemObj.getJSONObject("ingredients");
		    		Map<String, Object> ingMap = itemIng.toMap();
		    		Set set = ingMap.entrySet();
		    		Iterator iter = set.iterator();
		    		ArrayList<String> listIngredients = new ArrayList<String>();
		    		
		    		while (iter.hasNext()) {
		    			Map.Entry me = (Map.Entry)iter.next();
		    			listIngredients.add(String.valueOf(me.getKey()));
		    			listIngredients.add(String.valueOf(me.getValue()));
		    		}
		    		ItemRecipe r = new ItemRecipe(itemObj.getString("size"), itemObj.getString("length"),
		    				itemObj.getBoolean("inverted"), listIngredients);
		    		
		    		return r.toString();
		    	}
		    }
		} finally {
		    br.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		try {
			String obj = findItemMenu("lungo");
			System.out.println(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
