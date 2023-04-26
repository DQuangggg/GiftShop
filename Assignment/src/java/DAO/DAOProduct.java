/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBConnect;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAOProduct extends DBConnect {

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  FROM [Product]";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> get8NewProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT Top 8 [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  From Product Order By pid DESC ";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> get8BestSell() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "Select p.[pid]\n"
                    + "      ,p.[productname]\n"
                    + "      ,p.[productimg]\n"
                    + "      ,p.[productprice]\n"
                    + "      ,p.[productnote]\n"
                    + "      ,p.[cid] From\n"
                    + " (Select Top 8 c.pid, sum(c.amount) as TotalProduct From Cart c\n"
                    + " Group by c.pid\n"
                    + " Order by TotalProduct Desc) t, Product p\n"
                    + " where p.pid = t.pid";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (Exception ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public ArrayList<Product> getProductByCategoryId(int id) {
        try {
            ArrayList<Product> products = new ArrayList<>();

            String sql = "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  FROM [Product]\n"
                    + "  Where [cid]= ?\n"
                    + "  ";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> getProductByName(String name) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT  pid,productname,productimg,productprice,productnote,cid\n"
                    + "FROM Product Where productname like ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public Product getProductById(int id) {
        try {
            String sql = "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid]\n"
                    + "  FROM [Product]\n"
                    + "  Where [pid] like ?\n";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + id + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                return p;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertProduct(Product p) {
        try {
            String sql = "INSERT INTO Product(productname,productimg,productprice,productnote,cid)\n"
                    + "Values (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getProductName());
            statement.setString(2, p.getProductImg());
            statement.setInt(3, p.getProductPrice());
            statement.setString(4, p.getProductNote());
            statement.setInt(5, p.getCid());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateProduct(Product p) {
        try {
            String sql = "Update [Product] Set [productname] = ?,\n"
                    + "[productimg] =?, \n"
                    + "[productprice] = ?, \n"
                    + "[productnote]=?,\n"
                    + "[cid]= ? \n"
                    + "Where [pid] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, p.getProductName());
            statement.setString(2, p.getProductImg());
            statement.setInt(3, p.getProductPrice());
            statement.setString(4, p.getProductNote());
            statement.setInt(5, p.getCid());
            statement.setInt(6, p.getPid());

            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteProduct(String id) {
        try {
            String sql = "Delete Product WHERE pid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTotalPage(int pagesize) {
        int totalPage = 0;
        try {
            String sql = "SELECT COUNT(pid) as totalproduct From Product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt("totalproduct");
                totalPage = totalProduct / pagesize;
                if (totalProduct % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public ArrayList<Product> getProductWithPaging(int index, int pagesize) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid], ROW_NUMBER() OVER(ORDER BY [pid]) RN\n"
                    + "  FROM [giftShop].[dbo].[Product] \n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, index * pagesize - (pagesize - 1));
            statement.setInt(2, index * pagesize);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public int getTotalPageByCategory(int cid, int pagesize) {
        int totalPage = 0;
        try {
            String sql = " SELECT COUNT(pid)as totalproduct\n"
                    + "  FROM [giftShop].[dbo].[Product] \n"
                    + " Where cid =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cid);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt("totalproduct");
                totalPage = totalProduct / pagesize;
                if (totalProduct % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public int getTotalProductByCategory(int cid) {
        try {
            String sql = "SELECT COUNT(*) FROM Product Where cid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> pagingProdctByCategory(int cid, int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE cid = ? ORDER BY pid OFFSET ? ROWS FETCH NEXT 16 ROWS ONLY ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(2, (index - 1) * 16);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getTotalProductBySearch(String nameToSearch) {
        try {
            String sql = "SELECT COUNT(*) FROM Product Where productname like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nameToSearch + "%");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<Product> getProdctBySearch(String nameToSearch) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE productname like ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nameToSearch);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> pagingProdctBySearch(String nameToSearch, int index) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE productname like ? ORDER BY pid OFFSET ? ROWS FETCH NEXT 16 ROWS ONLY ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nameToSearch + "%");
            statement.setInt(2, (index - 1) * 16);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Product> getProductByCategoryWithPaging(int cid, int index, int pagesize) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid], ROW_NUMBER() OVER(ORDER BY [pid]) RN\n"
                    + "  FROM Product \n"
                    + "   Where [cid] = ?\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setInt(1, cid);

            statement.setInt(2, index * pagesize - (pagesize - 1));
            statement.setInt(3, index * pagesize);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public int getTotalPageSreachByName(String nameToSearch, int pagesize) {
        int totalPage = 0;
        try {
            String sql = " SELECT  COUNT(pid)as totalproduct\n"
                    + "  FROM [giftShop].[dbo].[Product] \n"
                    + "   Where [productname] Like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + nameToSearch + "%");

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int totalProduct = rs.getInt("totalproduct");
                totalPage = totalProduct / pagesize;
                if (totalProduct % pagesize != 0) {
                    totalPage++;
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPage;
    }

    public ArrayList<Product> getProductSearchByNameWithPaging(String nameToSearch, int index, int pagesize) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sqlquery = "SELECT * From (\n"
                    + "SELECT  [pid]\n"
                    + "      ,[productname]\n"
                    + "      ,[productimg]\n"
                    + "      ,[productprice]\n"
                    + "      ,[productnote]\n"
                    + "      ,[cid], ROW_NUMBER() OVER(ORDER BY [pid]) RN\n"
                    + "  FROM [giftShop].[dbo].[Product] \n"
                    + "   Where [productname] Like ?\n"
                    + "  ) t\n"
                    + "WHERE RN BETWEEN ? AND ?";

            PreparedStatement statement = connection.prepareStatement(sqlquery);
            statement.setString(1, "%" + nameToSearch + "%");

            statement.setInt(2, index * pagesize - (pagesize - 1));
            statement.setInt(3, index * pagesize);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                products.add(p);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    //NEW
    public int getTotalProduct() {
        try {
            String sql = "SELECT COUNT(*) From Product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (SQLException ex) {

        }
        return 0;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product ORDER BY pid  OFFSET ? ROWS FETCH NEXT 16 ROWS ONLY";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (index - 1) * 16);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setProductName(rs.getString("productname"));
                p.setProductImg(rs.getString("productimg"));
                p.setProductPrice(rs.getInt("productprice"));
                p.setProductNote(rs.getString("productnote"));
                p.setCid(rs.getInt("cid"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
//        List<Product> list = dao.pagingProdctBySearch("Man", 0);
//        for (Product product : list) {
//            System.out.println(product);
//        }
        System.out.println(dao.pagingProdctBySearch("Man", 0));
    }
}
