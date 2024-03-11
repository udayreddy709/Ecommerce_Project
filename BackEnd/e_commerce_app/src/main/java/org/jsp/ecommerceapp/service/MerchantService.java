package org.jsp.ecommerceapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.ecommerceapp.dao.MerchantDao;
import org.jsp.ecommerceapp.dto.ResponseStructure;
import org.jsp.ecommerceapp.exception.IdNotFoundException;
import org.jsp.ecommerceapp.exception.InvalidCredentialsException;
import org.jsp.ecommerceapp.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<Merchant> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setMessage("merchant saved");
		structure.setBody(merchantDao.saveMerchant(merchant));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<Merchant>(HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		Optional<Merchant> recMerchant = merchantDao.findById(merchant.getId());
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			Merchant dbMerchant = recMerchant.get();
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setName(merchant.getName());
			dbMerchant.setGst_number(merchant.getGst_number());
			dbMerchant.setPhone(merchant.getPhone());
			dbMerchant.setPassword(merchant.getPassword());
			structure.setMessage("Merchant Updated");
			structure.setBody(merchantDao.saveMerchant(merchant));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Merchant>> findById(int id) {
		Optional<Merchant> recMerchant = merchantDao.findById(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setBody(recMerchant.get());
			structure.setMessage("Merchant Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}

		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		Optional<Merchant> recMerchant = merchantDao.findById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Merchant found");
			structure.setBody("Merchant deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			merchantDao.deleteById(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("Merchant Not found");
		structure.setBody("cannot delete merchant as Id is Invalid");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseStructure<List<Merchant>> findAll() {
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();
		structure.setMessage("List of Merchants");
		structure.setBody(merchantDao.findAll());
		structure.setStatusCode(HttpStatus.OK.value());
		return structure;
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(long phone, String password) {
		Optional<Merchant> recMerchant = merchantDao.verify(phone, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setBody(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("invalid phone or password");
	}

	public ResponseEntity<ResponseStructure<List<Merchant>>> findByName(String name) {
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();
		List<Merchant> merchants = merchantDao.findByName(name);
		structure.setBody(merchants);
		if (merchants.size() > 0) {
			structure.setMessage("List of Merchants with entered name ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure, HttpStatus.OK);
		}
		structure.setMessage("No Merchant found with the entered name ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure, HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(String email, String password) {
		Optional<Merchant> recMerchant = merchantDao.verify(email, password);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recMerchant.isPresent()) {
			structure.setMessage("Verification Succesfull");
			structure.setBody(recMerchant.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException("invalid email or password");
	}

}
