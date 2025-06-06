package com.ipartek.formacion.springapp.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudinary.Cloudinary;
import com.cloudinary.Configuration;

@RestController
@RequestMapping("/api/v2/cloudinary")
public class CloudinaryRest {
	@Value("${cloudinary.url}")
	private String cloudinaryUrl;

	@Value("${cloudinary.api.secret}")
	private String cloudinarySecret;

	@GetMapping("/firma")
	public String firma(Long timestamp, @RequestParam("public_id") String publicId) {
		Cloudinary cloudinary = new Cloudinary(Configuration.from(cloudinaryUrl));

		var opciones= new HashMap<String, Object>();
		
		opciones.put("public_id", publicId);
		opciones.put("timestamp", timestamp);
		opciones.put("upload_preset", "springapp-seguro");
		
		System.out.println(opciones);
		System.out.println(cloudinaryUrl);
		System.out.println(cloudinarySecret);

		return '"' + cloudinary.apiSignRequest(opciones, cloudinarySecret) + '"';
	}
}
