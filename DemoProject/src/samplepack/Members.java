package samplepack;

public abstract class Members {
	private int memberId;
	private String memberName;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public abstract void getMemberDetails(int id, String name);
	public abstract void showMemberDetails();
}
