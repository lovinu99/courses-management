import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

import org.hibernate.Session;

import entity.Lop;
import entity.MonHoc;
import entity.account;
import entity.phuckhao;
import entity.sinhvien;
import entity.sv_monhoc;
import util.HibernateUtil;

public class App {
	public static void main(String[] args) throws IOException {

//    	String  a = "17CTT3.csv";
//    	System.out.println(a);
//    	Lop.ThemLop(a);

//    	sinhvien.addsv("111111", "danh", "nữ","2155042","17CTT3");

//    	Lop a =  Lop.getlop("17CTT3");
//    	for (sinhvien sv : a.getDssv()) {
//			System.out.println(sv);
//		}
//    	
//    	String  a = "17CTT3tkb.csv";
//    	System.out.println(a);
//    	Lop.Themtkb(a);

    	Lop a =  Lop.getlop("17CTT4");
    	for (MonHoc mh : a.getDsmh()) {
			System.out.println(mh);
		}
//    	
//    	sv_monhoc.ame();

//    	sv_monhoc.themBangDiem("17CTT3-MH006.csv");
//    	sinhvien a  = sinhvien.getsv("1712310");
//    	System.out.println(a);
//    	for (sv_monhoc string : a.getDsdiem()) {
//			System.out.println(string);
//		}

//    	sv_monhoc.suadiem("1712310", "MH010", 9,9,9,9);
//    	String  s= account.getmk("1712310");
//    	System.out.println(s);
//    	account a = account.getacc("1712310");
//    	a.DoiMK("lovinu");

//    	phuckhao a = new phuckhao("111", "1111", "mh01", "gk", 10, "thich", 0);
//    	phuckhao.thempk(a);
//    	Session session = HibernateUtil.getSessionFactory().openSession();
//    	sv_monhoc.themBangDiem(session, "17CTT3-MH006.csv");
    	
//    	Session session =  HibernateUtil.getSessionFactory().openSession();
//    	MonHoc a =  session.get(MonHoc.class, "MH006");
//    	for (sv_monhoc aa: a.getDsdiem()) {
//			System.out.println(aa);
	}
}