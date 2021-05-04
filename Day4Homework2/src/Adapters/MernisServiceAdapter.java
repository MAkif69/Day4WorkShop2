package Adapters;

import java.rmi.RemoteException;

import Abstract.ICustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements ICustomerCheckService {

	@SuppressWarnings("deprecation")
	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		KPSPublicSoapProxy soapClient=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			return soapClient.TCKimlikNoDogrula(Long.parseLong(customer.NationalityId),customer.FirstName.toUpperCase(), 
					customer.LastName.toUpperCase(), customer.DateOfBirth.getYear());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}	

}
