package org.example.presentation;

import org.example.business.ProductManager;
import org.example.utils.GetInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice ;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("""
                    ********************PRODUCT MANAGEMENT****************
                    
                    1. Danh sách sản phẩm
                    2. Thêm mới sản phẩm
                    3. Cập nhật sản phẩm
                    4. Xóa sản phẩm
                    5. Tìm kiếm sản phẩm theo tên sản phẩm
                    6. Sắp xếp sản phẩm theo giá tăng dần
                    7. Thống kê số lượng sản phẩm theo danh mục
                    8. Thoát
                    
                    """);
            choice = GetInput.getInt(scanner,"Mời nhập lựa chọn của bạn : " , 1 ,8);
            switch(choice){
                case 1: {
                    ProductManager.displayListProduct();
                    break ;
                }
                case 2: {
                    ProductManager.addProduct(scanner);
                    break ;
                }
                case 3: {
                    ProductManager.updateProduct(scanner);
                    break ;
                }
                case 4: {

                    break ;
                }
                case 5: {

                    break ;
                }
                case 6: {

                    break ;
                }
                case 7: {

                    break ;
                }
                case 8: {
                    System.out.println("Tạm Biệt 111!1!");
                    System.exit(0);
                }
            }
        }while(true);
    }
}
