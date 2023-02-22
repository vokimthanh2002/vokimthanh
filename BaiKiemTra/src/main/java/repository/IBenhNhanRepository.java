package repository;

import model.BenhAn;
import model.BenhNhan;

import java.util.List;

public interface IBenhNhanRepository {
    void insert(BenhNhan benhNhan);
    void update(BenhNhan benhNhan);
    void deleteById(String maBenhNhan,String maBenhAn);
    BenhNhan findById(String maBenhNhan,String maBenhAn);
    List<BenhNhan> getAll();
    List<BenhAn> getAllBenhAn();
    BenhAn getBenhAn(String maBenhAn);
}
