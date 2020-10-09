package entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JTable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

@Entity
@Table(name = "lop")
public class Lop {

	@Id
	@Column(name = "MaLop")
	String malop;
	@Column(name = "TenLop")
	String ten;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "lop_MaLop")
	Set<sinhvien> dssv;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "lop_Malop")
	Set<MonHoc> dsmh;

	/**
	 * 
	 */
	public Lop() {
		super();
	}

	/**
	 * @param malop
	 * @param ten
	 */
	public Lop(String malop, String ten) {
		super();
		this.malop = malop;
		this.ten = ten;
		this.dsmh = null;
		this.dssv = null;
	}

	@Override
	public String toString() {
		return "Lop [malop=" + malop + ", ten=" + ten + "]";
	}
	
	public Set<sinhvien> getDssv() {
		return dssv;
	}

	public void setDssv(Set<sinhvien> dssv) {
		this.dssv = dssv;
	}

	public Set<MonHoc> getDsmh() {
		return dsmh;
	}

	public void setDsmh(Set<MonHoc> dsmh) {
		this.dsmh = dsmh;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public static Lop getlop(String MaLop) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return session.get(Lop.class, MaLop);
		} catch (Exception e) {
			System.out.println("lay lop k dc");
			// TODO: handle exception
		} finally {
			session.close();
			System.out.println("done");
		}
		return null;
	}

	public void getdsmh() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			for (MonHoc monHoc : session.get(Lop.class, this.malop).dsmh) {
				System.out.println(monHoc);
			}

		} catch (Exception e) {
			System.out.println("lay tkb loi");
			// TODO: handle exception
		} finally {
			session.close();
		}
	}

	public static Vector<Vector<String>> toJtable(Session session, String malop) {
		Vector<String> column = new Vector<String>();
		column.add("MSSV");
		column.add("Họ Tên");
		column.add("Giới tính");
		column.add("CMND");
		Vector<Vector<String>> data =  new Vector<Vector<String>>();
		try {
			Lop a =  session.get(Lop.class,malop);
			int i=0;
			for (sinhvien sv : a.dssv) {
				Vector<String> temp =  new Vector<String>();
				temp.add(sv.MSSV);
				temp.add(sv.Ten);
				temp.add(sv.gioitinh);
				temp.add(sv.CMND);
				data.add(temp);
				System.out.println(temp);
			}
			data.add(0, column);
			return data;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	public static Lop getLop(String malop) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return session.get(Lop.class, malop);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi lay lop");
		}
		finally {
			session.close();
		}
		return null;
	}
	
	public static void Themtkb(Session session,String filename) throws IOException {
		session.clear();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),StandardCharsets.UTF_8));
		reader.readLine();
		String row;
		String name =  String.valueOf(filename.split(Pattern.quote("t"))[0]);
		try {
			Lop l = session.get(Lop.class, name);
			System.out.println(l);
			// da ton tai lop hoc -> update
			if(l!=null) {
				while((row=reader.readLine())!=null) {
					String[] data =  row.split(",");
					l.dsmh.add(new MonHoc(data[0],data[1],data[2], l));
				}
				// them mon hoc vao cac sinh vien thuoc lop duoc chon
				for (sinhvien sv : l.dssv) {
					for (MonHoc mh : l.dsmh) {
						sv.dsdiem.add(new sv_monhoc(0,0,0,0,sv, mh));
					}
				}
				reader.close();			
				Transaction tran = session.beginTransaction();
				session.update(l);
				tran.commit();		
			}
			else {
				l = new Lop(name, name);
				System.out.println(l);
				while((row=reader.readLine())!=null) {
					String[] data =  row.split(",");
					l.dsmh.add(new MonHoc(data[0],data[1],data[2], l));
				}
				for (sinhvien sv : l.dssv) {
					// them cac mon hoc cua lop vao cho sv
					for (MonHoc mh : l.dsmh) {
						sv.dsdiem.add(new sv_monhoc(0,0,0,0,sv, mh));
					}
					// tao tai khoan cho sv
					sv.acc= new account(sv, sv.MSSV);
				}
				reader.close();			
				Transaction tran = session.beginTransaction();
				session.save(l);
				tran.commit();	
			}
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	
	public static void ThemLop(Session session,String filename) throws IOException {
		session.clear();
		// ddojc file
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),StandardCharsets.UTF_8));
		// tao object
		String name = String.valueOf(filename.split(Pattern.quote("."))[0]);
		Lop Lopmoi = new Lop(name, name);
		String row;
		// them dssv vao
		Lopmoi.dssv = new HashSet<sinhvien>();
		reader.readLine();
		while ((row = reader.readLine()) != null) {
			String[] data = row.split(",");
			Lopmoi.dssv.add(new sinhvien(data[0], data[1], data[2], data[3], Lopmoi));
		}
		for (sinhvien sv : Lopmoi.dssv) {
			sv.acc= new account(sv, sv.MSSV);
		}
		reader.close();
		// them vao db
		Transaction tran = session.beginTransaction();
		try {
			session.save(Lopmoi);
			tran.commit();

		} catch (Exception e) {
			System.out.println("loi them lop");
		} finally {
			System.out.println("da them lop moi");
		}
	}
}
