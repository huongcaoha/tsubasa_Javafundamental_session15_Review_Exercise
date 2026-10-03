package org.example.business;

import org.example.entity.Product;
import org.example.utils.ConnectDB;
import org.example.utils.GetInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    public static void displayListProduct(){
        List<Product> products = new ArrayList<>();
        try (
                Connection connection = ConnectDB.getConnection();
                CallableStatement callableStatement = connection.prepareCall("{call sp_GetAllProducts()}");
                ResultSet resultSet = callableStatement.executeQuery();
                ){
                while (resultSet.next()){
                    Product product = new Product();
                    product.setProductId(resultSet.getLong("Product_Id"));
                    product.setProductName(resultSet.getString("Product_Name"));
                    product.setProductCatalog(resultSet.getString("Product_catalog"));
                    product.setProductPrice(resultSet.getFloat("Product_Price"));
                    product.setProductCreated(resultSet.getDate("Product_created").toLocalDate());
                    product.setProductStatus(resultSet.getBoolean("Product_Status"));
                    product.setProductTitle(resultSet.getString("Product_Title"));
                    products.add(product);
                }

                if (products.isEmpty()){
                    System.out.println("Danh sách sản phẩm rỗng ");
                    return;
                }

            System.out.println("====================Danh sách sản phẩm==============================");
                products.stream().forEach(Product::displayData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addProduct(Scanner scanner){
        Product newProduct =  new Product();
        newProduct.InputData(scanner);

        try (
                Connection connection = ConnectDB.getConnection();
                CallableStatement callableStatement = connection.prepareCall("{ call sp_InsertProduct(?,?,?,?,?,?)}")
                ) {
                callableStatement.setString(1, newProduct.getProductName());
                callableStatement.setFloat(2 ,  newProduct.getProductPrice());
                callableStatement.setString(3 , newProduct.getProductTitle());
                callableStatement.setDate(4, Date.valueOf(newProduct.getProductCreated()));
                callableStatement.setString(5, newProduct.getProductCatalog());
                callableStatement.setInt(6 , newProduct.isProductStatus() ? 1 : 0);
                int result = callableStatement.executeUpdate();
                if (result == 0){
                    System.out.println("Thêm mới sản phẩm thất bại");
                }else {
                    System.out.println("Thêm mới sản phẩm thành công");
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkProductById(long productId){
        try (
                Connection connection = ConnectDB.getConnection();
                CallableStatement callableStatement = connection.prepareCall("{ call check_product_id(?,?)}")
                ){
            callableStatement.setLong(1, productId);
            callableStatement.registerOutParameter(2,Types.INTEGER);
            callableStatement.executeQuery();
            return callableStatement.getInt(2) != 0;

        }catch (Exception e){
            System.out.println("Có lỗi : " + e.getMessage());
            return false;
        }
    }

    public static void updateProduct(Scanner scanner){
        long id = GetInput.getLong(scanner, "Nhập vaào mã sản phẩm muốn cập nhật : " , 1 ,9999);
        boolean existed = checkProductById(id);
        if (existed){
            Product product = new Product();
            product.InputData(scanner);
            product.setProductId(id);

            try (
                    Connection connection = ConnectDB.getConnection();
                    CallableStatement callableStatement = connection.prepareCall("{call sp_UpdateProductById(?,?,?,?,?,?,?)}")
                    ){
                    callableStatement.setLong(1, product.getProductId());
                callableStatement.setString(2, product.getProductName());
                callableStatement.setFloat(3,  product.getProductPrice());
                callableStatement.setString(4 , product.getProductTitle());
                callableStatement.setDate(5, Date.valueOf(product.getProductCreated()));
                callableStatement.setString(6, product.getProductCatalog());
                callableStatement.setInt(7 , product.isProductStatus() ? 1 : 0);

               int rs = callableStatement.executeUpdate() ;
               if (rs > 0 ){
                   System.out.println("Cập nhật thành công");
               }else {
                   System.out.println("Cập nhật thất bại");
               }
            }catch (Exception e){
                System.out.println("Có lỗi : " + e.getMessage());
            }
        }else {
            System.out.println("Mã sản phẩm không tồn tại ");
        }
    }
}
