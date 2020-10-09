package entity;

import java.io.Serializable;

public class sv_mhPK implements Serializable{
	String sv;
	String mh;
	
	public String getSv() {
		return sv;
	}

	public void setSv(String sv) {
		this.sv = sv;
	}

	public String getMh() {
		return mh;
	}

	public void setMh(String mh) {
		this.mh = mh;
	}

	public int hashCode() {
        return (int)this.sv.hashCode()+(int)this.mh.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof sv_mhPK)) return false;
        sv_mhPK pk = (sv_mhPK) obj;
        return pk.sv == this.mh && pk.sv==this.sv;
    }

	@Override
	public String toString() {
		return "sv_mhPK [sv=" + sv + ", mh=" + mh + "]";
	}

	/**
	 * @param sv
	 * @param mh
	 */
	public sv_mhPK(String sv, String mh) {
		super();
		this.sv = sv;
		this.mh = mh;
	}

	/**
	 * 
	 */
	public sv_mhPK() {
		super();
	}
    
}