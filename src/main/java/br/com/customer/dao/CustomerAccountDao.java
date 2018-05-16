package br.com.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.customer.entity.CustomerAccount;

public class CustomerAccountDao {
	
	private static final String URL = "jdbc:mysql://localhost/dbteste";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public void insert(CustomerAccount customerAccount) {
		try {
			Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			String sql = "insert into tb_customer_account "
					+ "(cpf_cnpj, nm_customer, is_active, vl_total) "
					+ "values(?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerAccount.getCpfCnpj());
			preparedStatement.setString(2, customerAccount.getNome());
			preparedStatement.setBoolean(3, customerAccount.isAtivo());
			preparedStatement.setDouble(4, customerAccount.getValorTotal());
			
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<CustomerAccount> buscarTodos() {
		List<CustomerAccount> result = new ArrayList<CustomerAccount>();
		try {
			Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			String sql = "select * from tb_customer_account "
					+ "order by vl_total desc ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				CustomerAccount ca = new CustomerAccount();
				ca.setId(resultSet.getLong("id_customer"));
				ca.setCpfCnpj(resultSet.getString("cpf_cnpj"));
				ca.setNome(resultSet.getString("nm_customer"));
				ca.setAtivo(resultSet.getBoolean("is_ativo"));
				ca.setValorTotal(resultSet.getDouble("vl_total"));
				result.add(ca);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
}
