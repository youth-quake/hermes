package com.youthquake.youthquake.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.youthquake.youthquake.model.UsuarioModel;

public class HistoricalAcess {

	private static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static void writeAccess(UsuarioModel user) throws IOException {

		FileWriter fileWriter = new FileWriter("historico.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);

		String[][] titles = new String[3][2];
		String type = "[INFO]";

		for (int i = 0; i < titles.length; i++) {
			titles[i][0] = user.getLogin();
			titles[i][1] = getDateTime();

			if (i >= titles.length) titles = new String[3][2];
		}

		for (int i = 0; i < titles.length; i++) {
			String completeAccess = String.format("%s - [%s] [%s]", type, titles[i][0], titles[i][1]);
			printWriter.printf(completeAccess);
			fileWriter.close();
		}
	}
}
