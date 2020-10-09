package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transaction;

import org.hibernate.Session;

import net.bytebuddy.asm.Advice.This;
import util.HibernateUtil;

@Entity
@Table(name = "acc")
public class account implements Serializable{
	@Id
	@OneToOne
	@JoinColumn(name="tk")
	sinhvien acc;
	@Column(name = "mk")
	String mk;
	public sinhvien getAcc() {
		return acc;
	}
	public void setAcc(sinhvien acc) {
		this.acc = acc;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public static String getmk(Session session, String tk) {
		try {
			String mk = session.get(account.class, tk).getMk();
			if(mk!=null)
				return mk;
			else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static account getacc(Session session, String tk) {
		try {
			return session.get(account.class, tk);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public void DoiMK(Session session, String newmk) {
		
		try {
			account temp =this;
			temp.mk= newmk;
			org.hibernate.Transaction tran = session.beginTransaction();
			session.update(temp);
			tran.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	public String toString() {
		return "account [tk=" + acc + ", mk=" + mk + "]";
	}
	/**
	 * @param acc
	 * @param mk
	 */
	public account(sinhvien acc, String mk) {
		super();
		this.acc = acc;
		this.mk = mk;
	}
	/**
	 * 
	 */
	public account() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
}
