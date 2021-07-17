package com.demo.ajaxlist.JsonTest;

import com.demo.ajaxlist.form.UserForm;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapperTest {
    private ObjectMapper mapper = new ObjectMapper();

    /*
      5.List<User>转json, json转List<User>
        json字符串 = [{"name":"张三","age":23},{"name":"李四","age":24}]
        list对象 = [User{name='张三', age=23}, User{name='李四', age=24}]
    */
    @Test
    public void testListToJson() throws Exception{
        //List<User>转json
        List<UserForm> list = new ArrayList<>();
        list.add(new UserForm("张三","23"));
        list.add(new UserForm("李四","24"));
        String json = mapper.writeValueAsString(list);
        System.out.println("json字符串: "+ json);

        //json转List<User>
        List<UserForm> list2 = mapper.readValue(json, new TypeReference<List<UserForm>>() {});
        System.out.println("java对象: "+ list2);
    }
}
