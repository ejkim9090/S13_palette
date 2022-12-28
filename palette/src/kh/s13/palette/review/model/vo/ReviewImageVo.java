package kh.s13.palette.review.model.vo;

public class ReviewImageVo {

//	RNO       NOT NULL NUMBER  
//	RFILEPATH NOT NULL VARCHAR2(500) 
	
	private int rno;
	private String rfilepath;
	
	
	public ReviewImageVo() {
		super();
	}
	public ReviewImageVo(int rno, String rfilepath) {
		super();
		this.rno = rno;
		this.rfilepath = rfilepath;
	}
	@Override
	public String toString() {
		return "ReviewImageVo [rno=" + rno + ", rfilepath=" + rfilepath + "]";
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRfilepath() {
		return rfilepath;
	}
	public void setRfilepath(String rfilepath) {
		this.rfilepath = rfilepath;
	}
	
}
