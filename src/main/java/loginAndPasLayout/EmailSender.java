package loginAndPasLayout;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
    public void sendEmail(String toEmail, String subject, String body, String fromEmail, String password) {
        // Cấu hình thông tin máy chủ SMTP
        String host = "smtp.gmail.com"; // Thay thế bằng máy chủ SMTP của bạn
        int port = 587;

        // Tạo đối tượng Properties để cấu hình
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Tạo đối tượng Session
        Session session = Session.getInstance(props);

        try {
            // Tạo đối tượng MimeMessage
            Message message = new MimeMessage(session);

            // Đặt thông tin người gửi và người nhận
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            // Đặt tiêu đề và nội dung của email
            message.setSubject(subject);
            message.setText(body);

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail("recipient-email@example.com", "Test Subject", "Test Body", "your-email@gmail.com", "your-email-password");
    }
}
