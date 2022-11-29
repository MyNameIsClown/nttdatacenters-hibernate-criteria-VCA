package com.nttdata.hibernate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Client;
import com.nttdata.persistence.Contract;
import com.nttdata.services.ClientManagmentServiceI;
import com.nttdata.services.ClientManagmentServiceImpl;
import com.nttdata.services.ContractManagmentServiceI;
import com.nttdata.services.ContractManagmentServiceImpl;

/**
 * Clase principal
 * 
 * @author Victor Carrasco
 *
 */
public class NTTDATAMain {
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Inicializamos la sesion
		final Session mySession = NTTDataHibernateUtil.getSessionFactory().openSession();
		
		// Se da de alta los servicios
		final ClientManagmentServiceI clientService = new ClientManagmentServiceImpl(mySession);
		final ContractManagmentServiceI contractService = new ContractManagmentServiceImpl(mySession);
		
		// Parametros de auditoria
		final String username = "Victor";
		final Date changesDate = Date.valueOf(LocalDate.now());
		
		// Creacion de los clientes
		Client cliente1 = new Client();
		cliente1.setName("Juan");
		cliente1.setSurname("Lopez");
		cliente1.setSecondSurname("Lopez");
		cliente1.setDni("12345678V");
		cliente1.setAudit(username, changesDate);

		
		Client cliente2 = new Client();
		cliente2.setName("Mario");
		cliente2.setSurname("Ballano");
		cliente2.setSecondSurname("Velazquez");
		cliente2.setDni("81763433F");
		cliente2.setAudit(username, changesDate);

		
		Client cliente3 = new Client();
		cliente3.setName("Lola");
		cliente3.setSurname("Marquez");
		cliente3.setSecondSurname("del Rosario");
		cliente3.setDni("11134985G");
		cliente3.setAudit(username, changesDate);

		
		// Creacion de los contratos
		Contract contract1 = new Contract();
		contract1.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 11, 16)));
		contract1.setExpirityDate(Date.valueOf(LocalDate.of(2022, 12, 14)));
		contract1.setPrice(300);
		contract1.setClient(cliente2);
		contract1.setAudit(username, changesDate);
		
		Contract contract2 = new Contract();
		contract2.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 9, 6)));
		contract2.setExpirityDate(Date.valueOf(LocalDate.of(2022, 12, 30)));
		contract2.setPrice(500);
		contract2.setClient(cliente2);
		contract2.setAudit(username, changesDate);
		
		Contract contract3 = new Contract();
		contract3.setEffectiveDate(Date.valueOf(LocalDate.of(2021, 11, 1)));
		contract3.setExpirityDate(Date.valueOf(LocalDate.of(2022, 11, 14)));
		contract3.setPrice(650);
		contract3.setClient(cliente1);
		contract3.setAudit(username, changesDate);
		
		Contract contract4 = new Contract();
		contract4.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 12, 1)));
		contract4.setExpirityDate(Date.valueOf(LocalDate.of(2023, 5, 14)));
		contract4.setPrice(120);
		contract4.setClient(cliente1);
		contract4.setAudit(username, changesDate);
		
		Contract contract5 = new Contract();
		contract5.setEffectiveDate(Date.valueOf(LocalDate.of(2022, 3, 19)));
		contract5.setExpirityDate(Date.valueOf(LocalDate.of(2022, 8, 14)));
		contract5.setPrice(380);
		contract5.setClient(cliente3);
		contract5.setAudit(username, changesDate);
		
		clientService.insertClient(cliente1);
		clientService.insertClient(cliente2);
		clientService.insertClient(cliente3);
		
		contractService.insertContract(contract1);
		contractService.insertContract(contract2);
		contractService.insertContract(contract3);
		contractService.insertContract(contract4);
		contractService.insertContract(contract5);
		
		// Consultas
		
		List<Client> clientesRegistrados = clientService.listAll();
		
		System.out.println(clientesRegistrados);
		
		System.out.println(clientService.listByFullName("Juan", "Lopez", "Lopez"));
		
		System.out.println(contractService.listByPrice(300));
		
		
		
	}
}
