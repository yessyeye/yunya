package com.xuehai.util;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @Author slyart
 * @create 2019/5/14 3:58 PM
 */
public class ObjectIdSerializer implements ObjectSerializer {
    public final static ObjectIdSerializer instance = new ObjectIdSerializer();

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features)
            throws IOException {
        // TODO Auto-generated method stub
        SerializeWriter out = serializer.out;
        if (object instanceof ObjectId) {
            ObjectId objectId = (ObjectId) object;
            out.writeString(objectId.toString());
            return;
        }
    }
}
