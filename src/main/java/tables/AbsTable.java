package tables;
import db.IDBConnect;
import db.MySQLConnect;
import java.util.List;

public abstract class AbsTable implements ITable{
    protected IDBConnect dbConnector = null;
    private String tableName = "";

    public AbsTable(String tableName) {
        dbConnector = new MySQLConnect();
        this.tableName = tableName;
    }

    @Override
    public void create(List<String> columns) {
        dbConnector.execute(String.format("CREATE TABLE %s (%s);", tableName, String.join(",", columns)));
    }
    @Override
    public void delete() {
        dbConnector.execute(String.format("drop table if exists %s;",this.tableName));
    }

}