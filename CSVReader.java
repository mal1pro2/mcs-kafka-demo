package com.gm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {

		String csvFile = "F:\\data.csv";
		String line = "";
		String cvsSplitBy = ",";

		int rowNumber = 1;
		int ENROLL_UN_ENROLL_COLUM = 3;

		String enrollment = "F:\\enrollment.csv";
		String unenrollment = "F:\\unenrollment.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			BufferedWriter enrollmentWriter = new BufferedWriter(new FileWriter(enrollment));
			BufferedWriter unenrollmentWriter = new BufferedWriter(new FileWriter(unenrollment));

			while ((line = br.readLine()) != null) {
				if (rowNumber == 1) {
					enrollmentWriter.write(line);
					unenrollmentWriter.write(line);

					enrollmentWriter.append('\n');
					unenrollmentWriter.append('\n');

				} else {
					String enrollUnEnroll = line.split(cvsSplitBy)[ENROLL_UN_ENROLL_COLUM];
					// use comma as separator
					if ("UNENROLL".equalsIgnoreCase(enrollUnEnroll)) {
						unenrollmentWriter.write(line);
						unenrollmentWriter.append('\n');

					} else {
						enrollmentWriter.write(line);
						enrollmentWriter.append('\n');
					}
				}
				rowNumber++;
			}

			enrollmentWriter.close();
			unenrollmentWriter.close();

			System.out.print("File Processesing Succesfully Writting Numbeer of Line = " + rowNumber);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
