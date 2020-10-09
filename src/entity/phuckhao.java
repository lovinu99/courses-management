package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transaction;

import org.hibernate.Session;

import util.HibernateUtil;

@Entity
@Table(name = "phuckhao")
public class phuckhao {
	@Id
	@Column(name = "mssv")
	String mssv;
	@Column(name = "hoten")
	String hoten;
	@Column(name = "mon")
	String mon;
	@Column(name = "cotdiem")
	String cotdiem;
	@Column(name = "diemmongmuon")
	int diemmm;
	@Column(name = "lido")
	String lydo;
	@Column(name = "status")
	int status;
	/**
	 * @param mssv
	 * @param hoten
	 * @param mon
	 * @param cotdiem
	 * @param diemmm
	 * @param lydo
	 * @param status
	 */
	public phuckhao(String mssv, String hoten, String mon, String cotdiem, int diemmm, String lydo, int status) {
		super();
		this.mssv = mssv;
		this.hoten = hoten;
		this.mon = mon;
		this.cotdiem = cotdiem;
		this.diemmm = diemmm;
		this.lydo = lydo;
		this.status = status;
	}
	@Override
	public String toString() {
		return "phuckhao [mssv=" + mssv + ", hoten=" + hoten + ", mon=" + mon + ", cotdiem=" + cotdiem + ", diemmm="
				+ diemmm + ", lydo=" + lydo + ", status=" + status + "]";
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getMon() {
		return mon;
	}
	public void setMon(String mon) {
		this.mon = mon;
	}
	public String getCotdiem() {
		return cotdiem;
	}
	public void setCotdiem(String cotdiem) {
		this.cotdiem = cotdiem;
	}
	public int getDiemmm() {
		return diemmm;
	}
	public void setDiemmm(int diemmm) {
		this.diemmm = diemmm;
	}
	public String getLydo() {
		return lydo;
	}
	public void setLydo(String lydo) {
		this.lydo = lydo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public static void thempk(phuckhao pk) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		try {
			org.hibernate.Transaction tran = session.beginTransaction();
			session.saveOrUpdate(pk);
			tran.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			System.out.println("da them pk");
		}
	}
	/**
	 * 
	 */
	public phuckhao() {
		super();
	}
}
