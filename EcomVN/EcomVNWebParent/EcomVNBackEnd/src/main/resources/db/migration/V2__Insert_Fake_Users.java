package com.ecomvn.web.admin.user.flyway;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.migration.Context;
import org.flywaydb.core.api.migration.JavaMigration;

import com.ecomvn.common.entity.Location;
import com.github.javafaker.Faker;




public class V2__Insert_Fake_Users implements JavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        Faker faker = new Faker();
        Connection connection = context.getConnection();

        try (Statement statement = connection.createStatement()) {
            for (int i = 1; i <= 1000; i++) {
                String lastName = faker.name().lastName();
                String firstName = faker.name().firstName();
                String email = faker.internet().emailAddress();
                String password = faker.internet().password();
                Location location = getRandomLocation();

                String sql = String.format("INSERT INTO users (last_name, first_name, email, password, location) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s')", lastName, firstName, email, password, location.getValue());

                statement.executeUpdate(sql);
            }
        } catch (SQLException e) {
            throw new FlywayException("Failed to insert fake users", e);
        }
    }

    private Location getRandomLocation() {
        Random random = new Random();
        Location[] locations = Location.values();
        return locations[random.nextInt(locations.length)];
    }

	@Override
	public MigrationVersion getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		return "Insert fake users";
	}

	@Override
	public Integer getChecksum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canExecuteInTransaction() {
		// TODO Auto-generated method stub
		return false;
	}
}
