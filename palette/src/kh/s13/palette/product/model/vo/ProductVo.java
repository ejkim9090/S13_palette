package kh.s13.palette.product.model.vo;

import java.util.List;

import kh.s13.palette.review.model.vo.ReviewVo;

public class ProductVo {
	
//	PID       NOT NULL VARCHAR2(100) 
//	CID       NOT NULL NUMBER(2)     
//	PNAME     NOT NULL VARCHAR2(50)  
//	PIMG1     NOT NULL VARCHAR2(500) 
//	PIMG2     NOT NULL VARCHAR2(500) 
//	PPRICE    NOT NULL NUMBER        
//	PBENEFIT           VARCHAR2(200) 
//	PDELIVERY          VARCHAR2(200) 
//	PDETAIL            CLOB  
	
	private String pid;
	private int cid;
	private String pname;
	private String pimage1;
	private String pimage2;
	private int pprice;
	private String pbenefit;
	private String pdelivery;
	private String pdetail;
	
	public ProductVo() {
		super();
	}

	public ProductVo(String pid, int cid, String pname, String pimage1, String pimage2, int pprice, String pbenefit,
			String pdelivery, String pdetail) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pprice = pprice;
		this.pbenefit = pbenefit;
		this.pdelivery = pdelivery;
		this.pdetail = pdetail;
	}

	@Override
	public String toString() {
		return "ProductVo [pid=" + pid + ", cid=" + cid + ", pname=" + pname + ", pimage1=" + pimage1 + ", pimage2="
				+ pimage2 + ", pprice=" + pprice + ", pbenefit=" + pbenefit + ", pdelivery=" + pdelivery + ", pdetail="
				+ pdetail + "]";
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimage1() {
		return pimage1;
	}

	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPbenefit() {
		return pbenefit;
	}

	public void setPbenefit(String pbenefit) {
		this.pbenefit = pbenefit;
	}

	public String getPdelivery() {
		return pdelivery;
	}

	public void setPdelivery(String pdelivery) {
		this.pdelivery = pdelivery;
	}

	public String getPdetail() {
		return pdetail;
	}

	public void setPdetail(String pdetail) {
		this.pdetail = pdetail;
	}



	
}
