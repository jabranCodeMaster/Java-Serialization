import java.io.Serializable;

public class Product implements Serializable {
	private String name;
	private String model;
	private int quantity;
	
	public Product(String nam, String mod, int qty){
		name = nam;
		model = mod;
		quantity = qty;
	}
	
	public String getName(){
		return name;
	}
	
	public String getModel(){
		return model;
	}

	public int getQuantity(){
		return quantity;
	}
	public String toString()
	{
		return "Product name=" + name + " model=" + model + " quantity=" + quantity;
	}
}
