package com.paymentsvsc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paymentsvsc.svss.model.PaymentSVSSInfo;

@Service
public class PaymentSVSClient {
	private PaymentSVSSInfo paymentSVSSInfo;
	private List<PaymentSVSSInfo> paymentsvsInfo = new ArrayList<>(
			Arrays.asList(new PaymentSVSSInfo("G1", "Ross", "11234.09", "986458999", "02/01/1996"),
					new PaymentSVSSInfo("G2", "Chandler", "19087", "9876543235", "02-01-1997"),
					new PaymentSVSSInfo("G3", "Joey", "18976", "9897645322", "02-01-1998"),
					new PaymentSVSSInfo("G4", "Monica", "88876", "9897645902", "02-01-1999"),
					new PaymentSVSSInfo("G5", "Rachel", "11976", "9877645392", "02-01-2000")));

	public List<PaymentSVSSInfo> getAllInfo() {
		return paymentsvsInfo;
	}
	public PaymentSVSSInfo getSelectedId(String Id) {
		paymentSVSSInfo = paymentsvsInfo.stream().filter(t -> t.getId().equalsIgnoreCase(Id)).findFirst().get();
		return paymentSVSSInfo;
	}
	public void addGiftCard(PaymentSVSSInfo paymentSVSSInfo) {
		paymentsvsInfo.add(paymentSVSSInfo);
	}
	public void updateGiftCard(String id, PaymentSVSSInfo paymentSVSSInfo) {
		for (int i = 0; i < paymentsvsInfo.size(); i++) {
			PaymentSVSSInfo p = paymentsvsInfo.get(i);
			if (p.getId().equals(id)) {
				paymentsvsInfo.set(i, paymentSVSSInfo);
			}
		}
	}
	public boolean deleteGiftCard(String id) {
		return paymentsvsInfo.removeIf(t -> t.getId().equals(id));

	}
}
