package model;

public class Feedback {
	String name, feed;

	public Feedback(String name, String feed) {
		this.name = name;
		this.feed = feed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}
	
}
