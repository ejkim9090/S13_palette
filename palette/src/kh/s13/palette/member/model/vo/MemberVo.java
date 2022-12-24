package kh.s13.palette.member.model.vo;

import java.sql.Timestamp;

public class MemberVo {

//	MID       NOT NULL VARCHAR2(50)  
//	MPW       NOT NULL VARCHAR2(50)  
//	MNAME     NOT NULL VARCHAR2(100) 
//	MEMAIL    NOT NULL VARCHAR2(100) 
//	MADDR1    NOT NULL VARCHAR2(100) 
//	MADDR2    NOT NULL VARCHAR2(300) 
//	MGENDER            CHAR(1)       
//	MBYEAR             NUMBER(4)     
//	MBMONTH            NUMBER(2)     
//	MBDATE             NUMBER(2)     
//	MCONSENT  NOT NULL NUMBER(1)     
//	MENTRANCE NOT NULL TIMESTAMP(6)    
	
	private String mid;
	private String mpw;
	private String mname;
	private String memail;
	private String maddr1;
	private String maddr2;
	private String mgender;
	private int mbyear;
	private int mbmonth;
	private int mbdate;
	private int mconsent;
	private Timestamp mentrance;
	
	
	
	public MemberVo() {
		super();
	}
	public MemberVo(String mid, String mpw, String mname, String memail, String maddr1, String maddr2, String mgender,
			int mbyear, int mbmonth, int mbdate, int mconsent, Timestamp mentrance) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.memail = memail;
		this.maddr1 = maddr1;
		this.maddr2 = maddr2;
		this.mgender = mgender;
		this.mbyear = mbyear;
		this.mbmonth = mbmonth;
		this.mbdate = mbdate;
		this.mconsent = mconsent;
		this.mentrance = mentrance;
	}
	@Override
	public String toString() {
		return "MemberVo [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", memail=" + memail + ", maddr1="
				+ maddr1 + ", maddr2=" + maddr2 + ", mgender=" + mgender + ", mbyear=" + mbyear + ", mbmonth=" + mbmonth
				+ ", mbdate=" + mbdate + ", mconsent=" + mconsent + ", mentrance=" + mentrance + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMaddr1() {
		return maddr1;
	}
	public void setMaddr1(String maddr1) {
		this.maddr1 = maddr1;
	}
	public String getMaddr2() {
		return maddr2;
	}
	public void setMaddr2(String maddr2) {
		this.maddr2 = maddr2;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public int getMbyear() {
		return mbyear;
	}
	public void setMbyear(int mbyear) {
		this.mbyear = mbyear;
	}
	public int getMbmonth() {
		return mbmonth;
	}
	public void setMbmonth(int mbmonth) {
		this.mbmonth = mbmonth;
	}
	public int getMbdate() {
		return mbdate;
	}
	public void setMbdate(int mbdate) {
		this.mbdate = mbdate;
	}
	public int getMconsent() {
		return mconsent;
	}
	public void setMconsent(int mconsent) {
		this.mconsent = mconsent;
	}
	public Timestamp getMentrance() {
		return mentrance;
	}
	public void setMentrance(Timestamp mentrance) {
		this.mentrance = mentrance;
	}
	
	

}
