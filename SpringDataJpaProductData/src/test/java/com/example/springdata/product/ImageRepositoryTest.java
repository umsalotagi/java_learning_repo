package com.example.springdata.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdata.product.files.entities.Image;
import com.example.springdata.product.files.repos.ImageRepository;

@SpringBootTest
public class ImageRepositoryTest {
	
	@Autowired
	ImageRepository imageRepository;
	
	// DataIntegrityViolationException for image of size 400Kb, for 8Kb image it worked.
	@Test
	void testImageSave() throws IOException {
		Image i = new Image();
		i.setId(1L);
		i.setName("maven.jpg");
		
		File f = new File("/Users/usalotagi/Downloads/my_image.jpg");
		byte [] fileContent = new byte[(int) f.length()];
		try(FileInputStream inputStream = new FileInputStream(f)) {
			inputStream.read(fileContent);
			
			i.setData(fileContent);
			
			imageRepository.save(i);
		}
		
	}
	
	@Test
	void testReadImage() {
		Image image = imageRepository.findById(1L).get();
		System.out.println(image.getName() + " and "+ image.getId());
		File f = new File("/Users/usalotagi/Downloads/downlaoded-"+image.getName());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			fos.write(image.getData());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
