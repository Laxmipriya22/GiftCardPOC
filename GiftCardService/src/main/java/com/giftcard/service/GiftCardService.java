package com.giftcard.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.giftcard.exceptions.GiftCardServiceException;
import com.giftcard.model.GiftcardInfo;
import com.svss.model.PaymentSVSSInfo;

@Service
public class GiftCardService {
	Logger logger = LogManager.getLogger(GiftCardService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	private PaymentSVSSInfo paymentSVSSInfo;
	final String url = "http://localhost:8088/clientInfo/";

	public GiftcardInfo getGiftCardInfo(String Id) {
		try {
			final String Geturl = url + Id + "/";
			paymentSVSSInfo = restTemplate.getForObject(Geturl, PaymentSVSSInfo.class);
			GiftcardInfo giftCardInfo = dozerBeanMapper.map(paymentSVSSInfo, GiftcardInfo.class);
			return giftCardInfo;
		} catch (HttpServerErrorException e) {
			logger.error(e);
			throw new GiftCardServiceException("Given Id " + Id + " is Invalid");
		} catch (MappingException e) {
			logger.error(e);
			throw new GiftCardServiceException(
					"Dozer Mapping Exception... Please verify the mappings. Make sure source object must not be null");
		} catch (Exception e) {
			logger.error(e);
			throw new GiftCardServiceException("Exception", e);
		}

	}

	public void addGiftCard(GiftcardInfo giftcardInfo) {
		try {
			PaymentSVSSInfo paymentSVSSInfo = dozerBeanMapper.map(giftcardInfo, PaymentSVSSInfo.class);
			restTemplate.postForObject(url, paymentSVSSInfo, PaymentSVSSInfo.class);
		} catch (HttpMessageNotReadableException e) {
			logger.error(e);
			throw new GiftCardServiceException(e);
		} catch (MappingException e) {
			logger.error(e);
			throw new GiftCardServiceException("Dozer Mapping Exception... Please verify the mappings. Make sure source object must not be null");
		}
	}
	public void updateGiftCard(String id, GiftcardInfo giftcardInfo) {
		try {
		final String Geturl = url + id + "/";
		PaymentSVSSInfo paymentSVSSInfo = dozerBeanMapper.map(giftcardInfo, PaymentSVSSInfo.class);
		restTemplate.put(Geturl, paymentSVSSInfo);
		}catch (MappingException e) {
			logger.error(e);
			throw new GiftCardServiceException("Dozer Mapping Exception... Please verify the mappings. Make sure source object must not be null");	
		}
	}
	public void deleteGiftCard(String id) {
		final String Geturl = url + id + "/";
		restTemplate.delete(Geturl);

	}

}
