package com.bovt.repository;

import com.bovt.models.Role;
import lombok.Data;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Andrii Iashchuk
 */

@Data
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    private Long NEW_ID = 100500L;
    private static String ROLE_NAME = "TEST_ROLE";
    private static String DELETE_ROLE_BY_ROLE_NAME_QUERY = "DELETE FROM role WHERE name='" + ROLE_NAME + "'";
    private Role targetRole;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DataSource dataSource;


    @Before
    public void deleteRoleBeforeTesting(){
        this.deleteTestingRoleByRoleName();
    }


    public void deleteTestingRoleByRoleName() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(DELETE_ROLE_BY_ROLE_NAME_QUERY);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createRoleTest(){
        Role role = new Role();
        role.setName(ROLE_NAME);
        targetRole = roleRepository.save(role);
        Assert.assertEquals(role.getName(), targetRole.getName());
    }

    @Test
    public void findRoleTest(){
        Role findRole = roleRepository.findOne(targetRole.getId());
        Assert.assertNotNull(findRole);
    }

    @Test
    public void updateRoleTest(){
        targetRole.setId(NEW_ID);
        Role updatedRole = roleRepository.save(targetRole);
        Assert.assertEquals(updatedRole.getId(), NEW_ID);
    }


    @After
    public void deleteRoleAfterTesting(){
        this.deleteTestingRoleByRoleName();
    }
}
