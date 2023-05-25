package qlsinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<SinhVien> arrSinhVien = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        SinhVien admin = new SinhVien();
        int flag = 0;

        do {
            System.out.println(" ___________________________________________");
            System.out.println("|                                           |");
            System.out.println("|            MENU CỦA HUYBU                 |");
            System.out.println("|           QUẢN LÝ SINH VIÊN               |");
            System.out.println("|___________________________________________|");
            System.out.println("|                                           |");
            System.out.println("| 1. Thêm sinh viên.                        |");
            System.out.println("| 2. Tính điểm trung bình cho danh sách SV. |");
            System.out.println("| 3. Sắp xếp SV theo thứ tự từ điển.        |");
            System.out.println("| 4. In ra danh sách SV được khen thưởng.   |");
            System.out.println("| 5. SV nam có điểm cao nhất của khoa ĐT.   |");
            System.out.println("| 6. Hiển thị tất cả sinh viên.             |");
            System.out.println("| 0. Thoát!                                 |");
            System.out.println("|___________________________________________|");
            System.out.print("Nhập lựa chọn của bạn: ");
            
            flag = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng new line
            switch (flag) {
                case 1:
                    admin.nhapDanhSachSinhVien(sc);
                    arrSinhVien.addAll(admin.getDanhSachSinhVien());
                    break;
                case 2:
                    admin.tinhDiemTrungBinhChoDanhSach();
                    break;
                case 3:
                    admin.sapXepTheoThuTuTuDien();
                    admin.hienDanhSachCoStt();
                    break;
                case 4:
                    admin.hienThiSinhVienDuocKhenThuong();
                    break;
                case 5:
                    admin.hienThiSinhVienNamDiemCaoNhat();
                    break;
                case 6:
                    admin.hienDanhSachSinhVienAll(arrSinhVien);
                    break;


                default:
                    flag = 0;
                    System.out.println(" >> CHƯƠNG TRÌNH KẾT THÚC <<");
            }

        } while (flag != 0);
    }
}
