package repository.imp;

import com.sun.org.apache.xerces.internal.impl.dv.XSSimpleType;
import model.BenhAn;
import model.BenhNhan;
import repository.IBenhNhanRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanhRepository implements IBenhNhanRepository {

    public static final String INSERT_INTO_BENHNHAN = "INSERT INTO BenhNhan VALUES(?,?,?,?,?,?)";
    public static final String UPDATE_BENH_NHAN = "update BenhNhan set tenBenhNhan = ?,ngayNhapVien = ?,ngayRaVien=?,lyDo = ? where maBenhAn =? and maBenhNhan = ?; ";
    public static final String DELETE_BENH_NHAN = "DELETE FROM BenhNhan WHERE maBenhNhan=? and maBenhAn=?";
    public static final String FIND_BY_ID = "select * from BenhNhan where maBenhNhan=? and maBenhAn=?";
    public static final String SELECT_FROM_BENH_NHAN = "SELECT * FROM BenhNhan";
    public static final String SELECT_FROM_BENH_AN = "SELECT * FROM BenhAn  WHERE maBenhAn= ?";
    public static final String FROM_BENH_AN = "SELECT * FROM BenhAn";
    public static final String FIND_BY_NAME = "SELECT * FROM BenhNhan WHERE tenBenhNhan =?";

    @Override
    public void insert(BenhNhan benhNhan) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_BENHNHAN);
            statement.setString(1,benhNhan.getMaBenhAn());
            statement.setString(2,benhNhan.getMaBenhNhan());
            statement.setString(3,benhNhan.getTenBenhNhan());
            statement.setString(4,benhNhan.getNgayNhapVien());
            statement.setString(5,benhNhan.getNgayRaVien());
            statement.setString(6,benhNhan.getLiDo());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(BenhNhan benhNhan) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BENH_NHAN);
            statement.setString(1,benhNhan.getTenBenhNhan());
            statement.setString(2,benhNhan.getNgayNhapVien());
            statement.setString(3,benhNhan.getNgayRaVien());
            statement.setString(4,benhNhan.getLiDo());
            statement.setString(5,benhNhan.getMaBenhAn());
            statement.setString(6,benhNhan.getMaBenhNhan());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(String maBenhNhan, String maBenhAn) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement  statement = connection.prepareStatement(DELETE_BENH_NHAN);
            statement.setString(1,maBenhNhan);
            statement.setString(2,maBenhAn);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public BenhNhan findById(String maBenhNhan, String maBenhAn) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setString(1,maBenhNhan);
            statement.setString(2,maBenhAn);
            ResultSet resultSet= statement.executeQuery();
            BenhNhan benhNhan;
            while (resultSet.next()){
                String maBA = resultSet.getString("maBenhAn");
                String maBN = resultSet.getString("maBenhNhan");
                String tenBN = resultSet.getString("tenBenhNhan");
                String ngayNhapVien = resultSet.getString("ngayNhapVien");
                String ngayXuatVien = resultSet.getString("ngayRaVien");
                String lyDo = resultSet.getString("lyDo");
                benhNhan = new BenhNhan(maBN,tenBN,ngayNhapVien,ngayXuatVien,lyDo,maBA);
                return benhNhan;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<BenhNhan> getAll() {
        List<BenhNhan> benhNhanList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(SELECT_FROM_BENH_NHAN);
                resultSet= statement.executeQuery();
                BenhNhan benhNhan = null;
                while (resultSet.next()){
                    String maBA = resultSet.getString("maBenhAn");
                    String maBN = resultSet.getString("maBenhNhan");
                    String tenBN = resultSet.getString("tenBenhNhan");
                    String ngayNhapVien = resultSet.getString("ngayNhapVien");
                    String ngayXuatVien = resultSet.getString("ngayRaVien");
                    String lyDo = resultSet.getString("lyDo");
                    benhNhan = new BenhNhan(maBN,tenBN,ngayNhapVien,ngayXuatVien,lyDo,maBA);
                    benhNhanList.add(benhNhan);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }


        return benhNhanList;
    }

    @Override
    public List<BenhAn> getAllBenhAn() {
        List<BenhAn> benhAnList = new ArrayList<>();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(FROM_BENH_AN);
                resultSet= statement.executeQuery();
                BenhAn benhAn = null;
                while (resultSet.next()){
                    String maBA = resultSet.getString("maBenhAn");
                    String tenBA = resultSet.getString("tenBenhAn");
                    benhAn = new BenhAn(maBA,tenBA);
                    benhAnList.add(benhAn);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        return benhAnList;
    }

    @Override
    public BenhAn getBenhAn(String maBenhAn) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_BENH_AN);
            statement.setString(1,maBenhAn);
            ResultSet resultSet = statement.executeQuery();
            BenhAn benhAn;
            while (resultSet.next()){
                String maBenhAnX = resultSet.getString("maBenhAn");
                String tenBenhAn = resultSet.getString("tenBenhAn");
                benhAn = new BenhAn(maBenhAn,tenBenhAn);
                return benhAn;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static BenhNhan findByName(String name) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
            statement.setString(1,name);
            ResultSet resultSet= statement.executeQuery();
            BenhNhan benhNhan;
            while (resultSet.next()){
                String maBA = resultSet.getString("maBenhAn");
                String maBN = resultSet.getString("maBenhNhan");
                String tenBN = resultSet.getString("tenBenhNhan");
                String ngayNhapVien = resultSet.getString("ngayNhapVien");
                String ngayXuatVien = resultSet.getString("ngayRaVien");
                String lyDo = resultSet.getString("lyDo");
                benhNhan = new BenhNhan(maBN,tenBN,ngayNhapVien,ngayXuatVien,lyDo,maBA);
                return benhNhan;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
