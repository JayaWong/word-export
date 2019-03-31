import freemarker.FreemarkerBuilder;
import freemarker.FreemarkerFactory;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author wangjianying
 * @Title: Main
 * @Description: ${END}
 * @date 2018/11/2517:37
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        FreemarkerFactory freemarkerFactory = new FreemarkerFactory();
        try {
            FreemarkerBuilder builder = new FreemarkerBuilder(freemarkerFactory, "test.ftl", "D://test.doc");
            builder.putData("title", "Freemarker生成Word")
                    .putData("subTitle", "简介")
                    .putData("content", "FreeMarker是一款模板引擎： 即一种基于模板和要改变的数据，" +
                            " 并用来生成输出文本（HTML网页、电子邮件、配置文件、源代码等）的通用工具。 " +
                            "它不是面向最终用户的，而是一个Java类库，是一款程序员可以嵌入他们所开发产品的组件。\n" +
                            "FreeMarker是免费的，基于Apache许可证2.0版本发布。其模板编写为FreeMarker Template Language（FTL），" +
                            "属于简单、专用的语言。需要准备数据在真实编程语言中来显示，比如数据库查询和业务运算， " +
                            "之后模板显示已经准备好的数据。在模板中，主要用于如何展现数据， 而在模板之外注意于要展示什么数据")
                    .putData("picture", builder.base64Picture("C:\\Users\\jh\\Desktop\\响应头.jpeg"));
            builder.process();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("system exit...");
        }

    }
}
