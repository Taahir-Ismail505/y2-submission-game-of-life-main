package za.co.wethinkcode.game_of_life;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import io.javalin.http.Context;
import kong.unirest.HttpStatus;
import za.co.wethinkcode.game_of_life.domain.World;
import za.co.wethinkcode.game_of_life.http.requests.CreateRequest;
import za.co.wethinkcode.game_of_life.http.responses.WorldResponse;

public class WorldApiHandler {

    public void createNew(Context context) {
        CreateRequest createRequest = context.bodyAsClass(CreateRequest.class);
        World world = World.define(createRequest.getWorldName(), createRequest.getWorldSize(), createRequest.getWorldInitialState());

        context.status(HttpStatus.CREATED);

        context.json(new WorldResponse(1, world.getState()));
    }
}
// <SOLUTION>   private Connection connect() {
//    String url = "jdbc:sqlite:WorldDatabase.db";
//    Connection conn = null;
//    try {
//        conn = DriverManager.getConnection(url);
//    } catch (SQLException e) {
//        System.out.println(e.getMessage());
//    }
//    return conn;
//}

