package FunThingGeneratorModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardGame extends AbstractFunThing {
    private String name;

    public BoardGame(int participants,
                     int maxMinutes,
                     int maxCost,
                     boolean isOutside) {
        super(participants, maxMinutes, maxCost, isOutside);
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost, boolean isOutside) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/funthings",
                    "root", "yourpassword");
            Statement statement = connection.createStatement();
            String query = "select name from boardgames where min_players <= " + participants
                    + "and max_players >= " + participants + "and duration <= " + maxMinutes;
            String outerQuery = "select ";
            ResultSet results = statement.executeQuery("select * from boardgames where limit 1");
            this.name = results.getString("name");
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfoString() {
        return this.name;
    }
}
