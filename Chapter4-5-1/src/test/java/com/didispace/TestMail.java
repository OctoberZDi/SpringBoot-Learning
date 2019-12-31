package com.didispace;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;


/**
 * description: TestMail <br>
 * date: 2019/12/30 10:20 <br>
 *
 * @author: Zhangdi <br>
 * version: 1.0 <br>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestMail {

    @Autowired
    JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;

    @Test
    public void sendSimpleMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("3522097964@qq.com");
        simpleMailMessage.setTo("912688695@qq.com");
        simpleMailMessage.setSubject("主题：张迪测试001");
        simpleMailMessage.setText("内容：邮件内容");

        mailSender.send(simpleMailMessage);
    }

    @Test
    public void sendAttachMail() throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
        helper.setFrom("3522097964@qq.com");
        helper.setTo("912688695@qq.com");
        helper.setSubject("主题：张迪测试001-附件");
        helper.setText("内容：邮件内容，带附件");

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addAttachment("附件-01", file);
        helper.addAttachment("附件-02", file);

        mailSender.send(mimeMailMessage);
    }


    /**
     * 嵌入静态资源
     */
    @Test
    public void sendInlineMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("3522097964@qq.com");
        helper.setTo("912688695@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addInline("weixin", file);

        mailSender.send(mimeMessage);
    }


    /**
     * 发送模板文件
     */
    @Test
    public void sendTemplateMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("3522097964@qq.com");
        helper.setTo("912688695@qq.com");
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashedMap();
        model.put("username", "didi");
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "template.vm", "UTF-8", model);
        helper.setText(text, true);

        mailSender.send(mimeMessage);
    }
}

