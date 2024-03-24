package daoModel;

public class Info {
	private String tenDangNhap;
	private int diem;
	public Info() {
		super();
	}
	public Info(String tenDangNhap, int diem) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.diem = diem;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	@Override
	public String toString() {
		return "Info [tenDangNhap=" + tenDangNhap + ", diem=" + diem + "]";
	}
	
	
}
