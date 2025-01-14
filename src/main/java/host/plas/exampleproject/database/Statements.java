package host.plas.exampleproject.database;

import host.plas.bou.sql.ConnectorSet;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Statements {
    @Getter
    public enum MySQL {
        CREATE_DATABASE("CREATE DATABASE IF NOT EXISTS `%database%`;"),
        CREATE_TABLES(
                "CREATE TABLE IF NOT EXISTS `%table_prefix%Players` ( " +
                "Uuid VARCHAR(36) NOT NULL, " +
                "Name VARCHAR(16) NOT NULL, " +
                "PRIMARY KEY (Uuid) " +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;;"
        ),
        PUSH_PLAYER_MAIN("INSERT INTO `%table_prefix%Players` ( " +
                "Uuid, Name " +
                ") VALUES ( " +
                "?, ? " +
                ") ON DUPLICATE KEY UPDATE " +
                "Name = ?" +
                ";"),
        PULL_PLAYER_MAIN("SELECT * FROM `%table_prefix%Players` WHERE Uuid = ?;"),
        PLAYER_EXISTS("SELECT COUNT(*) FROM `%table_prefix%Players` WHERE Uuid = ?;"),
        ;

        private final String statement;

        MySQL(String statement) {
            this.statement = statement;
        }
    }

    @Getter
    public enum SQLite {
        CREATE_DATABASE(""),
        CREATE_TABLES(
                "CREATE TABLE IF NOT EXISTS `%table_prefix%Players` ( " +
                "Uuid TEXT NOT NULL, " +
                "Name TEXT NOT NULL, " +
                "PRIMARY KEY (Uuid) " +
                ");;"
        ),
        PUSH_PLAYER_MAIN("INSERT OR REPLACE INTO `%table_prefix%Players` ( " +
                "Uuid, Name " +
                ") VALUES ( " +
                "?, ? " +
                ");"),
        PULL_PLAYER_MAIN("SELECT * FROM `%table_prefix%Players` WHERE Uuid = ?;"),
        PLAYER_EXISTS("SELECT COUNT(*) FROM `%table_prefix%Players` WHERE Uuid = ?;"),
        ;

        private final String statement;

        SQLite(String statement) {
            this.statement = statement;
        }
    }

    public enum StatementType {
        CREATE_DATABASE,
        CREATE_TABLES,
        PUSH_PLAYER_MAIN,
        PULL_PLAYER_MAIN,
        PLAYER_EXISTS,
        ;
    }

    public static String getStatement(StatementType type, ConnectorSet connectorSet) {
        switch (connectorSet.getType()) {
            case MYSQL:
                return MySQL.valueOf(type.name()).getStatement()
                        .replace("%database%", connectorSet.getDatabase())
                        .replace("%table_prefix%", connectorSet.getTablePrefix());
            case SQLITE:
                return SQLite.valueOf(type.name()).getStatement()
                        .replace("%table_prefix%", connectorSet.getTablePrefix());
            default:
                return "";
        }
    }
}
