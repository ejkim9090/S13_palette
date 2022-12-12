package kh.s13.palette.product.model.vo;

public class CategoryVo {
	
//	CID    NOT NULL NUMBER(2)     
//	CNAME  NOT NULL VARCHAR2(100) 
//	CDEPTH NOT NULL NUMBER(1)     
//	CPID            NUMBER(2)    
	
	private int cid;
	private String cname;
	private int cdepth;
	private int cpid;
	
	public CategoryVo() {
		super();
	}

	public CategoryVo(int cid, String cname, int cdepth, int cpid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdepth = cdepth;
		this.cpid = cpid;
	}

	@Override
	public String toString() {
		return "CategoryVo [cid=" + cid + ", cname=" + cname + ", cdepth=" + cdepth + ", cpid=" + cpid + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCdepth() {
		return cdepth;
	}

	public void setCdepth(int cdepth) {
		this.cdepth = cdepth;
	}

	public int getCpid() {
		return cpid;
	}

	public void setCpid(int cpid) {
		this.cpid = cpid;
	}
	
	
}
