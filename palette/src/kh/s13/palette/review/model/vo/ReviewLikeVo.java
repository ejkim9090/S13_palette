package kh.s13.palette.review.model.vo;

public class ReviewLikeVo {

//	RNO NOT NULL NUMBER       
//	MID NOT NULL VARCHAR2(50) 
	
	private int rno;
	private String mid;
	
	
	public ReviewLikeVo() {
		super();
	}
	public ReviewLikeVo(int rno, String mid) {
		super();
		this.rno = rno;
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "ReviewLikeVo [rno=" + rno + ", mid=" + mid + "]";
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
}
