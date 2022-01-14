package org.example.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateConverter implements Converter<String, Date> {
    //param:s代表的就是配置文件中的date  <value>2022-1-14</value>
    //return 当把Date转换好后作为方法的返回值返回，spring会自动为birthday属性注入
    //进行配置在spring文件配置
//    @Override
//    public Date convert(String s) {
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//
//        Date date= null;
//        try {
//            date = simpleDateFormat.parse(s);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return date;
//
//
//    }

    /**
     * 将日期格式通过注入方式赋值
     */

        private String pattern;

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

    /*
       convert方法作用：String --->  Date
                      SimpleDateFormat sdf = new SimpleDateFormat();
                      sdf.parset(String) ---> Date
       param:source 代表的是配置文件中 日期字符串 <value>2020-10-11</value>

       return : 当把转换好的Date作为convert方法的返回值后，Spring自动的为birthday属性进行注入（赋值）

     */

        @Override
        public Date convert(String source) {

            Date date = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                date = sdf.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }
    }

