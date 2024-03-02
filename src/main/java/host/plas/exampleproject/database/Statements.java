package host.plas.exampleproject.database;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Statements {
    @Getter
    public enum MySQL {
        CREATE_DATABASE("CREATE DATABASE IF NOT EXISTS `%database%`;"),
        CREATE_TABLE("CREATE TABLE IF NOT EXISTS `%table_prefix%players` (" +
                ");"
        ),
        PUSH_PLAYER_MAIN("INSERT INTO `%table_prefix%players` (" +
                ";"),
        PULL_PLAYER_MAIN("SELECT * FROM `%table_prefix%` WHERE Uuid = '%uuid%';"),
        PLAYER_EXISTS("SELECT COUNT(*) FROM `%table_prefix%` WHERE Uuid = '%uuid%';"),
        ;

        private final String statement;

        MySQL(String statement) {
            this.statement = statement;
        }
    }

    @Getter
    public enum SQLite {
        CREATE_DATABASE(""),
        CREATE_TABLE("CREATE TABLE IF NOT EXISTS `%table_prefix%` (" +
                ");"
        ),
        PUSH_PLAYER_MAIN("INSERT OR REPLACE INTO `%table_prefix%` (" +
                ");"),
        PULL_PLAYER_MAIN("SELECT * FROM `%table_prefix%` WHERE Uuid = '%uuid%';"),
        PLAYER_EXISTS("SELECT COUNT(*) FROM `%table_prefix%` WHERE Uuid = '%uuid%';"),
        ;

        private final String statement;

        SQLite(String statement) {
            this.statement = statement;
        }
    }

    public enum StatementType {
        CREATE_DATABASE,
        CREATE_TABLE,
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
