package com.youthquake.microservice.microservice.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.opencsv.CSVWriter;
import com.youthquake.microservice.microservice.domain.Movements;
import com.youthquake.microservice.microservice.domain.Target;

@Component
@RestController
public class MovementsMicroservice {

	private RestTemplate rest;
	private String url;

	public MovementsMicroservice() {
		rest = new RestTemplate();
		url = "https://serviceyouthquake.azurewebsites.net/movements/microservice/";
	}

	@RequestMapping(path = "movements/download/{idUser}", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> getTargetUserToCSV(@PathVariable long idUser) throws IOException {
		Movements[] m = this.rest.getForObject(url+idUser, Movements[].class);

		File file = new File("Youthquake-MyMovements.csv");

		// deleta arquivo após ele ser baixado para evitar "repetições" xD
		if (file.exists()) {
			file.delete();
		}

		FileWriter writer = new FileWriter(file, true);
		CSVWriter csv = new CSVWriter(writer, ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
				CSVWriter.DEFAULT_LINE_END);

		csv.writeNext(new String[] { "ID", "Valor da Movimentacao", "Tipo", "Referencia" });

		for (Movements movements : m) {
			csv.writeNext(new String[] { movements.getIdMovement(), "R$"+movements.getValue(), movements.getType(),
					movements.getReference()});
		}

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Youthquake-MyMovements.csv");
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");

		csv.close();

		Path path = Paths.get(file.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		return ResponseEntity.ok().headers(header).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	}
}
