package com.charley.springMvc.messageconverter;

import com.charley.springMvc.DemoObj.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 自定义媒体类型
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    /**
     * 自定义请求类型，application/myMediaType
     */
    public MyMessageConverter(){
        super(new MediaType("application","myMediaType", Charset.forName("UTF-8")));
    }

    /**
     * 支持的类型
     */
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    /**
     * 输入之后的处理
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(),Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(new Long(tempArr[0]),tempArr[1]);
    }

    /**
     * 输出
     */
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + obj.getId() + "-" + obj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }

}
