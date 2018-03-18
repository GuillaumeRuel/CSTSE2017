package Menu;

import java.util.ArrayList;

public class ItemRecipe {
	
	private String size;
	private String length;
	private Boolean inverted;
	private ArrayList<String> ingredients;
	
	public ItemRecipe(String size, String length, Boolean inverted, ArrayList<String> ingredients) {
		
		this.size = size;
		this.length = length;
		this.inverted = inverted;
		this.ingredients = ingredients;
	}
	
	public String toString() {
		
		
		return "";
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public Boolean getInverted() {
		return inverted;
	}

	public void setInverted(Boolean inverted) {
		this.inverted = inverted;
	}

	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<String> ingredients) {
		this.ingredients = ingredients;
	}
}
