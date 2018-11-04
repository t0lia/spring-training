package spring_training.lab6_jdbc;

public interface Queries {

    String DROP_TABLE_SQL = "DROP TABLE country IF EXISTS ";
    String CREATE_TABLE_SQL = "CREATE TABLE country(id SERIAL, name VARCHAR(255), code_name VARCHAR(255))";

    String INSERT_SQL = "INSERT INTO country(name, code_name) VALUES (?,?)";

    String UPDATE_SQL = "UPDATE country SET name = ?, code_name = ? WHERE id = ?";

    String DELETE_SQL = "DELETE FROM country";

    String SELECT_SQL = "SELECT id, name, code_name FROM country";
    String SELECT_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name = ?";
    String SELECT_BY_NAME_START_WITH_SQL = "SELECT id, name, code_name FROM country WHERE name LIKE ?";

}
