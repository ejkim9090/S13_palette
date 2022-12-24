package kh.s13.palette.review.model.vo;

import java.util.List;

public class MyReviewVo {

//		RNO      NOT NULL NUMBER              
//		PID      NOT NULL VARCHAR2(100)       
//		MID      NOT NULL VARCHAR2(50)        
//		RCONTENT NOT NULL VARCHAR2(2000 CHAR) 
//		RDATE             TIMESTAMP(6)  
		
		private int rno;
		private String pimg1;
		private String pname;
		private String rcontent;
		private String rdate;
		
		private List<ReviewImageVo> rimagelist;

		
		
		public MyReviewVo() {
			super();
		}

		public MyReviewVo(int rno, String pimg1, String pname, String rcontent, String rdate,
				List<ReviewImageVo> rimagelist) {
			super();
			this.rno = rno;
			this.pimg1 = pimg1;
			this.pname = pname;
			this.rcontent = rcontent;
			this.rdate = rdate;
			this.rimagelist = rimagelist;
		}

		@Override
		public String toString() {
			return "MyReviewVo [rno=" + rno + ", pimg1=" + pimg1 + ", pname=" + pname + ", rcontent=" + rcontent
					+ ", rdate=" + rdate + ", rimagelist=" + rimagelist + "]";
		}

		public int getRno() {
			return rno;
		}

		public void setRno(int rno) {
			this.rno = rno;
		}

		public String getPimg1() {
			return pimg1;
		}

		public void setPimg1(String pimg1) {
			this.pimg1 = pimg1;
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
