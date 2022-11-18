package services;

import java.util.List;
import models.ChiTietDep;
import models.HoaDon;
import models.HoaDonChiTiet;

/**
 *
 * @author KenTizz
 */
public interface IHoaDonCTService {

    List<HoaDonChiTiet> getListHoaDonCT();

    List<HoaDon> getAllHoaDon();

    List<ChiTietDep> getAllChiTietDep();

    boolean save(HoaDonChiTiet hdct);

    boolean delete(HoaDonChiTiet hdct);

    HoaDonChiTiet getobjbyId(int id);

    List<HoaDonChiTiet> findByName(String ten);
}