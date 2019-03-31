package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;

/**
 * @author wangjianying
 * @Title: FreemarkerFactory
 * @Description: ${END}
 * @date 2019/3/2012:31
 */
public class FreemarkerFactory {
    private Configuration configuration = null;

    {
        configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(), "/ftl");
    }

    public Template getTemplate(String ftlFileName) throws IOException {
        Template template = configuration.getTemplate(ftlFileName);
        return template;
    }

    public void setEncoding(String encoding) {
        configuration.setDefaultEncoding(encoding);
    }
    public Configuration getConfiguration() {
        return configuration;
    }
}
