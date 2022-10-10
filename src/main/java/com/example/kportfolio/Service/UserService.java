package com.example.kportfolio.Service;

import com.example.kportfolio.Repository.UserRepository;
import com.example.kportfolio.model.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

@Autowired
private JavaMailSender mailSender;


    public void register(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnable(false);

        repo.save(user);

        sendVerificationEmail(user, siteURL);
    }

    private void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "kelvin.daquon.wade@gmail.com";
        String senderName = "Kelvin";
        String subject = "Verification code!";
        String content = "Welcome to my portfolio [[name]],<br>" + "Thank you for taking interest. I hope take interest in my abilities. Please click on the link below to verify your account!<br>" + "<h3><a href=\" [[URL]]\" target =\"_self\">VERIFY</a></h3>" + "Thank you!<br>" ;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getName());
        String verifyUrl = siteURL + "/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyUrl);
        helper.setText(content, true);
        mailSender.send(message);

    }

    public boolean verify(String verificationCode) {
        User user = repo.findByVerificationCode(verificationCode);
        if (user == null || user.isEnable()) {
            return false;
        } else {
            user.setVerificationCode(null);
            user.setEnable(true);
            repo.save(user);
            return true;
        }

    }
}
