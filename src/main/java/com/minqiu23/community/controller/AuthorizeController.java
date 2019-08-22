package com.minqiu23.community.controller;

import com.minqiu23.community.dto.AccessTokenDTO;
import com.minqiu23.community.dto.GithubUserDTO;
import com.minqiu23.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Min-Qiu23 on 2019/8/22
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code ,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("1d43ff1b1a970c4f8a1e");
        accessTokenDTO.setClient_secret("6ace72801c19009dbf43ef7b43087646f696ec61");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUserDTO user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
