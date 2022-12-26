package kh.s13.palette.product.model.vo;

public class MyProductWishVo {
	
//	MID NOT NULL VARCHAR2(50)  
//	PID NOT NULL VARCHAR2(100) 
	
	private String pid;
	private String pimg1;
	private String pname;
	private String pprice;
	
	
	
	public MyProductWishVo() {
		super();
	}
	public MyProductWishVo(String pid, String pimg1, String pname, String pprice) {
		super();
		this.pid = pid;
		this.pimg1 = pimg1;
		this.pname = pname;
		this.pprice = pprice;
	}
	@Override
	public String toString() {
		return "MyProductWishVo [pid=" + pid + ", pimg1=" + pimg1 + ", pname=" + pname + ", pprice=" + pprice + "]";
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
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
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	
	
	
	
	
	
}
