package FunThingGeneratorModel;

import java.sql.*;

public class BoardGame extends AbstractFunThing {
    private String name;

    public BoardGame(int participants,
                     int maxMinutes,
                     int maxCost,
                     boolean isOutside) throws NoMatchException {
        super(participants, maxMinutes, maxCost, isOutside);
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/funthings",
                    "root", "alllthefunthings");
            Statement statement = connection.createStatement();
            String query = "select name from boardgames where min_players <= " + participants
                    + " and max_players >= " + participants + " and duration <= " + maxMinutes
                    + " order by rand() limit 1";
            ResultSet results = statement.executeQuery(query);
            if(results.next()) {
                this.name = results.getString("name");
            } else {
                throw new NoMatchException("No board game matches those parameters");
            }
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

    public static void main(String[] args) throws NoMatchException {
        System.out.println(new BoardGame(3, 100, 0, false));
    }
}
