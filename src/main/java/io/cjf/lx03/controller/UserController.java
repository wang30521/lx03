package io.cjf.lx03.controller;

import io.cjf.lx03.dao.UserMapper;
import io.cjf.lx03.dto.UserRegisterDTO;
import io.cjf.lx03.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@EnableAutoConfiguration
@CrossOrigin
@Validated
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public Integer register(@RequestBody UserRegisterDTO userRegisterDTO){
        logger.info("user register dto is {}",userRegisterDTO);

        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());


        //加密 盐
        String salt = UUID.randomUUID().toString();
        //设置一下盐
        user.setSalt(salt);
        //待加密密码
        String toEncryptedPwd = userRegisterDTO.getPassword()+salt;
        //进行加密  摘要,hash,本身不是加密方法
        String encryptedPwd = DigestUtils.md5DigestAsHex(toEncryptedPwd.getBytes());
        user.setPassword(encryptedPwd);
        //创建时间

        userMapper.insert(user);

        return user.getUserId();
    }

    @GetMapping("/login")
    public void  login(@RequestParam @Size(min = 6,max = 20) String username, @RequestParam @Size(min = 6) String password, HttpSession httpSession) throws  Exception{
        logger.info("username is {},password is {}",username,password);
        User user = userMapper.selectByUsername(username);
        if(user == null){
            throw new Exception("username doesn't exist");
        }

        String salt = user.getSalt();
        String inputPwd = password + salt;
        String inputEncryptedPwd = DigestUtils.md5DigestAsHex(inputPwd.getBytes());
        String encryptedPassword = user.getPassword();

        if(!inputEncryptedPwd.equals(encryptedPassword)){
            throw new Exception("password is invalid");
        }

        String id = httpSession.getId();
        httpSession.setAttribute(id,user);

    }

    @PostMapping("/changePassword")
    public void  changePassword(String originPwd, String newPwd, HttpSession httpSession) throws Exception{
        logger.info("originPwd is {},newPwd is {}",originPwd, newPwd);
        User currentUser = (User) httpSession.getAttribute(httpSession.getId());
        String salt = currentUser.getSalt();
        String originPwdSaltStr = originPwd + salt;
        String orighiEncryptedPwd = DigestUtils.md5DigestAsHex(originPwdSaltStr.getBytes());
        if(!orighiEncryptedPwd.equals(currentUser.getPassword())){
            throw new Exception("origin password is invalid");
        }

        String newSalt = UUID.randomUUID().toString();
        currentUser.setSalt(newSalt);
        String toEncryptedNewPwd = newPwd+ newSalt;
        String newEncryptedPwd = DigestUtils.md5DigestAsHex(toEncryptedNewPwd.getBytes());
        currentUser.setPassword(newEncryptedPwd);

        httpSession.removeAttribute(httpSession.getId());

        userMapper.updateByPrimaryKey(currentUser);
    }
}
