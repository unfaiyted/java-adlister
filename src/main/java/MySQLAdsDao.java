import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
            DriverManager.registerDriver(new Driver());
        try {
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    @Override
    public List<Ad> all() throws SQLException {

        String selectQuery = "SELECT * FROM ads";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(selectQuery);

        List<Ad> ads = new ArrayList<>();

        while (rs.next()) {
            ads.add(new Ad(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getString("description")
                ));

        }

        return ads;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {

        String values = String.format("'%2d','%s','%s'",
                ad.getUserId(), ad.getTitle(),  ad.getDescription());


        String query = "INSERT INTO ads(user_id, title, description) " +
                "VALUES ("+ values +")";

        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
           return rs.getLong(1);
        }

        return null;
    }
}


