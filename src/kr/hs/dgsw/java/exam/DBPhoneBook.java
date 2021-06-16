package kr.hs.dgsw.java.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPhoneBook implements PhoneBook {
    private Connection getConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");

//        return DriverManager.getConnection("jdbc:mariadb://211.53.209.159/dgsw_java", "dgsw_student", "1234");
        return DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "jhy040129");
    }

    public NameCard makeCard(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String phoneNum = rs.getString("phone_number");
        String address = rs.getString("address");

        NameCard card = new NameCard();
        card.setId(id);
        card.setName(name);
        card.setPhoneNumber(phoneNum);
        card.setAddress(address);

        return card;
    }

    @Override
    public List<NameCard> getList() {
        try {
            Connection con = getConnection();

            String Sql = "select * from phone_book";
            PreparedStatement preparedStatement = con.prepareStatement(Sql);
            ResultSet rs = preparedStatement.executeQuery();

            List<NameCard> list = new ArrayList<NameCard>();
            NameCard card = null;
            while (rs.next()) {
                card = makeCard(rs);

                list.add(card);
            }

            con.close();
            preparedStatement.close();

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public NameCard getCard(int id) {
        try {
            Connection con = getConnection();

            String sql = "select * from phone_book where id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            NameCard card = null;
            if (rs.next()) {
                card = makeCard(rs);
            }

            con.close();
            preparedStatement.close();

            return card;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public NameCard getCard(String name) {
        try {
            Connection con = getConnection();

            String sql = "select * from phone_book where name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();

            NameCard card = null;
            if (rs.next()) {
                card = makeCard(rs);
            }

            con.close();
            preparedStatement.close();

            return card;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int addCard(String name, String phoneNumber, String address) {
        try {
            Connection con = getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("insert into phone_book");
            sql.append(" (name, phone_number, address) ");
            sql.append("values ");
            sql.append(" (?, ?, ?)");

            PreparedStatement preparedStatement = con.prepareStatement(sql.toString());
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, address);

            preparedStatement.executeUpdate();
            preparedStatement.close();

            con.close();

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public boolean removeCard(int id) {
        try {
            Connection con = getConnection();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from phone_book");
            stringBuilder.append(" where id = ?");

            PreparedStatement preparedStatement = con.prepareStatement(stringBuilder.toString());
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

            con.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void updateCard(int id, String name, String phoneNumber, String address) {
        try {
            Connection con = getConnection();

            StringBuilder sql = new StringBuilder();
            sql.append("update phone_book set ");
            sql.append(" name = ?, ");
            sql.append("  phone_number = ?, ");
            sql.append("  address = ? ");
            sql.append(" where id = ?");

            PreparedStatement preparedStatement = con.prepareStatement(sql.toString());
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, address);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        List<NameCard> list = this.getList();
        return list.size();
    }
}
