package entity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transaction;

import org.hibernate.Session;

import util.HibernateUtil;

@Entity
@Table(name = "sv_monhoc")
@IdClass(sv_mhPK.class)
public class sv_monhoc {
	@Column(name = "gk")
	int gk;
	@Column(name = "ck")
	int ck;
	@Column(name = "khac")
	int khac;
	@Column(name = "tk")
	int tk;
	@Id
	@ManyToOne
	@JoinColumn(name = "sv_MSSV", referencedColumnName = "MSSV")
	sinhvien sv;
	@Id
	@ManyToOne
	@JoinColumn(name = "monhoc_MaMH", referencedColumnName = "maMH")
	MonHoc mh;

	public int getGk() {
		return gk;
	}

	public void setGk(int gk) {
		this.gk = gk;
	}

	public int getCk() {
		return ck;
	}

	public void setCk(int ck) {
		this.ck = ck;
	}

	public int getKhac() {
		return khac;
	}

	public void setKhac(int khac) {
		this.khac = khac;
	}

	public int getTk() {
		return tk;
	}

	public void setTk(int tk) {
		this.tk = tk;
	}

	public sinhvien getSv() {
		return sv;
	}

	public void setSv(sinhvien sv) {
		this.sv = sv;
	}

	public MonHoc getMh() {
		return mh;
	}

	public void setMh(MonHoc mh) {
		this.mh = mh;
	}

	@Override
	public String toString() {
		return "sv_monhoc [mh=" + mh.tenmh + ", gk=" + gk + ", ck=" + ck + ", khac=" + khac + ", tk=" + tk + "]";
	}
	public static void suadiem(String mssv,String mamh, int gk, int ck, int khac, int tk) {
		Session session =  HibernateUtil.getSessionFactory().openSession();
		try {
			sv_monhoc a = session.get(sv_monhoc.class, new sv_mhPK(mssv, mamh));
			a.gk=gk;
			a.ck=ck;
			a.khac=khac;
			a.tk=tk;
			org.hibernate.Transaction tran = session.beginTransaction();
			session.saveOrUpdate(a);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
	}
	public static void themBangDiem(Session session,String filename) throws IOException {
		session.clear();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),StandardCharsets.UTF_8));
		// lay thong tin lop + mon hoc
		String[] filedata = filename.split("-");
		reader.readLine();
		// doc file + them du lieu
		try {
			org.hibernate.Transaction tran = session.beginTransaction();
			MonHoc monhoc = session.get(MonHoc.class, String.valueOf(filedata[1].split(Pattern.quote("."))[0]));
			String row= null;
			while((row=reader.readLine())!=null) {
				String[] data=row.split(",");
				sv_monhoc temp  = session.get(sv_monhoc.class,new sv_mhPK(data[0], monhoc.getMaMH()));
				temp.setGk(Integer.valueOf(data[1]));
				temp.setCk(Integer.valueOf(data[2]));
				temp.setKhac(Integer.valueOf(data[3]));
				temp.setTk(Integer.valueOf(data[4]));
				session.update(temp);
			}
			tran.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @param gk
	 * @param ck
	 * @param khac
	 * @param tk
	 */
	public sv_monhoc(int gk, int ck, int khac, int tk) {
		super();
		this.gk = gk;
		this.ck = ck;
		this.khac = khac;
		this.tk = tk;
		sv = null;
		mh = null;
	}

	/**
	 * 
	 */
	public sv_monhoc() {
		super();
	}

	/**
	 * @param gk
	 * @param ck
	 * @param khac
	 * @param tk
	 * @param sv
	 * @param mh
	 */
	public sv_monhoc(int gk, int ck, int khac, int tk, sinhvien sv, MonHoc mh) {
		super();
		this.gk = gk;
		this.ck = ck;
		this.khac = khac;
		this.tk = tk;
		this.sv = sv;
		this.mh = mh;
	}
}