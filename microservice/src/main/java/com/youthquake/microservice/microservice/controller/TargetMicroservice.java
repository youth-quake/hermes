package com.youthquake.microservice.microservice.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Resource;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.opencsv.CSVWriter;
import com.youthquake.microservice.microservice.domain.Target;

@Component
@RestController
public class TargetMicroservice {

	private RestTemplate rest;
	private String url;

	public TargetMicroservice() {
		rest = new RestTemplate();
		//url = "http://localhost:8080/target/microservice";
		url = "https://serviceyouthquake.azurewebsites.net/target/microservice";
	}
	
	@RequestMapping(path="/downloadcsv", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> getTargetUserToCSV() throws IOException {
		Target[] t = this.rest.getForObject(url, Target[].class);
		
		File file = new File("C:\\Users\\Aluno\\Desktop\\Youthquake-targets.csv");
		
		FileWriter writer = new FileWriter(file, true);
		CSVWriter csv = new CSVWriter(writer, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
		CSVWriter.DEFAULT_LINE_END);

		csv.writeNext(new String[] { "ID_target", "Description", "Date_Start", "Date_End", "Name", "Percentage",
				"Value", "Value_Accumulated" });

		for (Target targets : t) {
			csv.writeNext(new String[] { targets.getIdTarget(), targets.getDescription(), targets.getDtStart(),
					targets.getDtEnd(), targets.getName(), targets.getPercentage(), targets.getValue(),
					targets.getValueAccumulated() });
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Youthquake-targets.csv");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");
		
        csv.close();
        
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        
        return ResponseEntity.ok()
        		.headers(header)
        		.contentLength(file.length())
        		.contentType(MediaType.parseMediaType("application/octet-stream"))
        		.body(resource);
	}
}
