package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthQuakeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by frankstar on 2017/6/9.
 */
@Repository("earthQuakeRuleDAO")
public class EarthQuakeRuleDAOImpl implements EarthQuakeRuleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static RowMapper<EarthQuakeRule> EARTH_QUAKE_RULE_ROW_MAPPER = BeanPropertyRowMapper.newInstance(EarthQuakeRule.class);

    @Override
    public List<EarthQuakeRule> getAllEarthQuakeRule() {

        List<EarthQuakeRule> earthQuakeRuleList;
        String sql = "select * from earth_rule";
        earthQuakeRuleList = jdbcTemplate.query(sql, EARTH_QUAKE_RULE_ROW_MAPPER);

        return earthQuakeRuleList;
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByRuleID(int rule_id) {

        final EarthQuakeRule earthQuakeRule = new EarthQuakeRule();
        String sql = "select * from eath_rule where rule_id = " + rule_id;
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                earthQuakeRule.setRule_id(resultSet.getInt("rule_id"));
                earthQuakeRule.setEconomy_loss(resultSet.getDouble("economy_loss"));
                earthQuakeRule.setMax_death(resultSet.getInt("max_death"));
                earthQuakeRule.setMin_death(resultSet.getInt("min_death"));
                earthQuakeRule.setMax_magnitude(resultSet.getDouble("max_magnitude"));
                earthQuakeRule.setMin_magnitude(resultSet.getDouble("min_magnitude"));
                earthQuakeRule.setRule_title(resultSet.getString("rule_title"));
            }
        });
        return earthQuakeRule;
    }

    /*@Override
    public EarthQuakeRule getEarthQuakeRuleByEarthMagnitude(double magnitude) {
        return null;
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByDeathPeople(int death_people) {
        return null;
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByEconomyLoss(double economy_loss) {
        return null;
    }

    @Override
    public EarthQuakeRule getEarthQuakeRuleByEarthID(int earth_id) {
        return null;
    }*/
}
