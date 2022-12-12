package kh.s13.palette.review.model.vo;

import java.sql.Timestamp;
import java.util.List;

public class ReviewVo {

//	RNO      NOT NULL NUMBER              
//	PID      NOT NULL VARCHAR2(100)       
//	MID      NOT NULL VARCHAR2(50)        
//	RCONTENT NOT NULL VARCHAR2(2000 CHAR) 
//	RDATE             TIMESTAMP(6)  
	
	private int rno;
	private String pid;
	private String mid;
	private String rcontent;
	private Timestamp rdate;
	
	private List<ReviewImageVo> rimagelist;
	private List<ReviewLikeVo> rlikelist;
	
	
	
	public ReviewVo() {
		super();
	}

	public ReviewVo(int rno, String pid, String mid, String rcontent, Timestamp rdate, List<ReviewImageVo> rimagelist,
			List<ReviewLikeVo> rlikelist) {
		super();
		this.rno = rno;
		this.pid = pid;
		this.mid = mid;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.rimagelist = rimagelist;
		this.rlikelist = rlikelist;
	}

	@Override
	public String toString() {
		return "ReviewVo [rno=" + rno + ", pid=" + pid + ", mid=" + mid + ", rcontent=" + rcontent + ", rdate=" + rdate
				+ ", rimagelist=" + rimagelist + ", rlikelist=" + rlikelist + "]";
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}

	public List<ReviewImageVo> getRimagelist() {
		return rimagelist;
	}

	public void setRimagelist(List<ReviewImageVo> rimagelist) {
		this.rimagelist = rimagelist;
	}

	public List<ReviewLikeVo> getRlikelist() {
		return rlikelist;
	}

	public void setRlikelist(List<ReviewLikeVo> rlikelist) {
		this.rlikelist = rlikelist;
	}
	
}
