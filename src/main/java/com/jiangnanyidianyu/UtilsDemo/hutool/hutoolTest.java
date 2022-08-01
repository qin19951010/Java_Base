package com.jiangnanyidianyu.UtilsDemo.hutool;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.map.MapBuilder;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
public class hutoolTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class PmsBrand{
        private Long id;
        private String name;
        private Integer ShowStatus;
    }

    @Test
    public void testConvert(){
        //转换为字符串
        int a = 1;
        String aStr = Convert.toStr(a);
        //转换为指定类型数组
        String[] b = {"1", "2", "3", "4"};
        Integer[] bArr = Convert.toIntArray(b);
        //转换为日期对象
        String dateStr = "2017-05-06";
        Date date = Convert.toDate(dateStr);
        //转换为列表
        String[] strArr = {"a", "b", "c", "d"};
        List<String> strList = Convert.toList(String.class, strArr);
    }

    @Test
    public void testDate(){
        //Date、long、Calendar之间的相互转换
        //当前时间
        Date date = DateUtil.date();
        System.out.println("当前date:" + date);
        //Calendar转Date
        date = DateUtil.date(Calendar.getInstance());
        //时间戳转Date
        date = DateUtil.date(System.currentTimeMillis());
        //自动识别格式转换
        String dateStr = "2017-03-01";
        date = DateUtil.parse(dateStr);
        //自定义格式化转换
        date = DateUtil.parse(dateStr, "yyyy-MM-dd");
        //格式化输出日期
        String format = DateUtil.format(date, "yyyy-MM-dd");
        //获得年的部分
        int year = DateUtil.year(date);
        //获得月份，从0开始计数
        int month = DateUtil.month(date);
        //获取某天的开始、结束时间
        Date beginOfDay = DateUtil.beginOfDay(date);
        System.out.println("beginOfDay" + beginOfDay);
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.println("endOfDay" + endOfDay);
        //计算偏移后的日期时间
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        //计算日期时间之间的偏移量
        System.out.println("date：======> " + date);
        System.out.println("newDate：======> " + newDate);
        Date date_old = DateUtil.parseDate("2021/7/22 12:00:30");
        Date date_new = DateUtil.parseDate("2021/7/22 20:00:30");
        long betweenDay = DateUtil.between(date_old, date_new, DateUnit.DAY);
        System.out.println("日期之间的偏移量: =====> " + betweenDay);
    }

    @Test
    public void testJson(){
        PmsBrand brand = new PmsBrand();
        brand.setId(1L);
        brand.setName("小米");
        brand.setShowStatus(1);
        //对象转化为JSON字符串
        String jsonStr = JSONUtil.parse(brand).toString();
        System.out.println("jsonStr =====>" + jsonStr);
        //JSON字符串转化为对象
        PmsBrand brandBean = JSONUtil.toBean(jsonStr, PmsBrand.class);
        System.out.println("brandBean =====>" + brandBean);

        List<PmsBrand> brandList = new ArrayList<>();
        brandList.add(brand);
        brandList.add(brand);

        String jsonListStr = JSONUtil.parse(brandList).toString();
        System.out.println("jsonListStr ======>" + jsonListStr);
        //JSON字符串转化为列表
        brandList = JSONUtil.toList(new JSONArray(jsonListStr), PmsBrand.class);
        System.out.println("brandList ======>" + brandList);
    }

    @Test
    public void strUtil(){
        //判断是否为空字符串
        String str = "test";
        StrUtil.isEmpty(str);
        StrUtil.isNotEmpty(str);
        //去除字符串的前后缀
        StrUtil.removeSuffix("a.jpg", ".jpg");
        StrUtil.removePrefix("a.jpg", "a.");
        //格式化字符串
        String template = "这只是个占位符:{}";
        String str2 = StrUtil.format(template, "我是占位符");
        System.out.println("占位符输出=====> " + str2);
    }

    @Test
    public void testClassPathResource() throws IOException {
        //获取定义在src/main/resources文件夹中的配置文件
        ClassPathResource resource = new ClassPathResource("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resource.getStream());
        System.out.println(properties);
    }

    @Test
    public void testReflectUtil(){
        //获取某个类的所有方法
        Method[] methods = ReflectUtil.getMethods(PmsBrand.class);
        //获取某个类的指定方法
        Method method = ReflectUtil.getMethod(PmsBrand.class, "getId");
        //使用反射来创建对象
        PmsBrand pmsBrand = ReflectUtil.newInstance(PmsBrand.class);
        //反射执行对象的方法
        ReflectUtil.invoke(pmsBrand, "setId", 1);
    }

    @Test
    public void testNumberUtil(){
        double n1 = 1.234;
        double n2 = 1.234;
        double nn = 1.275;
        double result;
        //对float、double、BigDecimal做加减乘除操作
        result = NumberUtil.add(n1, n2);
        result = NumberUtil.sub(n1, n2);
        result = NumberUtil.mul(n1, n2);
        result = NumberUtil.div(n1, n2);
        System.out.println("nn======>" + nn);
        //保留两位小数
        BigDecimal roundNum = NumberUtil.round(nn, 2);
        System.out.println("roundNum=====>" + roundNum);
        String n3 = "1.234";
        //判断是否为数字、整数、浮点数
        NumberUtil.isNumber(n3);
        NumberUtil.isInteger(n3);
        NumberUtil.isDouble(n3);
    }

    @Test
    public void testBeanUtil(){
        PmsBrand brand = new PmsBrand();
        brand.setId(1L);
        brand.setName("小米");
        brand.setShowStatus(0);
        //Bean转Map
        Map<String, Object> map = BeanUtil.beanToMap(brand);

        //Map转Bean
        PmsBrand mapBrand = BeanUtil.mapToBean(map, PmsBrand.class, false);

        //Bean属性拷贝
        PmsBrand copyBrand = new PmsBrand();
        BeanUtil.copyProperties(brand, copyBrand);
    }

    @Test
    public void testCollUtil(){
        //数组转换为列表
        String[] array = new String[]{"a", "b", "c", "d", "e"};
        List<String> list = CollUtil.newArrayList(array);
        //join：数组转字符串时添加连接符号
        String joinStr = CollUtil.join(list, ",");

        //将以连接符号分隔的字符串再转换为列表
        List<String> splitList = StrUtil.split(joinStr, ',');

        //创建新的Map、Set、List
        HashMap<Object, Object> newMap = CollUtil.newHashMap();
        HashSet<Object> newHashSet = CollUtil.newHashSet();
        ArrayList<Object> newList = CollUtil.newArrayList();
        //判断列表是否为空
        CollUtil.isEmpty(list);
    }

    @Test
    public void testMapUtil(){
        //数组转换为列表
        //将多个键值对加入到Map中
        MapBuilder<String, String> builder = MapUtil.builder("name", "Qinnn");
        System.out.println(builder);
        //判断Map是否为空
    }

    @Test
    public void testSecureUtil(){
        String str = "Qzl123456";
        String md5Str = SecureUtil.md5(str);
        String sha1 = SecureUtil.sha1(str);
    }

    @Test
    public void testCaptchaUtil(){
//        //生成验证码图片
//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
//        try {
//            request.getSession().setAttribute("CAPTCHA_KEY", lineCaptcha.getCode());
//            response.setContentType("image/png");//告诉浏览器输出内容为图片
//            response.setHeader("Pragma", "No-cache");//禁止浏览器缓存
//            response.setHeader("Cache-Control", "no-cache");
//            response.setDateHeader("Expire", 0);
//            lineCaptcha.write(response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testValidator(){

        //判断是否为邮箱地址
        boolean result = Validator.isEmail("macro@qq.com");

        //判断是否为手机号码
        result = Validator.isMobile("18911111111");

        //判断是否为IPV4地址
        result = Validator.isIpv4("192.168.3.101");

        //判断是否为汉字
        result = Validator.isChinese("你好");

        //判断是否为身份证号码（18位中国）
        result = Validator.isCitizenId("123456");

        //判断是否为URL
        result = Validator.isUrl("http://www.baidu.com");

        //判断是否为生日
        result = Validator.isBirthday("2020-02-01");
    }

    @Test
    public void testDigestUtil(){
        String password = "123456";
        //计算MD5摘要值，并转为16进制字符串
        String md5Hex = DigestUtil.md5Hex(password);
        System.out.println("md5Hex====>" + md5Hex);

        //计算SHA-256摘要值，并转为16进制字符串
        String sha256Hex = DigestUtil.sha256Hex(password);
        System.out.println("sha256Hex====>" + sha256Hex);

        //生成Bcrypt加密后的密文，并校验
        String hashPwd = DigestUtil.bcrypt(password);
        System.out.println("hashPwd=====>" + hashPwd);
        boolean check = DigestUtil.bcryptCheck(password,hashPwd);
    }

    @Test
    public void testHttpUtil(){
        String response = HttpUtil.get("https://www.baidu.com");
        System.out.println(response);
    }

}
