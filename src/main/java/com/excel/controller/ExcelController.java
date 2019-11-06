package com.excel.controller;

import com.alibaba.fastjson.JSONObject;
import jxl.Sheet;
import jxl.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * @author wlg
 * @version V1.0
 * @Package com.excel.controller
 * @date 2019/11/6 0006 17:10
 * @Copyright © 2019-2020 河南讯众科技有限公司
 */
@Controller
public class ExcelController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelController.class);
    @RequestMapping("/multipleFiles")
    public String multipleFiles(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        //List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        if (null == files && files.length == 0) {
            return null;
        }
        InputStream is = null;
        for (MultipartFile mf : files) {
            try {
                is  = mf.getInputStream();
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
            }catch (Exception e){
                LOGGER.info(e.getMessage());
            }

        }
        return "多文件上传成功";
    }
}