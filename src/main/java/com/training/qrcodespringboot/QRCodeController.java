package com.training.qrcodespringboot;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;


@RestController
public class QRCodeController {
	
private static final String imagePath = "./src/main/resources/QRCode.png";
	
	@GetMapping(value="/generateQRCode/{text}/{width}/{height}")
	public String qrCodeDownload(@PathVariable("text")String text, 
			@PathVariable("width") Integer width, 
			@PathVariable("height") Integer height) throws Exception
	{
		QRCodeGenerator.generateQRCodeImage(text, width, height, imagePath) ;
		return "QRCOde Generated";
	}
	
	@GetMapping(value="/generateQRCodeByte/{text}/{width}/{height}")
	public ResponseEntity<byte[]> qrCodeDownloadByte(@PathVariable("text") String text,
			@PathVariable("width") int width,
			@PathVariable ("height") int height) throws WriterException, IOException
	{
		return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.generateQRCodeByteImage(text, width, height, imagePath));
	}
	

}
