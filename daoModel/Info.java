package daoModel;

public class Info {
	private String tenDangNhap;
	private String matKhau;
	private int diem;
	public Info() {
		super();
	}
	public Info(String tenDangNhap, String matKhau, int diem) {
		super();
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.diem = diem;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String tenDangNhap) {
		this.matKhau = matKhau;
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
