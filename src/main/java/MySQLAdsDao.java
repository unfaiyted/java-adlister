import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword());
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
    public Long insert(Ad ad) {
        return null;
    }
}


}
