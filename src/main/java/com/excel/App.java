package com.excel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
		/*App obj = new App();
		// 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
		File file = new File("C:\\Users\\Administrator\\Desktop\\鹤壁烟草局财务对账工具\\data1.xls");
		obj.readExcel(file);*/
        SpringApplication.run(App.class, args);
    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
	/*public void readExcel(File file) {
		try {
			List<JSONObject> list = new ArrayList<JSONObject>();
			// 创建输入流，读取Excel
			InputStream is = new FileInputStream(file.getAbsolutePath());
			// jxl提供的Workbook类
			Workbook wb = Workbook.getWorkbook(is);
			// Excel的页签数量
			int sheet_size = wb.getNumberOfSheets();
			for (int index = 0; index < sheet_size; index++) {
				// 每个页签创建一个Sheet对象
				Sheet sheet = wb.getSheet(index);
				// sheet.getRows()返回该页的总行数
				for (int i = 0; i < sheet.getRows(); i++) {
					// sheet.getColumns()返回该页的总列数
					JSONObject obj = new JSONObject();
					for (int j = 0; j < sheet.getColumns(); j++) {
						String cellinfo = sheet.getCell(j, i).getContents();
						obj.put(String.valueOf(j), cellinfo);
					}
					list.add(obj);
				}
			}
			
			System.out.println(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
