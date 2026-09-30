package cmsc203;

public class Movie {
	private String title;

	private String rating;

	private int soldTickets;

	public Movie ()

	{

	title = "";

	rating = "";

	soldTickets = 0;

	}

	public Movie (Movie m)

	{

	title = m.title;

	rating = m.rating;

	soldTickets = m.soldTickets;

	}

	public Movie(String title, String rating, int soldTickets) {

	this.title = title;

	this.rating = rating;

	this.soldTickets = soldTickets;

	}

	public String getTitle() {

	return title;

	}

	public void setTitle(String title) {

	this.title = title;

	}
}
