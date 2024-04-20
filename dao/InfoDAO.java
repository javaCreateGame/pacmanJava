package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import daoModel.Info;
import database.JDBCUtil;

public class InfoDAO implements DAOInterface<Info> {

	public static InfoDAO getInstance() {
		return new InfoDAO();
	}

	@Override
	public int insert(Info t) {
		int kq = 0;
		try {
			// Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Thuc thi cau lenh SQL
			String sql = "INSERT INTO info (tenDangNhap, matKhau, Diem)" +
					" VALUES (?, ?, ?)";
			
			// Buoc 3: Tao ra doi tuong statement
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getTenDangNhap());
			pst.setString(2, t.getMatKhau());
			pst.setLong(3, t.getDiem());
			
			kq = pst.executeUpdate();

			// Buoc 4:
			// System.out.println("Ban da thuc thi: " + sql);
			// System.out.println("Co " + kq + " dong bi thay doi");

			// Buoc 5: Ket thuc
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(Info t) {
		int kq = 0;
		try {
			// Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Thuc thi cau lenh SQL
			String sql = "UPDATE info " +
					" SET " +
					" Diem = ? " +
					" WHERE tenDangNhap = ?";
			
			// Buoc 3: Tao ra doi tuong statement
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setLong(1, t.getDiem());
			pst.setString(2, t.getTenDangNhap());
			
			kq = pst.executeUpdate();

			// Buoc 4:
			// System.out.println("Ban da thuc thi: " + sql);
			// System.out.println("Co " + kq + " dong bi thay doi");

			// Buoc 5: Ket thuc
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int updateScore(Info t, int score) {
		int kq = 0;
		try {
			// Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Thuc thi cau lenh SQL
			String sql = "UPDATE info " +
					" SET " +
					" Diem = ?" +
					" WHERE tenDangNhap = ? ";
			
			// Buoc 3: Tao ra doi tuong statement
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setLong(1, score);
			pst.setString(2, t.getTenDangNhap());
			
			kq = pst.executeUpdate();

			// Buoc 4:
			// System.out.println("Ban da thuc thi: " + sql);
			// System.out.println("Co " + kq + " dong bi thay doi");

			// Buoc 5: Ket thuc
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(Info t) {
		int kq = 0;
		try {
			// Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Thuc thi cau lenh SQL
			String sql = "DELETE from info " +
					"WHERE tenDangNhap = ? ";
			
			// Buoc 3: Tao ra doi tuong statement
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getTenDangNhap());
			
			
			System.out.println(sql);
			kq = pst.executeUpdate();

			// Buoc 4:
			// System.out.println("Ban da thuc thi: " + sql);
			// System.out.println("Co " + kq + " dong bi thay doi");

			// Buoc 5: Ket thuc
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<Info> selectAll() {
		ArrayList<Info> kq = new ArrayList<Info>();
		try {
			// Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement

			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * from info ";

			ResultSet rs = st.executeQuery(sql);

			// Buoc 4:
			// System.out.println("Ban da thuc thi: " + sql);
			while (rs.next()) {
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				int Diem = rs.getInt("Diem");
				Info info = new Info(tenDangNhap, matKhau, Diem);
				kq.add(info);
			}

			// Buoc 5: Ket thuc
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public Info selectByID(Info t) {
		Info kq = null;
		try {
			// Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Thuc thi cau lenh SQL
			String sql = "SELECT * from info WHERE tenDangNhap = ? ";
			
			// Buoc 3: Tao ra doi tuong statement
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, t.getTenDangNhap());

			ResultSet rs = pst.executeQuery();

			// Buoc 4:
			// System.out.println("Ban da thuc thi: " + sql);
			while (rs.next()) {
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				int Diem = rs.getInt("Diem");

				kq = new Info(tenDangNhap, matKhau, Diem);
			}

			// Buoc 5: Ket thuc
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<Info> selectByCondition(String condition) {
		ArrayList<Info> kq = new ArrayList<Info>();
		try {
			// Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtil.getConnection();

			// Buoc 2: Tao ra doi tuong statement

			Statement st = con.createStatement();

			// Buoc 3: Thuc thi cau lenh SQL
			String sql = "SELECT * from info WHERE " + condition;

			ResultSet rs = st.executeQuery(sql);

			// Buoc 4:
			// System.out.println("Ban da thuc thi: " + sql);
			while (rs.next()) {
				String tenDangNhap = rs.getString("tenDangNhap");
				String matKhau = rs.getString("matKhau");
				int Diem = rs.getInt("Diem");

				Info info = new Info(tenDangNhap, matKhau, Diem);
				kq.add(info);
			}

			// Buoc 5: Ket thuc
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}
