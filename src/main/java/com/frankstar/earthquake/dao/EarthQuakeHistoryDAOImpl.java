package com.frankstar.earthquake.dao;

import com.frankstar.earthquake.entity.EarthQuake;
import com.frankstar.earthquake.entity.EarthRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankstar on 2017/6/9.
 */
@Repository("earthQuakeHistoryDAO")
public class EarthQuakeHistoryDAOImpl implements EarthQuakeHistoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final static RowMapper<EarthRelation> EARTH_RELATION_ROW_MAPPER = BeanPropertyRowMapper.newInstance(EarthRelation.class);

    @Override
    public void addEarthQuakeHistory(int earth_id, int earth_history) {

        String sql = "insert into earth_relation (earth_id,earth_history) values (" + earth_id + "," + earth_history +")";

        jdbcTemplate.update(sql);

    }

    @Override
    public List<EarthRelation> getEarthRelationByEarthId(int earth_id) {

        List<EarthRelation> earthRelationList = new ArrayList<>();
        String sql = "select * from earth_relation where earth_id =" + earth_id;

        earthRelationList = jdbcTemplate.query(sql, EARTH_RELATION_ROW_MAPPER);

        return earthRelationList;
    }
}
