package samplepack;

public abstract class Library {
	
	private String branch;
	private String address;
	public final String NAME = "MyLibrary";
	

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNAME() {
		return NAME;
	}
	
	public abstract void acceptDetails();
}
