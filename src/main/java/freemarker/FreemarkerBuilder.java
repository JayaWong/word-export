package freemarker;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjianying
 * @Title: FreemarkerBuilder
 * @Description: ${END}
 * @date 2019/3/2218:30
 */
public class FreemarkerBuilder {

    private FreemarkerFactory freemarkerFactory;

    private Template template;

    private String ftlFileName;

    private String resultFileName;

    private OutputStreamWriter outputStreamWriter;

    private Map dataMap;

    private InputStream picInputStream;

    public FreemarkerBuilder(FreemarkerFactory freemarkerFactory,String ftlFileName,String resultFileName) throws IOException {
        this.freemarkerFactory = freemarkerFactory;
        this.template = freemarkerFactory.getTemplate(ftlFileName);
        this.ftlFileName = ftlFileName;
        this.resultFileName = resultFileName;
    }
    public FreemarkerBuilder(FreemarkerFactory freemarkerFactory) throws IOException {
        this.freemarkerFactory = freemarkerFactory;
        this.template = freemarkerFactory.getTemplate(ftlFileName);
    }

    public void setFtlFileName(String ftlFileName) {
        this.ftlFileName = ftlFileName;
    }

    public void setResultFileName(String resultFileName) {
        this.resultFileName = resultFileName;
    }

    public FreemarkerBuilder putData(String key, String value) {
        if (dataMap == null) {
            dataMap = new HashMap();
        }
        dataMap.put(key, value);
        return this;
    }

    public void process() throws IOException, TemplateException {
        if (outputStreamWriter == null) {
            outputStreamWriter = new FileWriter(resultFileName);
        }
        template.process(dataMap,outputStreamWriter);
    }

    public void setWriter(OutputStreamWriter outputStreamWriter) {
        this.outputStreamWriter = outputStreamWriter;
    }

    public String base64Picture(String picturePath) throws IOException {
        if (picInputStream == null) {
            picInputStream = new FileInputStream(picturePath);
        }
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while ((length = picInputStream.read(bytes)) > 0) {
            bOut.write(bytes, 0, length);
        }
        byte[] byteResult = bOut.toByteArray();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(byteResult);
    }
}
