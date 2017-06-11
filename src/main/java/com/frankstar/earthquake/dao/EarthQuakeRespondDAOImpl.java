package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthQuakeRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankstar on 2017/6/9.
 */
@Repository("earthQuakeRespondDAO")
public class EarthQuakeRespondDAOImpl implements EarthQuakeRespondDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static RowMapper<EarthQuakeRespond> EARTH_QUAKE_RESPOND_ROW_MAPPER = BeanPropertyRowMapper.newInstance(EarthQuakeRespond.class);

    @Override
    public List<EarthQuakeRespond> getAllEarthQuakeRespond() {

        List<EarthQuakeRespond> earthQuakeRespondList = new ArrayList<>();
        String sql = "select * from earth_respond";
        earthQuakeRespondList = jdbcTemplate.query(sql, EARTH_QUAKE_RESPOND_ROW_MAPPER);

        return earthQuakeRespondList;
    }

    @Override
    public EarthQuakeRespond getEarthQuakeRespondByRespondID(int respond_id) {

        String sql = "select * from earth_respond where respond_id = " + respond_id;
        final EarthQuakeRespond earthQuakeRespond = new EarthQuakeRespond();

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                earthQuakeRespond.setRespond_id(resultSet.getInt("respond_id"));
                earthQuakeRespond.setRespond_lead(resultSet.getString("respond_lead"));
                earthQuakeRespond.setRespond_organize(resultSet.getString("respond_organize"));
                earthQuakeRespond.setRespond_title(resultSet.getString("respond_title"));
            }
        });


        return earthQuakeRespond;
    }

    /*@Override
    public EarthQuakeRespond getEarthQuakeRespondByEarthID(int earth_id) {
        return null;
    }*/
}
