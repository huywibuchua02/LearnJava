package qlsinhvien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SinhVien {
    private List<SinhVien> danhSachSinhVien;
    private String maSv, tenSv, diaChi, gioiTinh, khoa, queQuan, email;
    private float diem1, diem2, diem3;
    private float gpa;
    
    private ArrayList<SinhVien> arrSinhVien;

    public SinhVien() {
        arrSinhVien = new ArrayList<>();
        danhSachSinhVien = new ArrayList<>();
    }

    public SinhVien(String maSv, String tenSv, String diaChi, String gioiTinh, String khoa, String queQuan, String email, float diem1, float diem2, float diem3) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.khoa = khoa;
        this.queQuan = queQuan;
        this.email = email;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.gpa = tinhDiemTb();
    }

    public float tinhDiemTb() {
        return (diem1 + diem2 + diem3) / 3;
    }

    public SinhVien themSinhVien(Scanner scanner) {
        SinhVien sv = new SinhVien();

        System.out.print("Nhập mã sinh viên: ");
        sv.maSv = scanner.nextLine();

        System.out.print("Nhập họ và tên sinh viên: ");
        sv.tenSv = scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        sv.diaChi = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        sv.gioiTinh = scanner.nextLine();

        System.out.print("Nhập khoa: ");
        sv.khoa = scanner.nextLine();

        System.out.print("Nhập quê quán: ");
        sv.queQuan = scanner.nextLine();

        System.out.print("Nhập email: ");
        sv.email = scanner.nextLine();

        System.out.print("Nhập điểm 1: ");
        sv.diem1 = scanner.nextFloat();

        System.out.print("Nhập điểm 2: ");
        sv.diem2 = scanner.nextFloat();

        System.out.print("Nhập điểm 3: ");
        sv.diem3 = scanner.nextFloat();

        scanner.nextLine(); // Đọc bỏ dòng new line

        sv.gpa = sv.tinhDiemTb();

        danhSachSinhVien.add(sv);
        System.out.println("Thêm sinh viên thành công.");

        return sv;
    }

    public void nhapDanhSachSinhVien(Scanner scanner) {
        System.out.print("Nhập số lượng sinh viên muốn thêm: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng new line

        for (int i = 0; i < n; i++) {
            System.out.println("Sinh viên thứ " + (i + 1));
            SinhVien sv = themSinhVien(scanner);
            arrSinhVien.add(sv);
        }
    }

        
    
    // Ý 1: tính điểm trung bình cho danh sách sinh viên
public void tinhDiemTrungBinhChoDanhSach() {
    System.out.println(" \nĐiểm trung bình của các sinh viên :");
    int soThuTu = 1;
    
    for (SinhVien sinhVien : danhSachSinhVien) {
        float diemTrungBinh = sinhVien.tinhDiemTb();
        System.out.println("Stt: " + soThuTu + ", MSSV: " + sinhVien.maSv + ", Họ và tên: " + sinhVien.tenSv + ", Điểm trung bình: " + diemTrungBinh);
        soThuTu++;
    }

}


    // Ý 2: sắp xếp danh sách sinh viên theo thứ tự từ điển
    public void sapXepTheoThuTuTuDien() {
        Collections.sort(danhSachSinhVien, new Comparator<SinhVien>() {
            public int compare(SinhVien sv1, SinhVien sv2) {
                return sv1.getTenSv().compareTo(sv2.getTenSv());
            }
        });
    }

public void hienDanhSachCoStt() {
    System.out.println("---------DANH SÁCH SINH VIÊN ---------");
    for (int i = 0; i < danhSachSinhVien.size(); i++) {
        SinhVien sinhVien = danhSachSinhVien.get(i);
        System.out.println("Stt: " + (i + 1) + "\t"+ sinhVien.toString());
    }
    System.out.println("----------------------");
}


    // Ý 3: In ra danh sách sinh viên được khen thưởng
    // biết rằng để được khen thưởng sinh viên đó phải đạt điểm trung bình > 8.0 và không có điểm nào dưới 7
public void hienThiSinhVienDuocKhenThuong() {
    System.out.println(" \nDanh sách sinh viên được khen thưởng :");
    boolean coSinhVienDuocKhenThuong = false;
    
    for (SinhVien sinhVien : danhSachSinhVien) {
        float diemTrungBinh = sinhVien.tinhDiemTb();
        boolean khongDuoiBay = true;
        
        if (sinhVien.diem1 < 7 || sinhVien.diem2 < 7 || sinhVien.diem3 < 7) {
            khongDuoiBay = false;
        }

        if (diemTrungBinh > 8.0 && khongDuoiBay) {
            System.out.println(sinhVien.toString());
            coSinhVienDuocKhenThuong = true;
        }
    }

    if (!coSinhVienDuocKhenThuong) {
        System.out.println(" \nKhông có sinh viên nào được khen thưởng.");
    }
}


    // Ý 4: Cho biết Nam sinh viên có điểm cao nhất của khoa điện tử
    public void hienThiSinhVienNamDiemCaoNhat() {
        float diemCaoNhat = -1;
        SinhVien sinhVienNamDiemCaoNhat = null;

        for (SinhVien sinhVien : danhSachSinhVien) {
            if (sinhVien.gioiTinh.equalsIgnoreCase("Nam") && sinhVien.khoa.equalsIgnoreCase("Dien tu")) {
                float diemTrungBinh = sinhVien.tinhDiemTb();
                if (diemTrungBinh > diemCaoNhat) {
                    diemCaoNhat = diemTrungBinh;
                    sinhVienNamDiemCaoNhat = sinhVien;
                }
            }
        }

        if (sinhVienNamDiemCaoNhat != null) {
            System.out.println(" \nSinh viên nam có điểm cao nhất trong khoa điện tử :");
            System.out.println(sinhVienNamDiemCaoNhat.toString());
        } else {
            System.out.println(" \nKhông có sinh viên nam trong khoa điện tử .");
        }

    }

    
public void hienDanhSachSinhVienAll(ArrayList<SinhVien> arrSinhVien) {
    System.out.println("---------DANH SÁCH SINH VIÊN ---------");
    for (int i = 0; i < arrSinhVien.size(); i++) {
        SinhVien sinhVien = arrSinhVien.get(i);
        System.out.println("Stt: " + (i + 1) + "\t" + sinhVien.toString());
    }
    System.out.println("----------------------");
}
    


    @Override
    public String toString() {
        return   "Mã SV: " + maSv +
                    ", Tên SV: " + tenSv +
                    ", Địa chỉ: " + diaChi +
                    ", Giới tính: " + gioiTinh +
                    ", Khoa: " + khoa +
                    ", Quê quán: " + queQuan +
                    ", Email: " + email +
                    ", Điểm 1: " + diem1 +
                    ", Điểm 2: " + diem2 +
                    ", Điểm 3: " + diem3 +
                    ", GPA: " + gpa ;
}


    public List<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }

    public void setDanhSachSinhVien(List<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getDiem1() {
        return diem1;
    }

    public void setDiem1(float diem1) {
        this.diem1 = diem1;
    }

    public float getDiem2() {
        return diem2;
    }

    public void setDiem2(float diem2) {
        this.diem2 = diem2;
    }

    public float getDiem3() {
        return diem3;
    }

    public void setDiem3(float diem3) {
        this.diem3 = diem3;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}