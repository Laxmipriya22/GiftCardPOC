package com.giftcard.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.giftcard.model.GiftcardInfo;
import com.giftcard.service.GiftCardService;

@RestController
public class GiftCardController {

	@Autowired
	private GiftCardService giftCardService;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Profile("${spring.profiles.active}")
	@GetMapping("/giftcardInfo/{Id}")
	public GiftcardInfo getSelectProdId(@PathVariable String Id) {
		//Add Validations and include Exception handling
		return giftCardService.getGiftCardInfo(Id);
	}

	@PostMapping("/giftcardInfo")
	public void addGiftCard(@RequestBody GiftcardInfo giftcardInfo) {
		giftCardService.addGiftCard(giftcardInfo);
	}

	@PutMapping("/giftcardInfo/{id}")
	public void updateGiftCard(@RequestBody GiftcardInfo giftcardInfo, @PathVariable String id) {
		giftCardService.updateGiftCard(id, giftcardInfo);

	}

	@DeleteMapping("/giftcardInfo/{id}")
	public void deleteGiftCard(@PathVariable String id) {
		giftCardService.deleteGiftCard(id);
	}

}
