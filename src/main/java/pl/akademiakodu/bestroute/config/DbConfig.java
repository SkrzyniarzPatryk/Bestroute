package pl.akademiakodu.bestroute.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        String sql = "INSERT INTO routes VALUES (null, 1, 1, 1, '1971-01-01 00:00:01', '1971-01-01 00:00:01', 30)";
//      //  String sql = "INSERT INTO airports VALUES (null, 'warsaw', 'poland')";
//        jdbcTemplate().update(sql);
//    }
}
