/*
 * Code by __E18/1025__
 * Shopping Cart for item 
 */

public class ShoppingCart {
	private Item firstItem ;
	private Item lastItem;
	private double total;
	
	ShoppingCart(){
		this.firstItem = null;
		this.lastItem = null;
		this.total = 0.0;
	}
	
	static class Item{
		private long itemID;
		private String itemName;
		private double price;
		private long quantity;
		private Item next;
		
		Item(long itemID, String itemName, double price, long quantity){
			this.itemID = itemID;
			this.itemName = itemName;
			this.price = price;
			this.quantity = quantity;
			this.next = null;
		}
	}
	
	/*
	 * @param   nothing
	 * @return  true if Shopping Cart is Empty otherwise false
	 */
	public boolean isEmpty() {
		if (this.firstItem == null)
			return true;
		return false;
	}
	
	/*
	 * @param   item id(long), item name (string), item price (double), item quantity(long)
	 * @return  nothing
	 * Add item into the Shopping Cart list
	 */
	public void add(long itemID, String itemName, double price, long quantity) {
		Item newItem = new Item(itemID, itemName, price, quantity);
		total += price * (double)quantity;
		if(isEmpty()) {
			firstItem = newItem;
			lastItem = newItem;
		}
		else {
			lastItem.next = newItem;
			lastItem = lastItem.next;
		}
	}
	
	/*
	 * @param   Item id (long)
	 * @return  nothing
	 * Remove Item from list of Shopping cart
	 */
	public void remove(long itemID) {
		Item it = firstItem;
		Item pre = firstItem;
		while(it != null) {
			if(it.itemID == itemID)
				break;
			pre = it;
			it = it.next;
		}
		if(it == firstItem) 
			firstItem = firstItem.next;
		else if(it == lastItem) {
			lastItem = pre;
			pre.next = null;
		}
		else 
			pre.next = it.next;
		System.out.println("Item id-" + it.itemID + " Removed !");
		it = null;
	}
	
	/*
	 * @param   item-id (long)
	 * @return  Item reference if it is found otherwise null
	 */
	public Item searchItem(long item_id) {
		Item it = firstItem;
		while(it != null) {
			if(it.itemID == item_id)
				return it;
			it = it.next;
		}
		return null;
	}
	
	/*
	 * @param   item-id(long), change ("+" or "-")(String), Quantity(long)
	 * @return  nothing
	 * + used for Increase Quantity
	 * - used for Decrease Quantity
	 */
	public void changeQuantity(long itemID, String change, long quantity) {
		Item item = this.searchItem(itemID);
		if (item == null)
			System.out.println("Item is not found !");
		else {
			long newQuantity = (change.equals("+") ? quantity : quantity*(-1)) ;
			long preQuantity = item.quantity;
			item.quantity += newQuantity;
			if(item.quantity < 0) {
				newQuantity = preQuantity*(-1);
				item.quantity = 0;
			}
			total += item.price * (double)newQuantity;
			System.out.println("Item id-" + itemID + " Quantity is Changed !");
			if(item.quantity == 0)
				this.remove(item.itemID);
		}
	}
	
	
	/*
	 * @param   nothing
	 * @return  nothing
	 * Print list of all items present in Shopping Cart
	 */
	public void itemList() {
		Item it = firstItem;
		while(it != null) {
			System.out.println(it.itemID + "---" + it.itemName + "---" + it.price + "---" + it.quantity );
			it = it.next;
		}
	}
	
	/*
	* @param   nothing
	* @return  Total Amount of all items in Shopping Cart
	*/
	public double totalAmountPayable() {
		return this.total;
	}
	
	public static void main(String args[]) {
		ShoppingCart shopCart = new ShoppingCart();
		shopCart.add(1, "SkyBag", 1156.36, 1);
		shopCart.add(2, "Algo Book", 560.36, 1);
		shopCart.add(3, "Laptop", 32156.36, 1);
		shopCart.add(4, "Samsung S8", 55556.36, 1);
		shopCart.add(5, "iPhone", 105556.36, 1);
		
		shopCart.itemList();
		System.out.println(shopCart.totalAmountPayable());
		
		shopCart.changeQuantity(2, "-", 2);
		
		shopCart.itemList();
		System.out.println(shopCart.totalAmountPayable());
	}
}
