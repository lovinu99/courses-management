package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="monhoc")
public class MonHoc implements Serializable {
	@Id
	@Column(name="MaMH")
	String maMH;
	@Column(name="TenMonHoc")
	String tenmh;
	@Column(name="PhongHoc")
	String phong;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="lop_MaLop")
	Lop lop;
	
	@OneToMany(mappedBy =  "mh", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<sv_monhoc> dsdiem;
	
	
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	public Set<sv_monhoc> getDsdiem() {
		return dsdiem;
	}
	public void setDsdiem(Set<sv_monhoc> dsdiem) {
		this.dsdiem = dsdiem;
	}
	public Lop getLop() {
		return lop;
	}
	public void setLop(Lop lop) {
		this.lop = lop;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getTenmh() {
		return tenmh;
	}
	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}
	/**
	 * @param maMH
	 * @param tenmh
	 */
	public MonHoc(String maMH, String tenmh) {
		super();
		this.maMH = maMH;
		this.tenmh = tenmh;
		dsdiem=null;
	}
	/**
	 * 
	 */
	public MonHoc() {
		super();
	}

	@Override
	public String toString() {
		return "MonHoc [maMH=" + maMH + ", tenmh=" + tenmh + ", phong=" + phong + ", lop=" + lop + "]";
	}
	/**
	 * @param maMH
	 * @param tenmh
	 * @param phong
	 * @param lop
	 */
	public MonHoc(String maMH, String tenmh, String phong, Lop lop) {
		super();
		this.maMH = maMH;
		this.tenmh = tenmh;
		this.phong = phong;
		this.lop = lop;
		dsdiem=null;
	}
	
}
