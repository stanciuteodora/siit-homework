package siit.homework11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import siit.homework11.dataModel.Accommodation;
import siit.homework11.dataModel.RoomFare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RepositorySqlTests {
    private Connection connection;

    @BeforeEach
    public void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:mem:test_mem");
        connection.createStatement().executeUpdate("CREATE TABLE accomodation (id int PRIMARY KEY, type varchar (32), bed_type varchar (32), max_guests int, description varchar(512))");
        connection.createStatement().executeUpdate("CREATE TABLE room_fair (id int PRIMARY KEY, \"value\" double, season varchar(32)) ");
//        connection.createStatement().executeUpdate("CREATE TABLE accomodation_fair_relation (id int PRIMARY KEY, id_accomodation int, id_room_fair int, FOREIGN KEY (id_accomodation) REFERENCES accomodation(id), FOREIGN KEY (id_room_fair) REFERENCES room_fair(id))");
        connection.createStatement().executeUpdate("Create table accomodation_fair_relation (id int primary key, id_accomodation int, id_room_fair int, foreign key (id_accomodation) references accomodation(id), foreign key (id_room_fair) references room_fair(id));");
    }

    @AfterEach
    public void closeConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void insertIntoRoomFareTest() throws SQLException {
        // test data preparation
        RoomFare roomFare = new RoomFare(1, 100D, "summer");

        // test execution
        insertRoomFare(roomFare);

        // assertions
        RoomFare roomFairInDb = readRoomFareFromDb(connection, roomFare.getId());
        Assertions.assertEquals(roomFare, roomFairInDb);
    }

    @Test
    public void insertIntoAccommodationTableTest() throws SQLException {
        // test data preparation
        List<RoomFare> fares = new ArrayList<>();
        Accommodation accommodation = new Accommodation(1, "room", "queen", 2, "double room", fares);

        // test execution
        insertAccommodation(accommodation);

        // assertions
        Accommodation accommodationInDb = readAccommodationFromDb(connection, accommodation.getId());
        Assertions.assertEquals(accommodation, accommodationInDb);
    }

    @Test
    public void insertIntoAccommodationWithFareTest() throws SQLException {
        // test data preparation
        RoomFare summerFare = new RoomFare(1, 100D, "summer");
        List<RoomFare> fares = List.of(summerFare);
        Accommodation accommodation = new Accommodation(1, "room", "queen", 2, "double room", fares);

        // test execution
        insertRoomFare(summerFare);
        insertAccommodation(accommodation);

        // assertions
        Accommodation accommodationFromDb = readAccommodationFromDb(connection, accommodation.getId());
        for (int i = 0; i < accommodation.getFares().size(); i++) {
            Assertions.assertEquals(accommodation.getFares().get(i), accommodationFromDb.getFares().get(i));
        }
    }

    @Test
    public void selectTest() throws SQLException {
        // test data preparation
        RoomFare summerFare = new RoomFare(1, 100D, "summer");
        RoomFare winterFare = new RoomFare(2, 150D, "winter");
        List<RoomFare> accommodation1Fares = List.of(summerFare, winterFare);
        List<RoomFare> accommodation2Fares = List.of(winterFare);
        Accommodation accommodation1 = new Accommodation(1, "room", "queen", 2, "double room", accommodation1Fares);
        Accommodation accommodation2 = new Accommodation(2, "apartment", "king", 2, "apartment", accommodation2Fares);
        insertRoomFare(summerFare);
        insertRoomFare(winterFare);
        insertAccommodation(accommodation1);
        insertAccommodation(accommodation2);

        // test execution
        Accommodation accommodation1FromDb = readAccommodationFromDb(connection, accommodation1.getId());
        Accommodation accommodation2FromDb = readAccommodationFromDb(connection, accommodation2.getId());

        // assertions
        Assertions.assertEquals(accommodation1.getId(), accommodation1FromDb.getId());
        Assertions.assertEquals(accommodation2.getId(), accommodation2FromDb.getId());
        Assertions.assertEquals(2, accommodation1.getFares().size());
        Assertions.assertEquals(1, accommodation2.getFares().size());

        List<Accommodation> accommodations = readAccommodationsFromDb(connection);
        for (Accommodation accommodation : accommodations) {
            System.out.println(accommodation);
        }
    }

    private void insertRoomFare(RoomFare roomFare) throws SQLException {
        PreparedStatement preparedStatement3 = connection.prepareStatement("INSERT INTO room_fair VALUES(?, ?, ?) ");
        preparedStatement3.setInt(1, roomFare.getId());
        preparedStatement3.setDouble(2, roomFare.getValue());
        preparedStatement3.setString(3, roomFare.getSeason());
        preparedStatement3.executeUpdate();
    }

    private void insertAccommodation(Accommodation accommodation) throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO accomodation VALUES(?, ?, ?, ?, ?) ");
        preparedStatement1.setInt(1, accommodation.getId());
        preparedStatement1.setString(2, accommodation.getType());
        preparedStatement1.setString(3, accommodation.getBedType());
        preparedStatement1.setInt(4, accommodation.getMaxGuests());
        preparedStatement1.setString(5, accommodation.getDescription());
        preparedStatement1.executeUpdate();

        for (RoomFare roomFare : accommodation.getFares()) {
            insertAccommodationFareRelation(accommodation.getId(), roomFare.getId());
        }
    }

    private void insertAccommodationFareRelation(Integer accommodationId, Integer roomId) throws SQLException {
        PreparedStatement preparedStatement7 = connection.prepareStatement("INSERT INTO accomodation_fair_relation VALUES(?, ?, ?) ");
        preparedStatement7.setInt(1, new Random().nextInt(100));
        preparedStatement7.setInt(2, accommodationId);
        preparedStatement7.setInt(3, roomId);
        preparedStatement7.executeUpdate();
    }

    private List<Accommodation> readAccommodationsFromDb(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM accomodation");
        ResultSet resultSet = statement.executeQuery();
        List<Accommodation> accommodations = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            String bedType = resultSet.getString("bed_type");
            Integer maxGuests = resultSet.getInt("max_guests");
            String description = resultSet.getString("description");
            List<RoomFare> roomFares = readFaresForRoomFromDb(connection, id);
            Accommodation accommodation = new Accommodation(id, type, bedType, maxGuests, description, roomFares);
            accommodations.add(accommodation);
        }
        return accommodations;
    }

    private Accommodation readAccommodationFromDb(Connection connection, Integer accommodationId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM accomodation WHERE id = ?");
        statement.setInt(1, accommodationId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            String bedType = resultSet.getString("bed_type");
            Integer maxGuests = resultSet.getInt("max_guests");
            String description = resultSet.getString("description");
            List<RoomFare> roomFares = readFaresForRoomFromDb(connection, accommodationId);
            return new Accommodation(id, type, bedType, maxGuests, description, roomFares);
        }
        return null;
    }

    private List<RoomFare> readFaresForRoomFromDb(Connection connection, Integer accommodationId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * " +
                        "FROM accomodation " +
                        "JOIN accomodation_fair_relation ON accomodation_fair_relation.id_accomodation = accomodation.id " +
                        "JOIN room_fair ON room_fair.id = accomodation_fair_relation.id_room_fair " +
                        "WHERE accomodation.id = ?");
        statement.setInt(1, accommodationId);
        ResultSet resultSet = statement.executeQuery();
        List<RoomFare> fares = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            Double value = resultSet.getDouble("value");
            String season = resultSet.getString("season");
            fares.add(new RoomFare(id, value, season));
        }
        return fares;
    }

    private RoomFare readRoomFareFromDb(Connection connection, Integer identifier) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM room_fair WHERE id = ? ");
        preparedStatement.setInt(1, identifier);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            Double value = resultSet.getDouble("value");
            String season = resultSet.getString("season");
            return new RoomFare(id, value, season);
        }
        return null;
    }

    // there's a prettier version of this above readFaresForRoomFromDb
    @Deprecated
    private List<RoomFare> readRoomFaresFromDb(Connection connection, Integer accommodationId) throws SQLException {
        List<RoomFare> roomFares = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM accomodation_fair_relation WHERE id_accomodation = ? ");
        preparedStatement.setInt(1, accommodationId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id_room_fair = resultSet.getString("id_room_fair");
            roomFares.add(readRoomFareFromDb(connection, Integer.valueOf(id_room_fair)));
        }
        return roomFares;
    }
}
