package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthRuleRespond;
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
 * Created by frankstar on 2017/6/10.
 */
@Repository("earthRuleRespondDAO")
public class EarthRuleRespondDAOImpl implements EarthRuleRespondDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static RowMapper<EarthRuleRespond> EARTH_RULE_RESPOND_ROW_MAPPER = BeanPropertyRowMapper.newInstance(EarthRuleRespond.class);

    @Override
    public List<EarthRuleRespond> getAllEarthRuleRespond() {

        List<EarthRuleRespond> earthRuleRespondList;
        String sql = "select * from earth_rule_respond";
        earthRuleRespondList = jdbcTemplate.query(sql, EARTH_RULE_RESPOND_ROW_MAPPER);

        return earthRuleRespondList;
    }

    @Override
    public int getRespondIDByRuleID(int rule_id) {

        Integer respond_id;
        String sql = "select respond_id from earth_rule_respond where rule_id = " + rule_id;
        respond_id = jdbcTemplate.queryForObject(sql, Integer.TYPE);

        return respond_id;
    }

    @Override
    public int getRuleIDByRespondID(int respond_id) {

        Integer rule_id;
        String sql = "select rule_Id from earth_rule_respond where respond_id = " + respond_id;
        rule_id = jdbcTemplate.queryForObject(sql, Integer.TYPE);

        return rule_id;
    }
}
