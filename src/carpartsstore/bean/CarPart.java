package carpartsstore.bean;

import java.io.Serializable;

public class CarPart implements Serializable{
	private int part_id;
	private int car_id;
	private int supplier_id;
	private String partName;
	private float priceToUs;
	private float priceToCustomer;
	
	public CarPart(){
		
	}

	public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public float getPriceToUs() {
		return priceToUs;
	}

	public void setPriceToUs(float priceToUs) {
		this.priceToUs = priceToUs;
	}

	public float getPriceToCustomer() {
		return priceToCustomer;
	}

	public void setPriceToCustomer(float priceToCustomer) {
		this.priceToCustomer = priceToCustomer;
	}
	
	
}
