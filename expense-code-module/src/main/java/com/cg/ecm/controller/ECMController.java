package com.cg.ecm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecm.entity.ExpenseDetails;
import com.cg.ecm.exception.ECMException;
import com.cg.ecm.service.ECMService;

@RestController
@RequestMapping(value = "/")
public class ECMController {
	//private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ECMService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ExpenseDetails addDetails(
			@Valid @RequestBody ExpenseDetails expdetails) throws ECMException {
		return service.addDetails(expdetails);

	}

	@RequestMapping(value = "/readExpense", method = RequestMethod.GET)
	public List<ExpenseDetails> getAllDetails() throws ECMException {
		return service.getAllDetails();
	}

	@RequestMapping(value = "/read/{expenseCode}", method = RequestMethod.GET)
	public ExpenseDetails getByCode(@PathVariable int expenseCode) throws ECMException {
		ExpenseDetails detail=service.getByCode(expenseCode);
		if(detail==null){
			throw new ECMException("Expense code '" +expenseCode+"' doesn't exist to fetch");
		}
		return service.getByCode(expenseCode);

	}

	@RequestMapping(value = "/delete/{expenseCode}", method = RequestMethod.DELETE)
	public ExpenseDetails DeleteByCode(@PathVariable int expenseCode) throws ECMException {
		ExpenseDetails detail= service.DeleteByCode(expenseCode);
		if(detail==null){
			throw new ECMException("Expense code '" +expenseCode+"' doesn't exist to delete");
		}
		return service.DeleteByCode(expenseCode);
	}

	@RequestMapping(value = "/update/{expenseCode}", method = RequestMethod.PUT)
	public ExpenseDetails modify(@PathVariable int expenseCode,@RequestBody ExpenseDetails expdetails) throws ECMException  {
		ExpenseDetails detail=getByCode(expenseCode);
		detail.setExpenseCode(expenseCode);
		System.out.println(expenseCode);
		return service.updateDetails(expdetails);

	}

}
