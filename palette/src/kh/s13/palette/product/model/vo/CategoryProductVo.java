package kh.s13.palette.product.model.vo;

public class CategoryProductVo {
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
	private String cname;
	private int cnt;
	private String pimg1;
	private String pname;
	private int pprice;
	
	
	
	public CategoryProductVo() {
		super();
	}



	public CategoryProductVo(String pid, String cname, int cnt, String pimg1, String pname, int pprice) {
		super();
		this.pid = pid;
		this.cname = cname;
		this.cnt = cnt;
		this.pimg1 = pimg1;
		this.pname = pname;
		this.pprice = pprice;
	}



	@Override
	public String toString() {
		return "CategoryProductVo [pid=" + pid + ", cname=" + cname + ", cnt=" + cnt + ", pimg1=" + pimg1 + ", pname="
				+ pname + ", pprice=" + pprice + "]";
	}



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public int getCnt() {
		return cnt;
	}



	public void setCnt(int cnt) {
		this.cnt = cnt;
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



	public int getPprice() {
		return pprice;
	}



	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	
	
	
}
