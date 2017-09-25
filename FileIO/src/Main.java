import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();

		// create products
		for (int i=0; i<10; i++)
		{
			products.add(new Product("Product" + i, "model" + i, i));
		}

		try
		{
			FileOutputStream fileOut = new FileOutputStream("product.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			System.out.println("Writing...");
			printProducts(products);
			out.writeObject(products);
			
			out.close();
			fileOut.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		ArrayList<Product> products2;
		
		try
		{
			FileInputStream fileIn = new FileInputStream("product.dat");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			System.out.println("Reading...");
			products2 = (ArrayList<Product>)(in.readObject());
			printProducts(products2);
			
			in.close();
			fileIn.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}	
	}
	private static void printProducts(ArrayList<Product> products)
	{
		for (int i=0; i<products.size(); i++)
		{
			System.out.println(products.get(i));
		}
	}
}
