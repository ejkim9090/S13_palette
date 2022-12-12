package kh.s13.palette.product.model.vo;

public class ProductWishVo {

//	MID NOT NULL VARCHAR2(50)  
//	PID NOT NULL VARCHAR2(100) 
	
	private String mid;
	private String pid;
	
	
	public ProductWishVo() {
		super();
	}

	public ProductWishVo(String mid, String pid) {
		super();
		this.mid = mid;
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "ProductWishVo [mid=" + mid + ", pid=" + pid + "]";
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
}
