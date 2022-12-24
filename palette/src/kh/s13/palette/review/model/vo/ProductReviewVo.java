package kh.s13.palette.review.model.vo;

import java.util.List;

public class ProductReviewVo {
	
//	RNO      NOT NULL NUMBER              
//	PID      NOT NULL VARCHAR2(100)       
//	MID      NOT NULL VARCHAR2(50)        
//	RCONTENT NOT NULL VARCHAR2(2000 CHAR) 
//	RDATE             TIMESTAMP(6)  
	
	private int rno;
	private String mname;
	private String pname;
	private String rcontent;
	private String rdate;
	
	private List<ReviewImageVo> rimagelist;

	
	
	
	public ProductReviewVo() {
		super();
	}

	public ProductReviewVo(int rno, String mname, String pname, String rcontent, String rdate,
			List<ReviewImageVo> rimagelist) {
		super();
		this.rno = rno;
		this.mname = mname;
		this.pname = pname;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rimagelist = rimagelist;
	}

	@Override
	public String toString() {
		return "ProductReviewVo [rno=" + rno + ", mname=" + mname + ", pname=" + pname + ", rcontent=" + rcontent
				+ ", rdate=" + rdate + ", rimagelist=" + rimagelist + "]";
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public List<ReviewImageVo> getRimagelist() {
		return rimagelist;
	}

	public void setRimagelist(List<ReviewImageVo> rimagelist) {
		this.rimagelist = rimagelist;
	}
	
	
	
}
