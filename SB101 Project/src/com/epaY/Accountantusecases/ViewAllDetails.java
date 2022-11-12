package com.epaY.Accountantusecases;

import java.util.List;

import com.epaY.Dao.AccountantDao;
import com.epaY.Dao.AccountantDaoImp;
import com.epaY.Exceptions.AccountantException;
import com.epaY.beans.CustomerDetails;

public class ViewAllDetails {

	public static void ViewAccounts() {
		AccountantDao dao= new AccountantDaoImp();
		try {
			List<CustomerDetails> list=dao.ViewAllAccounts();
			list.forEach(s->System.out.println(s));
		} catch (AccountantException e) {
			e.printStackTrace();
		}

	}

}
