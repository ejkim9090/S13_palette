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
//	PINTRO             VARCHAR2(4000) 
	
	private String pid;
	private int cid;
	private String pname;
	private String pimage1;
	private String pimage2;
	private int pprice;
	private String pbenefit;
	private String pdelivery;
	private String pintro;
	
	private List<ProductImageVo> pimagelist;
	private List<ProductDetailVo> pdetaillist;
	private List<ProductWishVo> pwhishlist;
	private List<ReviewVo> reviewlist;
	
	
	public ProductVo() {
		super();
	}

	public ProductVo(String pid, int cid, String pname, String pimage1, String pimage2, int pprice, String pbenefit,
			String pdelivery, String pintro, List<ProductImageVo> pimagelist, List<ProductDetailVo> pdetaillist,
			List<ProductWishVo> pwhishlist, List<ReviewVo> reviewlist) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.pprice = pprice;
		this.pbenefit = pbenefit;
		this.pdelivery = pdelivery;
		this.pintro = pintro;
		this.pimagelist = pimagelist;
		this.pdetaillist = pdetaillist;
		this.pwhishlist = pwhishlist;
		this.reviewlist = reviewlist;
	}

	@Override
	public String toString() {
		return "ProductVo [pid=" + pid + ", cid=" + cid + ", pname=" + pname + ", pimage1=" + pimage1 + ", pimage2="
				+ pimage2 + ", pprice=" + pprice + ", pbenefit=" + pbenefit + ", pdelivery=" + pdelivery + ", pintro="
				+ pintro + ", pimagelist=" + pimagelist + ", pdetaillist=" + pdetaillist + ", pwhishlist=" + pwhishlist
				+ ", reviewlist=" + reviewlist + "]";
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

	public String getPintro() {
		return pintro;
	}

	public void setPintro(String pintro) {
		this.pintro = pintro;
	}

	public List<ProductImageVo> getPimagelist() {
		return pimagelist;
	}

	public void setPimagelist(List<ProductImageVo> pimagelist) {
		this.pimagelist = pimagelist;
	}

	public List<ProductDetailVo> getPdetaillist() {
		return pdetaillist;
	}

	public void setPdetaillist(List<ProductDetailVo> pdetaillist) {
		this.pdetaillist = pdetaillist;
	}

	public List<ProductWishVo> getPwhishlist() {
		return pwhishlist;
	}

	public void setPwhishlist(List<ProductWishVo> pwhishlist) {
		this.pwhishlist = pwhishlist;
	}

	public List<ReviewVo> getReviewlist() {
		return reviewlist;
	}

	public void setReviewlist(List<ReviewVo> reviewlist) {
		this.reviewlist = reviewlist;
	}
	
	
}
