package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthQuakeLoss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by frankstar on 2017/6/9.
 */
@Repository("earthQuakeLossDAO")
public class EarthQuakeLossDAOImpl implements EarthQuakeLossDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public EarthQuakeLoss getEarthQuakeLossByEarthID(int earth_id) {

        final EarthQuakeLoss earthQuakeLoss = new EarthQuakeLoss();
        String sql = "select * from earth_loss where earth_id = " + earth_id;

        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                earthQuakeLoss.setDeath_people(resultSet.getInt("death_people"));
                earthQuakeLoss.setDestroy(resultSet.getDouble("destroy"));
                earthQuakeLoss.setEarth_id(resultSet.getInt("earth_id"));
                earthQuakeLoss.setEconomy_loss(resultSet.getDouble("economy_loss"));
                earthQuakeLoss.setId(resultSet.getInt("id"));
                earthQuakeLoss.setInjury(resultSet.getInt("injury"));
            }
        });
        return earthQuakeLoss;
    }

    @Override
    public void addEarthQuakeLoss(int earth_id, int death_people, int injury, double economy_loss, double destroy) {

        String sql = "insert into earth_loss (earth_id, death_people, economy_loss, destroy, injury) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{earth_id, death_people, economy_loss, destroy, injury});

    }
}
