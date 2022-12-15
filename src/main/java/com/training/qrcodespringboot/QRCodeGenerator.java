package com.training.qrcodespringboot;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
	public static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException
	{
		QRCodeWriter qrCode = new QRCodeWriter();
		BitMatrix bitMatrix = qrCode.encode(text, BarcodeFormat.QR_CODE, width, height);
		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
	}
	
	public static byte[] generateQRCodeByteImage(String text, int width, int height, String filePath) throws WriterException, IOException
	{
		QRCodeWriter qrCode =  new QRCodeWriter();
		BitMatrix bitMatrix = qrCode.encode(text, BarcodeFormat.QR_CODE, width, height);
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArray);
		byte[] byteData = byteArray.toByteArray();
		return byteData;
	}

}
