package com.apache.pdfbox.ocr.tesseract;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import junit.framework.TestCase;

public class TessByteSteamTest extends TestCase{
	TessBaseAPI api;
	public void testByteStram(){
		try {
			PDDocument document = PDDocument.load("src/main/resources/samples/pdf1.pdf");
			PDFRenderer renderer = new PDFRenderer(document);
			BufferedImage image = renderer.renderImage(0, 3);
			int width = image.getWidth();
			int height = image.getHeight();
			int bpp = 3;
			int bpl = width*3;
			
			
			api = new TessBaseAPI();
			
			byte data[] = api.getByteStream(image);
			boolean init = api.init("src/main/resources/data", "eng");
			api.setImage(data, width, height, bpp, bpl);
			String text = api.getUTF8Text();
			System.out.println(text);
			api.end();
			assertEquals(init, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
