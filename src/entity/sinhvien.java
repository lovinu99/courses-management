package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.ManyToAny;

import com.mysql.fabric.xmlrpc.base.Data;

import util.HibernateUtil;

@Entity
@Table(name="sv")
public class sinhvien implements Serializable{
	@Id
	@Column(name="MSSV")
	String MSSV;
	
	@Column(name="ten")
	String Ten;
	
	@Column(name="GioiTinh")
	String gioitinh;
	
	@Column(name="CMND")
	String CMND;
	
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name="lop_MaLop")
	Lop lop;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "acc")
	account acc;
	
	@OneToMany(mappedBy = "sv", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<sv_monhoc> dsdiem;
	
	//
	
	
	public Set<sv_monhoc> getDsdiem() {
		return dsdiem;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public account getAcc() {
		return acc;
	}
	public void setAcc(account acc) {
		this.acc = acc;
	}
	public void setDsdiem(Set<sv_monhoc> dsdiem) {
		this.dsdiem = dsdiem;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	
	/**
	 * @param mSSV
	 * @param ten
	 * @param ngaySinh
	 * @param diaChi
	 * @param lop
	 * @param dSmonhoc
	 */
	/**
	 * 
	 */
	public sinhvien() {
		super();
	}
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
	@Override
	public String toString() {
		return "sinhvien [MSSV=" + MSSV + ", Ten=" + Ten + ", gioitinh=" + gioitinh + ", CMND=" + CMND + ", lop="+lop+ "]";
	}
	public static sinhvien getsv(String MSSV) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		sinhvien sv;
		try {
			sv = session.get(sinhvien.class, MSSV);
		} catch (Exception e) {
			System.out.println("loi lay sinh vien");
			return null;
			// TODO: handle exception
		}
		finally {
			session.close();
			System.out.println("done");
		}
		return sv;		
	}
	public static void addsv(String mssv, String ten, String gt, String cmnd, String lop) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction tran = session.beginTransaction();
			Lop l = session.get(Lop.class, lop);
			System.out.println(l);
			sinhvien sv = new sinhvien( mssv,  ten,  gt,  cmnd,l);
			System.out.println(sv);
			session.save(sv);
			tran.commit();
		} catch (Exception e) {
			System.out.println("loi them sv");
			// TODO: handle exception
		}
		finally {
			System.out.println("da them sv");
			session.close();
		}
	}
	public Lop getlop() {
		return lop;
	}
	/**
	 * @param mSSV
	 * @param ten
	 * @param gioitinh
	 * @param cMND
	 */
	public sinhvien(String mSSV, String ten, String gioitinh, String cMND) {
		super();
		MSSV = mSSV;
		Ten = ten;
		this.gioitinh = gioitinh;
		CMND = cMND;
		lop=null;
		dsdiem=null;
		acc = null;
	}
	/**
	 * @param mSSV
	 * @param ten
	 * @param gioitinh
	 * @param cMND
	 * @param lop
	 * @param diem
	 */
	public sinhvien(String mSSV, String ten, String gioitinh, String cMND, Lop lop) {
		super();
		MSSV = mSSV;
		Ten = ten;
		this.gioitinh = gioitinh;
		CMND = cMND;
		this.lop = lop;
		dsdiem=null;
		acc=null;
	}
}