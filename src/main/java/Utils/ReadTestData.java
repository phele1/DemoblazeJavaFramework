package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadTestData {
    String homeDir =System.getProperty("user.dir");

    String testdataDir =homeDir+"/src/main/java/TestData/DemoblazeTestData.xlsx";

    FileInputStream fis = new FileInputStream(testdataDir);

    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    public ReadTestData() throws IOException {
    }

    XSSFSheet sheet = workbook.getSheetAt(0);

    public String name=sheet.getRow(1).getCell(0).getStringCellValue();
    public String country=sheet.getRow(1).getCell(1).getStringCellValue();
    public String city=sheet.getRow(1).getCell(2).getStringCellValue();
    public String creditcard= String.valueOf(sheet.getRow(1).getCell(3).getNumericCellValue());
    public String month=sheet.getRow(1).getCell(4).getStringCellValue();
    public String year= String.valueOf(sheet.getRow(1).getCell(5).getNumericCellValue());

}
