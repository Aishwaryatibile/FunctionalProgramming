package Programming;

public class Book {

	private String name;
	private String autour;
	private Double cost;

	public Book() {
		super();
	}

	public Book(String name, String autour, double cost) {
		super();
		this.name = name;
		this.autour = autour;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutour() {
		return autour;
	}

	public void setAutour(String autour) {
		this.autour = autour;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", autour=" + autour + ", cost=" + cost + "]";
	}

}
