package spring.com.dto;

public class ClothesVO {
	 
    private int get_seq;
    private String name;
    private String category;
    private String brand;
    private int price;
    private int quantity;
    private String c_size;
    
    
	public int getGet_seq() {
		return get_seq;
	}
	public void setGet_seq(int get_seq) {
		this.get_seq = get_seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getC_size() {
		return c_size;
	}
	public void setC_size(String c_size) {
		this.c_size = c_size;
	}
	public void showinfo() {
		System.out.println("¿Ê¸í:"+name);
	}
    
}
