package service.imp;

import model.BenhAn;
import model.BenhNhan;
import repository.IBenhNhanRepository;
import repository.imp.BenhNhanhRepository;
import service.IBenhNhanService;

import java.util.List;

public class BenhNhanService implements IBenhNhanService {
    IBenhNhanRepository benhNhanhRepository = new BenhNhanhRepository();

    @Override
    public void insert(BenhNhan benhNhan) {
        benhNhanhRepository.insert(benhNhan);
    }

    @Override
    public void update(BenhNhan benhNhan) {
        benhNhanhRepository.update(benhNhan);
    }

    @Override
    public void deleteById(String maBenhNhan, String maBenhAn) {
        benhNhanhRepository.deleteById(maBenhNhan,maBenhAn);
    }

    @Override
    public BenhNhan findById(String maBenhNhan, String maBenhAn) {
        return benhNhanhRepository.findById(maBenhNhan,maBenhAn);
    }

    @Override
    public List<BenhNhan> getAll() {
        return benhNhanhRepository.getAll();
    }

    @Override
    public List<BenhAn> getAllBenhAn() {
        return benhNhanhRepository.getAllBenhAn();
    }

    @Override
    public BenhAn getBenhAn(String maBenhAn) {
        return benhNhanhRepository.getBenhAn(maBenhAn);
    }
}
