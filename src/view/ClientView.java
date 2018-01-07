package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.SinhVien;

public class ClientView {
	public SinhVien nhapSV() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten: ");
		String tenSV = sc.nextLine();
		System.out.println("Nhap email: ");
		String email = sc.nextLine();
		SinhVien sv = new SinhVien(tenSV, email);
//		sc.close();
		return sv;
	}

	public int selectMenu() {
		System.out.println("Moi nhap lua chon: ");
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Edit");
		System.out.println("4. Delete");
		System.out.println("5. Save");
		System.out.println("0. Exit");
		System.out.print("Moi ban nhap: ");
		Scanner sc  = new Scanner(System.in);
		int selectMenu = Integer.parseInt(sc.nextLine());
//		sc.close();
		return selectMenu;
	}
	
	public SinhVien search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma sinh vien: ");
		int ma = Integer.parseInt(sc.nextLine());
		SinhVien sv = new SinhVien();
		sv.setMaSV(ma);
//		sc.close();
		return sv;

	}
	public void showMess(String mess) {
		System.out.println(mess);
	}
	
	public void showListSV(ArrayList<SinhVien> listSV) {
		System.out.println("---------------DSSV--------------");
		for(SinhVien x: listSV) {
			System.out.println(x.getMaSV()+"--"+x.getTenSV()+"--"+x.getEmail());
		}
	}
}
