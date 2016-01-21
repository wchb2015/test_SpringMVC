package com.springmvc.utils;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by wangchongbei on 16-1-18.
 */
public class MailSenderUtil {
    private static Logger log = Logger.getLogger(MailSenderUtil.class);

    final static String accountName = "wangchongbei@lvmama.com";
    final static String mailFrom = "wangchongbei@lvmama.com";
    final static String password = "xxxx";


    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.sohu.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1.创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式,这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2.通过session得到transport对象
        Transport ts = session.getTransport();
        //3.使用邮箱的用户名和密码连上邮件服务器,发送邮件时,发件人需要提交邮箱的用户名和密码给smtp服务器,用户名和密码都通过验证之后才能够正常发送邮件给收件人.
        ts.connect("smtp.163.com", "wchbtest1@163.com", "111111a");
        //4.创建邮件
        Message message = createSimpleMail(session);
        //5.发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();

    }

    public static MimeMessage createSimpleMail(Session session) throws Exception {

        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("wchbtest1@163.com"));
        //指明邮件的收件人,现在发件人和收件人是一样的,那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("wangchongbei@lvmama.com"));
        //邮件的标题
        message.setSubject("只包含文本的简单邮件");
        //邮件的文本内容
        message.setContent("你好啊！", "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

/*
    Session session = Session.getDefaultInstance(prop, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(accountName, password);
        }
    });
*/


}
