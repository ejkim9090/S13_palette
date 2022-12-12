package kh.s13.palette.review.model.vo;

public class ReviewImageVo {

//	RFILEPATH NOT NULL VARCHAR2(500) 
//	RNO       NOT NULL NUMBER  
	
	private String rfilepath;
	private int rno;
	
	
	public ReviewImageVo() {
		super();
	}

	public ReviewImageVo(String rfilepath, int rno) {
		super();
		this.rfilepath = rfilepath;
		this.rno = rno;
	}

	@Override
	public String toString() {
		return "ReviewImageVo [rfilepath=" + rfilepath + ", rno=" + rno + "]";
	}

	public String getRfilepath() {
		return rfilepath;
	}

	public void setRfilepath(String rfilepath) {
		this.rfilepath = rfilepath;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}
	
	
}
