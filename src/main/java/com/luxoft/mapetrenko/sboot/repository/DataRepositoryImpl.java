package com.luxoft.mapetrenko.sboot.repository;

import com.luxoft.mapetrenko.sboot.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Repository("dataRepository")
public class DataRepositoryImpl implements DataRepository<Data> {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void persist(Data object) {
        Object[] params = new Object[] { object.getId(), object.getDescription() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };

        String sql = "INSERT INTO sboot_data (data_id, data_description) VALUES (cast(? as UUID), ?);";

        jdbcOperations.update(sql, params, types);
    }

    @Override
    public void delete(Data object) {
        Object[] params = new Object[] { object.getId() };
        int[] types = new int[] { Types.VARCHAR };

        String sql = "DELETE FROM sboot_data WHERE data_id = cast(? as UUID);";

        jdbcOperations.update(sql, params, types);
    }

    @Override
    public Set<String> getRandomData() {
        Set<String> result = new HashSet<>();

        String sql = "SELECT data_description FROM sboot_data ORDER BY RANDOM() LIMIT 50;";

        SqlRowSet rows = jdbcOperations.queryForRowSet(sql);

        while(rows.next()) {
            result.add(rows.getString("data_description"));
        }

        return result;
    }
}
