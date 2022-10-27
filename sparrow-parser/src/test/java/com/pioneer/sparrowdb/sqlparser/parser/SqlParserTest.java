package com.pioneer.sparrowdb.sqlparser.parser;

import com.google.common.collect.Lists;
import com.pioneer.sparrowdb.sqlparser.tree.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class SqlParserTest {

    private SqlParser sqlParser = new SqlParser();

    @Test
    public void testSelect() {
        String sql = "select name,age from employee where age=12 order by age desc offset 0 limit 1";
        Statement statement = sqlParser.createStatement(sql);
        Query query = (Query) statement;

        QuerySpecification specification = (QuerySpecification) query.getQueryBody();
        Table table = (Table) specification.getFrom().get();
        String tableName = table.getName().toString();
        Assert.assertEquals("employee", tableName);

        List<SelectItem> selectItems = specification.getSelect().getSelectItems();
        List<String> fieldNames = Lists.newArrayList();
        for (SelectItem item : selectItems) {
            SingleColumn column = (SingleColumn) item;
            fieldNames.add(((Identifier) column.getExpression()).getValue());
        }
        Assert.assertEquals("name,age", String.join(",", fieldNames));

        Optional<Expression> whereExpr = specification.getWhere();
        Assert.assertEquals("age=12", whereExpr.get().toString());

        Optional<OrderBy> orderByExpr = specification.getOrderBy();
        for (Node node : orderByExpr.get().getChildren()) {
            SortItem sortItem = (SortItem) node;
            Assert.assertEquals("age", sortItem.getSortKey().toString());
            Assert.assertEquals("DESCENDING", sortItem.getOrdering().toString());
        }

        Optional<Offset> offset = specification.getOffset();
        Assert.assertEquals("0", offset.get().getRowCount());

        Optional<String> limit = specification.getLimit();
        Assert.assertEquals("1", limit.get());
    }

    @Test
    public void testCreateTable() {
        String sql = "create table states(id integer,name varchar(10))";
        Statement statement = sqlParser.createStatement(sql);

        String expected =
                "CreateTable{name=states, elements=[ColumnDefinition{name=id, type=integer, nullable=true," + " " +
                        "properties=[], comment=Optional.empty}, ColumnDefinition{name=name, type=varchar(10), " +
                        "nullable=true," + " properties=[], comment=Optional.empty}], notExists=false, properties=[],"
                        + " comment=Optional.empty}";
        Assert.assertEquals(expected, statement.toString());
    }

    @Test
    public void testDropTable() {
        String sql = "drop table states";
        Statement statement = sqlParser.createStatement(sql);
        String expected = "DropTable{tableName=states, exists=false}";
        Assert.assertEquals(expected, statement.toString());
    }

    @Test
    public void testInsertData() {
        String sql = "insert into states(id,name) values(1,'pioneeer')";
        Statement statement = sqlParser.createStatement(sql);
        String expected = "Insert{target=states, columns=Optional[[id, name]], query=Query{queryBody=([1, pioneeer])," +
                " orderBy=Optional.empty}}";
        Assert.assertEquals(expected, statement.toString());
    }

    @Test
    public void testDeleteData() {
        String sql = "delete from states where id=1";
        Statement statement = sqlParser.createStatement(sql);
        String expected = "Delete{table=states, where=Optional[id=1]}";
        Assert.assertEquals(expected, statement.toString());
    }
}