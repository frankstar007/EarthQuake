package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthQuake;
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
 * Created by frankstar on 2017/6/8.
 */
@Repository("earthQuakeDAO")
public class EarthQuakeDAOImpl implements EarthQuakeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final static RowMapper<EarthQuake> EARTH_QUAKE_ROW_MAPPER = BeanPropertyRowMapper.newInstance(EarthQuake.class);
    private final static int PAGESIZE = 5;


    @Override
    public List<EarthQuake> getAllEarthQuake(int pageNumber) {

        List<EarthQuake> earthQuakeList = new ArrayList<>();
        String sql = "select * from earth_info ORDER BY earth_time DESC limit " + pageNumber + "," + PAGESIZE;

        earthQuakeList = jdbcTemplate.query(sql, EARTH_QUAKE_ROW_MAPPER);

        return earthQuakeList;
    }

    @Override
    public List<EarthQuake> getEarthQuakeByTime(String time) {

        List<EarthQuake> earthQuakeList;
        String sql = "select * from earth_info where earth_time <= " + time;
        earthQuakeList = jdbcTemplate.query(sql, EARTH_QUAKE_ROW_MAPPER);

        return earthQuakeList;
    }

    @Override
    public List<EarthQuake> getEarthQuakeByCity(String city) {

        List<EarthQuake> earthQuakeList;
        String sql = "select * from earth_info where city LIKE %" + city + "%";
        earthQuakeList = jdbcTemplate.query(sql, EARTH_QUAKE_ROW_MAPPER);

        return earthQuakeList;
    }

    @Override
    public void addEarthQuakeInfo(String earth_title, String earth_time, double longitude, double latitude, int deepth, double magnitude, String city) {

        String sql = "insert into earth_info (earth_title, earth_time, longitude, latitude, deepth, magnitude, city) values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{earth_title, earth_time, longitude, latitude, deepth, magnitude, city});
    }

    @Override
    public void deleteEarthQuake(int earth_id) {

        //后续 级联删除

    }

    @Override
    public EarthQuake getEarthQuakeByID(int earth_id) {

        final EarthQuake earthQuake = new EarthQuake();
        String sql = "select * from earth_info where earth_id = " + earth_id;
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                earthQuake.setCity(resultSet.getString("city"));
                earthQuake.setMagnitude(resultSet.getDouble("magnitude"));
                earthQuake.setDeepth(resultSet.getInt("deepth"));
                earthQuake.setLatitude(resultSet.getDouble("latitude"));
                earthQuake.setEarthTime(resultSet.getTime("earth_time"));
                earthQuake.setEarthId(resultSet.getInt("earth_id"));
                earthQuake.setLongitude(resultSet.getDouble("longitude"));
                earthQuake.setEarthTitle(resultSet.getString("earth_title"));
            }
        });
        return earthQuake;
    }

    @Override
    public List<EarthQuake> getEarthQuakeByID(List<Integer> earth_id) {

        List<EarthQuake> earthQuakeList = new ArrayList<>();
        for (Integer i: earth_id ) {
            String sql = "select * from earth_info where earth_id = " + i;
            earthQuakeList.add(jdbcTemplate.queryForObject(sql, EarthQuake.class));
        }
        return earthQuakeList;
    }
}
