package com.example.dto;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Assert;
import org.junit.Test;

public class PersonBeanTest {

    @Test
    public void assertPersonBeanSerializable() throws InvalidProtocolBufferException {
        //1.通过build创建消息构造器
        PersonBean.Person.Builder builder = PersonBean.Person.newBuilder();
        String personName = "jacksparrow414";
        builder.setName(personName);
        builder.setAge(25);
        builder.setGender(true);
        //2.通过消息构造器构造消息对象
        PersonBean.Person person = builder.build();
//        3.序列化
        byte[] bytes = person.toByteArray();
//        4.反序列化
        PersonBean.Person parsePerson = PersonBean.Person.parseFrom(bytes);
        Assert.assertNotNull(parsePerson);
        Assert.assertEquals(personName, parsePerson.getName());
        System.out.println(parsePerson.getName());
    }
}