package kr.hs.dgsw.java.jdbc;

import kr.hs.dgsw.java.api.Name;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudy {
    private Connection getConnection() throws Exception {
        // DB 연결
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "jhy040129");
//        return DriverManager.getConnection("jdbc:mariadb://211.53.209.159/dgsw_java", "dgsw_student", "1234");
    }

    private NameCard makeNameCard(ResultSet rs) throws Exception {
        int id1 = rs.getInt("id");
        String name = rs.getString("name");
        String phoneNumber = rs.getString("phone_number");
        String address = rs.getString("address");

        NameCard nameCard = new NameCard();
        nameCard.setId(id1);
        nameCard.setName(name);
        nameCard.setPhoneNumber(phoneNumber);
        nameCard.setAddress(address);

        return nameCard;
    }

    public NameCard get(int id) throws Exception {
        Connection con = getConnection();

        // DB에서 데이터를 받아옴
        String Sql = "select * from phone_book where id = ?";
        PreparedStatement pstmt = con.prepareStatement(Sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        // 가져온 데이터를 NameCard object로 변환
        NameCard nameCard = null;
        if (rs.next()) {
            nameCard = makeNameCard(rs);
        }

        con.close();
        pstmt.close();
        return nameCard;
    }

    public NameCard getByName(String name) throws Exception {
        Connection con = getConnection();

        String sql = "select * from phone_book where name = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();

        NameCard nameCard = null;
        if(rs.next()) {
            nameCard = makeNameCard(rs);
        }

        con.close();
        pstmt.close();

        return nameCard;
    }

    public List<NameCard> getList() throws Exception {
        Connection con = getConnection();

        String sql = "select * from phone_book";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<NameCard> list = new ArrayList<NameCard>();
        NameCard nameCard = null;
        while(rs.next()) {
            nameCard = makeNameCard(rs);

            list.add(nameCard);
        }

        con.close();
        pstmt.close();

        return list;
    }

    public void insert(String name, String phoneNumber, String address) throws Exception {
        Connection con = getConnection();

        // DB에 자료를 추가한다
        StringBuilder sql = new StringBuilder();
        sql.append("insert into phone_book ");
        sql.append(" (name, phone_number, address) ");
        sql.append("values ");
        sql.append(" (?, ?, ?)");

        PreparedStatement pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, name);
        pstmt.setString(2, phoneNumber);
        pstmt.setString(3, address);

        pstmt.executeUpdate();
        pstmt.close();

        con.close();
    }

    public void update(String name, String phoneNumber, String address, int id) throws Exception {
        Connection con = getConnection();

        StringBuilder sql = new StringBuilder();
        sql.append("update phone_book set ");
        sql.append(" name = ?, ");
        sql.append("  phone_number = ?, ");
        sql.append("  address = ? ");
        sql.append(" WHERE id = ? ");

        PreparedStatement pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, name);
        pstmt.setString(2, phoneNumber);
        pstmt.setString(3, address);
        pstmt.setInt(4, id);

        pstmt.executeUpdate();
        pstmt.close();

        con.close();
    }

    public void delete(int id) throws Exception {
        Connection con = getConnection();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete from phone_book ");
        stringBuilder.append(" where id = ? ");

        PreparedStatement preparedStatement = con.prepareStatement(stringBuilder.toString());
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
        preparedStatement.close();

        con.close();
    }

    public static void main(String[] args) {
        try {
            JdbcStudy jdbcStudy = new JdbcStudy();
            NameCard nameCard = jdbcStudy.getByName("민트초코");
            List<NameCard> nameCard2 = jdbcStudy.getList();

            if (nameCard != null) {
                System.out.println(nameCard.getId() + nameCard.getName() + nameCard.getPhoneNumber() + nameCard.getAddress());
            } else {
                System.out.println("정보 없음");
            }

            for(NameCard card: nameCard2) {
                System.out.println(card.getId() + card.getName() + card.getPhoneNumber() + card.getAddress());
            }

            jdbcStudy.insert("이름", "010-1234-5678", "해남 땅끝마을");
            jdbcStudy.update("전해윤", "010-123-123", "대구 어딘가", 53);
            jdbcStudy.delete(50);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
