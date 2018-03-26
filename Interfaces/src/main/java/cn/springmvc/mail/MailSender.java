package cn.springmvc.mail;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	/**
	 * 
	 * @Description: 从模板中构建邮件内容
	 * @param map
	 *            任意参数封装
	 * @param email
	 *            接受邮件
	 */
	public void send(Map<String, Object> map, String fileName) {
		String text = "";
		try {
			// 根据模板内容，动态把map中的数据填充进去，生成HTML
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(fileName);
			// map中的key，对应模板中的${key}表达式
			text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		System.out.println(text);
		sendMail(text);
	}

	/**
	 * 
	 * @Description: 执行发送邮件
	 * @param to
	 *            收件人邮箱
	 * @param subject
	 *            邮件主题
	 * @param content
	 *            邮件内容
	 * 
	 */
	public void sendMail(String content) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(simpleMailMessage.getFrom());
			messageHelper.setSubject(simpleMailMessage.getSubject());
			messageHelper.setTo(simpleMailMessage.getTo());
			messageHelper.setText(content, true);
			javaMailSender.send(message);
			String [] tos= simpleMailMessage.getTo();
			for (String to : tos) {
			  System.out.println(" send to "+to+" sucess");
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
