package com.jiangnanyidianyu.BaseDemo.序列化2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName Main
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/12/25 16:52
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        /**在反序列化时忽略在 json 中存在但 Java 对象不存在的属性*/
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        /**在序列化时日期格式默认为 yyyy-MM-dd'T'HH:mm:ss.SSSZ*/
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        /**在序列化时自定义时间日期格式*/
//        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        /**在序列化时忽略值为 null 的属性*/
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        /**在序列化时忽略值为默认值的属性*/
//        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);

        /**实例化测试数据*/
//        System.out.println("序列化");
//        Message<String> message = new Message<String>(new Date(),"成功",1,"这是一条测试成功数据");
//        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(message);
//        System.out.println(s);
//        Message<String> message2 = new Message<String>(new Date(),"失败",0,"这是一条测试失败数据");
//
//        ArrayList<Message<String>> list = new ArrayList<>();
        //String s2 = objectMapper.writerWithDefaultPrettyPrinter().
        //System.out.println(list.toString());

        /** 反序列化 */
//        Message<String> deserializedMessage= objectMapper.readValue(s, Message.class);
//        System.out.println(deserializedMessage);

        //test3();

        //test5();

        //test6();

        //test7();

        //test8();

        //test9();

        test10();
    }

    public static void test3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 造数据
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "Tom");
        map.put("date", "2020-07-26 19:28:44");
        map.put("age", 100);
        map.put("demoKey", "demoValue");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(jsonString);
        System.out.println("反序列化");
        User user = mapper.readValue(jsonString, User.class);
        System.out.println(user);
        System.out.println("序列化");
        jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(jsonString);
    }

    public static void test5() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
        // 造数据
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUserName("Tom");
            user.setAge(new Random().nextInt(100));
            user.setDate(new Date());
            list.add(user);
        }
        System.out.println("序列化");
        String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        System.out.println(jsonInString);

        System.out.println("反序列化：使用 javaType");
        List<User> userList = mapper.readValue(jsonInString, javaType);
        System.out.println(userList);

        System.out.println("反序列化：使用 TypeReference");
        List<User> userList2 = mapper.readValue(jsonInString, new TypeReference<List<User>>() {
        });
        System.out.println(userList2);
    }

    public static void test6() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //第二参数是 map 的 key 的类型，第三参数是 map 的 value 的类型
        MapType javaType = mapper.getTypeFactory().constructMapType(HashMap.class, String.class, User.class);
        // 造数据
        Map<String, User> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setUserName("Tom");
            user.setAge(new Random().nextInt(100));
            user.setDate(new Date());
            map.put("key" + i, user);
        }
        System.out.println("序列化");
        String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(jsonInString);

        System.out.println("反序列化: 使用 javaType");
        Map<String, User> personMap = mapper.readValue(jsonInString, javaType);
        System.out.println(personMap);

        System.out.println("反序列化: 使用 TypeReference");
        Map<String, User> personMap2 = mapper.readValue(jsonInString, new TypeReference<Map<String, User>>() {
        });
        System.out.println(personMap2);
    }

    public static class People {
        public int age;
        protected String name;
        public Date date;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    /**
     * setVisibility: 改变序列化属性的可见性
     *
     * 若该属性修饰符是 public，该属性可序列化和反序列化。
     *
     * 若属性的修饰符不是 public，但是它的 getter 方法和 setter 方法是 public，
     * 该属性可序列化和反序列化。因为 getter 方法用于序列化， 而 setter 方法用于反序列化。
     *
     * 若属性只有 public 的 setter 方法，而无 public 的 getter 方法，该属性只能用于反序列化。
     *
     */
    public static void test7() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // PropertyAccessor 支持的类型有 ALL,CREATOR,FIELD,GETTER,IS_GETTER,NONE,SETTER
        // Visibility 支持的类型有 ANY,DEFAULT,NON_PRIVATE,NONE,PROTECTED_AND_PUBLIC,PUBLIC_ONLY
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        // 造数据
        People people = new People();
        people.name = "Tom";
        people.age = 40;
        System.out.println("序列化");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);
        System.out.println(jsonString);
        System.out.println("反序列化");
        People deserializedPerson = mapper.readValue(jsonString, People.class);
        System.out.println(deserializedPerson);
    }

    public static void test8() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //设置 addMixIn
        mapper.addMixIn(People.class, MyFilter.class);
        //调用 SimpleBeanPropertyFilter 的 serializeAllExcept 方法
        SimpleBeanPropertyFilter newFilter = SimpleBeanPropertyFilter.serializeAllExcept("age");
        //或重写 SimpleBeanPropertyFilter 的 serializeAsField 方法
        SimpleBeanPropertyFilter newFilter2 = new SimpleBeanPropertyFilter() {
            @Override
            public void serializeAsField(Object pojo, JsonGenerator jgen,
                                         SerializerProvider provider, PropertyWriter writer)
                    throws Exception {
                if (!writer.getName().equals("age")) {
                    writer.serializeAsField(pojo, jgen, provider);
                }
            }
        };
        //设置 FilterProvider
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter", newFilter);
        // 造数据
        People person = new People();
        person.setName("Tom");
        person.setAge(40); // 该属性将被忽略
        person.setDate(new Date());
        // 序列化
        String jsonString = mapper.setFilterProvider(filterProvider).writeValueAsString(person);
        System.out.println(jsonString);
    }

    //region    自定义序列化类
    public static class CustomSerializer extends StdSerializer<People> {
        protected CustomSerializer() {
            super(People.class);
        }

        @Override
        public void serialize(People person, JsonGenerator jgen, SerializerProvider provider) throws IOException {
            jgen.writeStartObject();
            jgen.writeNumberField("age", person.getAge());
            jgen.writeStringField("name", person.getName());
            jgen.writeStringField("msg", "已被自定义序列化");
            jgen.writeEndObject();
        }
    }
    //endregion

    //region    自定义反序列化类
    public static class CustomDeserializer extends StdDeserializer<People> {
        protected CustomDeserializer() {
            super(People.class);
        }

        @Override
        public People deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            People person = new People();
            int age = (Integer) ((IntNode) node.get("age")).numberValue();
            String name = node.get("name").asText();
            person.setAge(age);
            person.setName(name);
            return person;
        }
    }
    //endregion

    //region 调用自定义序列化/反序列化类

    public static void test9() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 生成 module
        SimpleModule module = new SimpleModule("myModule");
        module.addSerializer(new CustomSerializer());
        module.addDeserializer(People.class, new CustomDeserializer());
        // 注册 module
        mapper.registerModule(module);
        // 造数据
        People person = new People();
        person.setName("Tom");
        person.setAge(40);
        person.setDate(new Date());
        System.out.println("序列化");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(jsonString);
        System.out.println("反序列化");
        People deserializedPerson = mapper.readValue(jsonString, People.class);
        System.out.println(deserializedPerson);
    }

    //endregion

    //region 修改或访问 json 部分属性

    public static void test10() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //构建 ObjectNode
        ObjectNode personNode = mapper.createObjectNode();

        //添加/更改属性
        personNode.put("name", "Tom");
        personNode.put("age", 40);

        ObjectNode addressNode = mapper.createObjectNode();
        addressNode.put("zip", "000000");
        addressNode.put("street", "Road NanJing");

        //设置子节点
        personNode.set("address", addressNode);
        System.out.println("构建 ObjectNode:\n" + personNode.toString());

        //通过 path 查找节点
        JsonNode searchNode = personNode.path("name");
        System.out.println("查找子节点 name:\n" + searchNode.asText());

        //通过 path 查找节点
        JsonNode searchNode1 = personNode.path("address");
        System.out.println("查找子节点 address:\n" + searchNode1.asText());

        //删除属性
        ((ObjectNode) personNode).remove("address");
        System.out.println("删除后的 ObjectNode:\n" + personNode.toString());

        //读取 json
        JsonNode rootNode = mapper.readTree(personNode.toString());
        System.out.println("Json 转 JsonNode:\n" + rootNode);

        //JsonNode 转换成 java 对象
        People person = mapper.treeToValue(personNode, People.class);
        System.out.println("JsonNode 转对象:\n" + person);

        //java 对象转换成 JsonNode
        JsonNode node = mapper.valueToTree(person);
        System.out.println("对象转 JsonNode:\n" + node);
    }

    //endregion
}
