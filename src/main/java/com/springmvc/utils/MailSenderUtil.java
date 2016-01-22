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


    private Logger log = Logger.getLogger(MailSenderUtil.class);


    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤

        Session session = Session.getInstance(prop);//1.创建session

        session.setDebug(true);//开启Session的debug模式,这样就可以查看到程序发送Email的运行状态

        Transport ts = session.getTransport(); //2.通过session得到transport对象

        ts.connect("smtp.163.com", "wchbtest1@163.com", "111111a");//3.使用邮箱的用户名和密码连上邮件服务器,发送邮件时,发件人需要提交邮箱的用户名和密码给smtp服务器,用户名和密码都通过验证之后才能够正常发送邮件给收件人.

        Message message = createSimpleMail(session);//4.创建邮件

        ts.sendMessage(message, message.getAllRecipients()); //5.发送邮件

        ts.close();
    }

    public static MimeMessage createSimpleMail(Session session) throws Exception {

        MimeMessage message = new MimeMessage(session);//创建邮件对象

        message.setFrom(new InternetAddress("wchbtest1@163.com"));//指明邮件的发件人

        message.setRecipient(Message.RecipientType.TO, new InternetAddress("xiexun@lvmama.com"));//指明邮件的收件人,现在发件人和收件人是一样的,那就是自己给自己发

        message.setSubject("只包含文本的简单邮件"); //邮件的标题

        message.setContent("你好啊!!!(测试邮件,请勿回复～！)", "text/html;charset=UTF-8");//邮件的文本内容

        return message;//返回创建好的邮件对象

    }

}
