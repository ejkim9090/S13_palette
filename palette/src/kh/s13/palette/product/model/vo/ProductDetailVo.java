package kh.s13.palette.product.model.vo;

public class ProductDetailVo {
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
	private String pimg1;
	private String pimg2;
	private String pprice;
	private String pbenefit;
	private String pdelivery;
	private String pdetail;
	
	public ProductDetailVo() {
		super();
	}
	public ProductDetailVo(String pid, int cid, String pname, String pimg1, String pimg2, String pprice, String pbenefit,
			String pdelivery, String pdetail) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.pimg1 = pimg1;
		this.pimg2 = pimg2;
		this.pprice = pprice;
		this.pbenefit = pbenefit;
		this.pdelivery = pdelivery;
		this.pdetail = pdetail;
	}

	@Override
	public String toString() {
		return "ProductVo [pid=" + pid + ", cid=" + cid + ", pname=" + pname + ", pimg1=" + pimg1 + ", pimg2=" + pimg2
				+ ", pprice=" + pprice + ", pbenefit=" + pbenefit + ", pdelivery=" + pdelivery + ", pdetail=길어서따로확인"
				+ "]";
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

	public String getPimg1() {
		return pimg1;
	}

	public void setPimg1(String pimg1) {
		this.pimg1 = pimg1;
	}

	public String getPimg2() {
		return pimg2;
	}

	public void setPimg2(String pimg2) {
		this.pimg2 = pimg2;
	}

	public String getPprice() {
		return pprice;
	}

	public void setPprice(String pprice) {
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
