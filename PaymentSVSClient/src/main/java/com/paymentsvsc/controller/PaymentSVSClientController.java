package com.paymentsvsc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paymentsvsc.service.PaymentSVSClient;
import com.paymentsvsc.svss.model.PaymentSVSSInfo;

@RestController
public class PaymentSVSClientController {

	@Autowired
	private PaymentSVSClient paymentSVSClient;

	@GetMapping("/clientInfo")
	public List<PaymentSVSSInfo> getAllInfos() {
		return paymentSVSClient.getAllInfo();
	}

	@GetMapping("/clientInfo/{Id}")
	public PaymentSVSSInfo getSelectedIds(@PathVariable String Id) {

		return paymentSVSClient.getSelectedId(Id);
	}

	@PostMapping("/clientInfo")
	public void addGiftCard(@Valid @RequestBody PaymentSVSSInfo paymentSVSSInfo) {
		paymentSVSClient.addGiftCard(paymentSVSSInfo);
	}

	@PutMapping("/clientInfo/{id}")
	public void updateGiftCard(@RequestBody PaymentSVSSInfo paymentSVSSInfo, @PathVariable String id) {
		paymentSVSClient.updateGiftCard(id, paymentSVSSInfo);
	}

	@DeleteMapping("/clientInfo/{id}")
	public void deleteGiftCard(@PathVariable String id) {
		paymentSVSClient.deleteGiftCard(id);
	}

}