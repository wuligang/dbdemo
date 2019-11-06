package com.excel.controller;

import com.alibaba.fastjson.JSONObject;
import com.excel.com.excel.entity.SheetField;
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
import java.util.ArrayList;
import java.util.List;

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
    public String multipleFiles(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        if (null == file) {
            return null;
        }
        InputStream is = null;
        List<SheetField> first_list = new ArrayList<SheetField>();
        List<SheetField> second_list = new ArrayList<SheetField>();
            try {
                is = file.getInputStream();
                Workbook wb = Workbook.getWorkbook(is);
                // Excel的页签数量
                //int sheet_size = wb.getNumberOfSheets();
                //第一个sheet
                Sheet first_sheet = wb.getSheet(0);
                Sheet second_sheet = wb.getSheet(1);
                //数据从第八行开始

                for (int i = 7; i < first_sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    //JSONObject obj = new JSONObject();
                    String month = first_sheet.getCell(0, i).getContents();
                    String day = first_sheet.getCell(1, i).getContents();
                    String pzhs = first_sheet.getCell(2, i).getContents();
                    String zy = first_sheet.getCell(3, i).getContents();
                    String jf = first_sheet.getCell(4, i).getContents();
                    String df = first_sheet.getCell(5, i).getContents();
                    String fx = first_sheet.getCell(6, i).getContents();
                    String ye = first_sheet.getCell(7, i).getContents();
                    //obj.put(String.valueOf(j), cellinfo);
                    SheetField sf = new SheetField(month,day,pzhs,zy,jf,df,fx,ye);
                    first_list.add(sf);
                }

                for (int i = 6; i < second_sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    //JSONObject obj = new JSONObject();
                    String month = second_sheet.getCell(0, i).getContents();
                    String day = second_sheet.getCell(1, i).getContents();
                    String pzhs = second_sheet.getCell(2, i).getContents();
                    String zy = second_sheet.getCell(3, i).getContents();
                    String jf = second_sheet.getCell(4, i).getContents();
                    String df = second_sheet.getCell(5, i).getContents();
                    String fx = second_sheet.getCell(6, i).getContents();
                    String ye = second_sheet.getCell(7, i).getContents();
                    //obj.put(String.valueOf(j), cellinfo);
                    SheetField sf = new SheetField(month,day,pzhs,zy,jf,df,fx,ye);
                    second_list.add(sf);
                }
                System.out.println(first_list);
                System.out.println(second_list);
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
            }

            //数据多的话可能比较费时间，需要优化一下
        for (SheetField sf : first_list) {
            for (SheetField sf2 : second_list) {
                if(sf.equals(sf2)){
                    first_list.remove(sf);
                }
            }
        }
        //去除重复的数据
        System.out.println(first_list);

        return "多文件上传成功";
    }
}