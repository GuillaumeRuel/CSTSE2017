package Menu;

import java.util.ArrayList;

public class Coffee implements ItemRecipe{

    private String size;
    private String length;
    private boolean inverted;
    private ArrayList<String[]> ingredients;

    public Coffee(String size, String length, ArrayList<String[]> ingredients) {

        this.size = size;
        this.length = length;
        this.inverted = inverted;
        this.ingredients = ingredients;
    }

    public String getRecipe(){
        String recipe = addCup() + addGrain();
        if(this.inverted)
            recipe += addIngredients() + addFilter() + getExtract();
        else
            recipe += addFilter() + getExtract() + addIngredients();

        return recipe;
    }

    public String addIngredients(){
        String condiments = "";
        for(String[] ing : ingredients){

            //TODO
        }

        return condiments;
    }

    public String addCup(){

        String cup = "";
        if(this.size.equals("solo"))
            cup = "S";
        if(this.size.equals("doppio"))
            cup = "M";
        if(this.size.equals("triplo"))
            cup = "L";

        return cup;
    }

    public String addGrain(){

        String grain = "";
        if(this.size.equals("solo"))
            grain = "B";
        if(this.size.equals("doppio"))
            grain = "BB";
        if(this.size.equals("triplo"))
            grain = "BBB";

        return grain;
    }

    public String addFilter(){

        return "I";
    }

    public String getExtract(){

        String extract = "";
        if(this.length.equals("ristretto"))
            extract = "E";
        if(this.length.equals("normale"))
            extract = "EE";
        if(this.length.equals("lungo"))
            extract = "EEE";

        return extract;
    }
}
