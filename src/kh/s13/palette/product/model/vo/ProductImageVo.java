package kh.s13.palette.product.model.vo;

public class ProductImageVo {
	
//	PFILEPATH NOT NULL VARCHAR2(500) 
//	PID       NOT NULL VARCHAR2(100) 
	
	private String pfilepath;
	private String pid;
	
	
	public ProductImageVo() {
		super();
	}

	public ProductImageVo(String pfilepath, String pid) {
		super();
		this.pfilepath = pfilepath;
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "ProductImageVo [pfilepath=" + pfilepath + ", pid=" + pid + "]";
	}

	public String getPfilepath() {
		return pfilepath;
	}

	public void setPfilepath(String pfilepath) {
		this.pfilepath = pfilepath;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
}
