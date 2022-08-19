package ReadExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFlipkart
{
    public Vector readexcelfile(){

        Vector cellvectorholder = new Vector();
        try
        {
            File file = new File("C:\\Users\\abhat357\\Automation\\ODS-QA-Automation-serenity-framework\\MavenSelenium\\src\\test\\resources\\Input.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet worksheet = workbook.getSheetAt(0);
            int lastcolindex = worksheet.getRow(0).getLastCellNum();

            System.out.println("Total data is "+lastcolindex);

            Iterator itr = worksheet.rowIterator();

            while(itr.hasNext()) {

                XSSFRow row = (XSSFRow) itr.next();
                Vector cellvector = new Vector<>();

                for(int i=0;i<lastcolindex;i++)
                {
                    XSSFCell cell = row.getCell(i);
                    System.out.println("Cell number is " + cell);
                    cellvector.addElement(cell);

                }
                    cellvectorholder.addElement(cellvector);

                }


            }

        catch (Exception e){
            e.printStackTrace();
        }
        return cellvectorholder;

    }





}
