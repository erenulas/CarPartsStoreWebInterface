package carpartsstore.bean;

import java.util.ArrayList;

public class PartInOrder {
	private int part_in_order;
	private int order_id;
	private int quantity;
	private int part_id;
	
	public PartInOrder(){
		
	}

	public int getPart_in_order() {
		return part_in_order;
	}

	public void setPart_in_order(int part_in_order) {
		this.part_in_order = part_in_order;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPart_id() {
		return part_id;
	}

	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}


	
}
