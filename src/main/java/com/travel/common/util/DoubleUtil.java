package com.travel.common.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoubleUtil {
    /***************************************************************************
     * 此方法用来获取数值
     * 
     * @param strDouble
     *            操作字符串
     * @return 返回数值 Double 类型
     */
    public static Double get(String strDouble)
    {
        return new BigDecimal(strDouble).doubleValue();
    }
    /***************************************************************************
     * 此方法用来获取数值
     * 
     * @param strDouble
     *            操作字符串 defaultValue 默认数值 Double
     * @return 返回数值 Double 类型
     */
    public static Double get(String strDouble, Double defaultValue)
    {
        Double result = 0.0;
        try
        {
            result = Double.parseDouble(strDouble);
        }
        catch (Exception ex)
        {
            result = defaultValue;
        }
        return result;
    }

    /***************************************************************************
     * 此方法用来判断是否数值
     * 
     * @param strDouble
     *            操作字符串
     * @return 返回数值 Double 类型
     */

    public static boolean is(String strDouble)
    {
        boolean result = false;

        try
        {
            Double.parseDouble(strDouble);
            result = true;
        }
        catch (Exception ex)
        {
            ;
        }

        return result;
    }

    /***************************************************************************
     * 比较两字符串类型数字大小
     * 
     * @param strValue1
     * @param strValue2
     * @return
     */
    public static boolean equals(String strValue1, String strValue2)
    {
        double douValue1 = 0;
        double douvalue2 = 0;
        douValue1 = DoubleUtil.get(strValue1);
        douvalue2 = DoubleUtil.get(strValue2);

        if (0==compareTo(douValue1,douvalue2))
        {
            return true;
        }
        return false;
    }

    /**
     * 提供精确比较。
     * 
     * v1 在数字上小于、等于或大于 v2 时，返回 -1、0 或 1
     * 
     */
    public static int compareTo(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.compareTo(b2);
    }

    /**
     * 由于Java的简单类型不能够精确的对浮点数进行运算， 这个工具类提供精确的浮点数运算，包括加减乘除和四舍五入。
     */
    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 2;

    // 这个类不能实例化
    private DoubleUtil()
    {
    }

    /**
     * 提供精确的加法运算。
     * 
     * @param v1
     *            被加数
     * @param v2
     *            加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    
    /**
     * 提供精确的加法运算。
     * @return 所有参数的和
     */
    public static double add(double v1,double ...args){
    	double result=v1;
    	for(double vn:args){
    		result=add(result,vn);
    	}
    	return result;
    }

    /**
     * 提供精确的减法运算。
     * 
     * @param v1
     *            被减数
     * @param v2
     *            减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     * 
     * @param v1 被减数
     * @param 其他 减数
     * @return 所有参数的差
     */
    public static double sub(double v1,double ...args){
    	double result=v1;
    	for(double vn:args){
    		result=sub(result,vn);
    	}
    	return result;
    }

    /**
     * 提供精确的乘法运算。
     * 
     * @param v1
     *            被乘数
     * @param v2
     *            乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算，保留两位小数已后的位数四舍五入。
     * 
     * @param v1
     *            被乘数
     * @param v2
     *            乘数
     * @return 两个参数的积
     */
    public static double mulRound2(double v1, double v2)
    {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(),2);
    }
    
    
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时， 精确到小数点以后2位，以后的数字四舍五入。
     * 
     * @param v1
     *            被除数
     * @param v2
     *            除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2)
    {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     * 
     * @param v1
     *            被除数
     * @param v2
     *            除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * 
     * @param v
     *            需要四舍五入的数字
     * @param scale
     *            小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     * 根据起止时间获取间隔天数
     */
    public static Integer getDays(String sDate,String eDate)throws Exception
    {
    	Integer day=0;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	 Date sTime=sdf.parse(sDate);
		 Date eTime=sdf.parse(eDate);
    	Long time=(eTime.getTime()-sTime.getTime())/(24*60*60*1000);
    	day=time.intValue()+1;
    	return day;
    }
    /**
     * 百分比计算
     */
    public static String getPercent(Double price,Double totalPrice)
    {
    	String percent="0";
    	NumberFormat numberFormat = NumberFormat.getInstance(); 
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setGroupingUsed(false);
		percent=numberFormat.format(price/totalPrice*100);
		if(Double.valueOf(percent)==0 && price>0){
			percent="小于 0.01";
		}
    	return percent;
    }

}
