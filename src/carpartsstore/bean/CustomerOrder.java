package carpartsstore.bean;

public class CustomerOrder {
	private int order_id;
	private int customer_id;
	private java.sql.Date dateOfOrder;
	private float amount;
	
	public CustomerOrder(){
		
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public java.sql.Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(java.sql.Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
