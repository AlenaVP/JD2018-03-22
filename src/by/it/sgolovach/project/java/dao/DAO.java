package by.it.sgolovach.project.java.dao;

import by.it.sgolovach.project.java.dao.daobeans.AdDAO;
import by.it.sgolovach.project.java.dao.daobeans.RoleDAO;
import by.it.sgolovach.project.java.dao.daobeans.UserDAO;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DAO {
//    public static void main(String[] args) {
//        DAO dao=DAO.getInstance();
//        dao.reset();
//
//    }

    private static DAO dao;

    public RoleDAO role;
    public UserDAO user;
    public AdDAO ad;

    private DAO() {
        role=new RoleDAO();
        user=new UserDAO();
        ad=new AdDAO();
    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null)
                    dao = new DAO();
            }
        }
        return dao;
    }

    public void reset(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `sgolovach`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `sgolovach` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sgolovach`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sgolovach`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NOT NULL,\n" +
                    "  `email` VARCHAR(100) NOT NULL,\n" +
                    "  `password` VARCHAR(200) NOT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `sgolovach`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `sgolovach`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(2000) NULL,\n" +
                    "  `rooms` INT NULL,\n" +
                    "  `price` DECIMAL NULL,\n" +
                    "  `area` DECIMAL NULL,\n" +
                    "  `flat` INT NULL,\n" +
                    "  `flats` INT NULL,\n" +
                    "  `adress` VARCHAR(200) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `sgolovach`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'director')");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'SGolovach', 'adm@mail.ru', '79584cf9c4b7118dd5feb956c3c00e363e04183d6a2a66a99fc3b7064541c395', 1)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'ba0b45476aa7c884f6de17ceb824aab6e87a7a99ecb0abe71ae358427e4c0bc9', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user2', 'user2@mail.ru', '8eec2b0af0b9c4b762d0f84b864b83687f1735353ed77cd3d13a0642b864c645', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user3', 'user3@mail.ru', '7ec25e18682f140c75f7e06597ebe6c450d0a51274c934604c54a71ec44a197d', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'guest', 'guest3@mail.ru', 'b8e52ddfce236be34bfe22b6c21d2a819b9af1138eaf9565fb4fc8c102bd14f7', 3)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'director', 'director@mail.ru', '526fe73571c209a61d9cf5fbb16110bc3c7592068a58ef9b166ffd38950674ec', 4)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 3, 13699, 32, 1, 2, 'Minsk, Brikete 2', 3)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'buy flat', 8, 132000, 168, 25, 25, 'Moscow, Sgukova 1', 1)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 2, 25000, 15, 1, 2, 'Gomel, Brikete 8', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'buy flat in Minsk,Grodno', 3, 63000, 89, 2, 9, 'Minsk,Grodno', 5)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 3, 35450, 92, 5, 5, 'Mogilev, Lomonosova 26', 4)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 2, 27989, 76, 2, 5, 'Mogilev, Lenina 15', 4)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'buy flat in Minsk', 6, 95000, 127, 3, 5, 'Minsk, Pobediteley 13', 6)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 2, 95630, 56, 7, 9, 'Minsk, Filimonova 35', 3)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat in Varshava Poland', 3, 38900, 68, 4, 5, 'Varshava, Kastushki 92', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat in London UK', 4, 136900, 127, 29, 35, 'London, Picadili 6/2', 4)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 5, 35600, 125, 2, 5, 'Vitebsk, Chepelia 39', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 3, 29365, 98, 7, 10, 'Minsk, Suharevo 85', 3)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
