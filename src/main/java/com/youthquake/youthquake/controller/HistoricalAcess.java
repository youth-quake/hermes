package com.youthquake.youthquake.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.youthquake.youthquake.model.UsuarioModel;

public class HistoricalAcess {

	static String[][] titles = new String[10][2];
	static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	static Calendar date;

	public HistoricalAcess(UsuarioModel user) {

		String type = "[INFO]";

		for (int i = 0; i < titles.length; i++) {
			titles[i][0] = user.getLogin();
			date = Calendar.getInstance();
			titles[i][1] = dateFormat.format(date);

			if (i >= titles.length)
				titles = new String[10][2];
		}

		for (int i = 0; i < titles.length; i++) {
			String completeAccess = String.format("%s - [%s] [%s]", type, titles[i][0], titles[i][1]);
			writeAccessHistorial(completeAccess, titles[i][1]);
		}

	}

	public static void writeAccessHistorial(String content, String date) {
		try {
			File file = new File(String.format("historico-acesso-%s.txt", date));

			if (!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
