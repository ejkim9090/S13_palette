package kh.s13.palette.product.model.vo;

public class ProductDetailVo {
	
//	PDETAILNAME    NOT NULL VARCHAR2(200)  
//	PID            NOT NULL VARCHAR2(100)  
//	PDETAILCONTENT          VARCHAR2(4000) 

	private String pdetailname;
	private String pid;
	private String pdetailcontent;
	
	
	
	public ProductDetailVo() {
		super();
	}

	public ProductDetailVo(String pdetailname, String pid, String pdetailcontent) {
		super();
		this.pdetailname = pdetailname;
		this.pid = pid;
		this.pdetailcontent = pdetailcontent;
	}

	@Override
	public String toString() {
		return "ProductDetailVo [pdetailname=" + pdetailname + ", pid=" + pid + ", pdetailcontent=" + pdetailcontent
				+ "]";
	}

	public String getPdetailname() {
		return pdetailname;
	}

	public void setPdetailname(String pdetailname) {
		this.pdetailname = pdetailname;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPdetailcontent() {
		return pdetailcontent;
	}

	public void setPdetailcontent(String pdetailcontent) {
		this.pdetailcontent = pdetailcontent;
	}
	
	
	
}
