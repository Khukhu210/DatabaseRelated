package com.covid.data.service;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.data.entity.Country;
import com.covid.data.entity.District;
import com.covid.data.entity.State;
import com.covid.data.repository.CountryRepository;

@Service
public class CountryService {

	private Logger logger = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryRepository countryRepository;

	private void setCountryValues(Country country, int columnIndex, Cell cell) {
		if (columnIndex == 0) {
			country.setCountryName(cell.getStringCellValue());
		} else if (columnIndex == 1) {
			country.setCovidConfirmed((long) cell.getNumericCellValue());
		} else if (columnIndex == 2) {
			country.setCovidActive((long) cell.getNumericCellValue());
		} else if (columnIndex == 3) {
			country.setCovidRecovered((long) cell.getNumericCellValue());
		}

		else {
			country.setCovidDeceased((long) cell.getNumericCellValue());
		}
	}

	private void setStateValues(State state, int columnIndex, Cell cell) {

		if (columnIndex == 1) {
			state.setStateName(cell.getStringCellValue());
		} else if (columnIndex == 3) {
			state.setCovidConfirmed((long) cell.getNumericCellValue());
		} else if (columnIndex == 4) {
			state.setCovidActive((long) cell.getNumericCellValue());
		} else if (columnIndex == 5) {
			state.setCovidRecovered((long) cell.getNumericCellValue());
		}

		else if (columnIndex == 6)
			state.setCovidDeceased((long) cell.getNumericCellValue());

	}

	private void setDistrictValues(District district, int columnIndex, Cell cell)

	{

		if (columnIndex == 2) {
			district.setDistrictName(cell.getStringCellValue());
		} else if (columnIndex == 3) {
			district.setCovidConfirmed((long) cell.getNumericCellValue());
		} else if (columnIndex == 4) {
			district.setCovidActive((long) cell.getNumericCellValue());
		} else if (columnIndex == 5) {
			district.setCovidRecovered((long) cell.getNumericCellValue());
		}

		else if (columnIndex == 6)
			district.setCovidDeceased((long) cell.getNumericCellValue());

	}

	public void readCountryCovidData() {
		try {
			FileInputStream file = new FileInputStream(new File(".\\ExcelSheetData\\COVID_DATA.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			Country country = new Country();
			List<State> stateList = new ArrayList<State>();

			int rowIndex = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				int columnIndex = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (rowIndex != 0)
						setCountryValues(country, columnIndex, cell);

					columnIndex++;
				}

				rowIndex++;
			}

			for (int i = 1; i < workbook.getNumberOfSheets(); i++) {
				State state = new State();
				readStateCovidData(state, workbook.getSheetAt(i));
				stateList.add(state);
				state.setCountry(country);

			}

			country.setState(stateList);

			countryRepository.persistCountryData(country);

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readStateCovidData(State state, XSSFSheet sheet)

	{

		List<District> listDistrict = new ArrayList<District>();

		try {

			Iterator<Row> rowIterator = sheet.iterator();

			int rowIndex = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();

				District district = null;

				if (rowIndex >= 2) {
					district = new District();
					district.setState(state);

				}
				int columnIndex = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (rowIndex == 1) {
						setStateValues(state, columnIndex, cell);

					} else if (rowIndex >= 2) {

						setDistrictValues(district, columnIndex, cell);

					}
					columnIndex++;
				}

				if (rowIndex >= 2)
					listDistrict.add(district);

				rowIndex++;

			}
			state.setDistricts(listDistrict);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}