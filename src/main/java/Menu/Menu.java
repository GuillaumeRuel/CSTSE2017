package Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Util.JSONReader;
import org.json.JSONArray;
import org.json.JSONObject;

public class Menu {

	public ItemRecipe findItem(String name){

	    JSONObject obj = JSONReader.findItem(name);
        JSONObject recipe = JSONReader.findKey(obj, "recipe");
        JSONObject itemIng = JSONReader.findKey(recipe, "ingredients");
        Map<String, Object> ingMap = itemIng.toMap();
        Set set = ingMap.entrySet();
        Iterator iter = set.iterator();
        ArrayList<String[]> listIngredients = new ArrayList<>();

        while (iter.hasNext()) {
            Map.Entry me = (Map.Entry)iter.next();
            String[] ing = {String.valueOf(me.getKey()), String.valueOf(me.getValue())};
            listIngredients.add(ing);
        }

        recipe.getBoolean("inverted");

        return new Coffee(recipe.getString("size"), recipe.getString("length"), listIngredients);
	}
	
	public static void main(String[] args) {
        Menu m = new Menu();
        ItemRecipe coffee = m.findItem("lungo");
        System.out.println("Test");
        System.out.println(coffee.getRecipe());
	}
}
