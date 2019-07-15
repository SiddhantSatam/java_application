package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost","hplussport",
                "postgres","password");

        try{
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = new Customer();

            /** For CRUD operations
             * customer.setFirstName("Suchita");
            customer.setLastName("Satam");
            customer.setEmail("s.satam@gmail.com");
            customer.setAddress("26 Zealand road");
            customer.setCity("Etobicoke");
            customer.setState("ON");
            customer.setPhone("9726454985");
            customer.setZipCode("M9N4A1");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("suchita@gmail.com");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());*/

            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1002);
            System.out.println(order);
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
