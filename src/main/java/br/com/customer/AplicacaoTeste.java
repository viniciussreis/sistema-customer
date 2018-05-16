package br.com.customer;

import java.util.ArrayList;
import java.util.List;

import br.com.customer.dao.CustomerAccountDao;
import br.com.customer.entity.CustomerAccount;

public class AplicacaoTeste {

	public static void main(String[] args) {
		CustomerAccount ca1 = new CustomerAccount("11111111111", "Customer 1", true, 100.0);
		CustomerAccount ca2 = new CustomerAccount("22222222222", "Customer 2", true, 200.0);
		CustomerAccount ca3 = new CustomerAccount("33333333333", "Customer 3", true, 300.0);
		CustomerAccount ca4 = new CustomerAccount("44444444444", "Customer 4", false, 400.0);
		CustomerAccount ca5 = new CustomerAccount("55555555555", "Customer 5", false, 500.0);
		
		CustomerAccountDao dao = new CustomerAccountDao();
		dao.insert(ca1);
		dao.insert(ca2);
		dao.insert(ca3);
		dao.insert(ca4);
		dao.insert(ca5);
		
		List<CustomerAccount> listCustomerAccount = dao.buscarTodos();
		List<CustomerAccount> listCustomerAccountMedia = new ArrayList<CustomerAccount>();
		
		Double valorTotal = 0.0;
		for (CustomerAccount ca : listCustomerAccount) {	
			if (ca.getId() >= 1500 && ca.getId() <= 2700 && ca.getValorTotal() > 560) {
				valorTotal += ca.getValorTotal();
				listCustomerAccountMedia.add(ca);
			}
		}
		Double valorTotalMedio = valorTotal / (listCustomerAccountMedia.size() + 1);
		System.out.println(valorTotalMedio);
		
		for (CustomerAccount ca : listCustomerAccountMedia) {
			System.out.println(ca.getNome() + " " + ca.getCpfCnpj() + " " + ca.getValorTotal() + " " + ca.isAtivo());
		}
		
	}

}