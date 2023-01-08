package com.example.interviewPrep.quiz.member.controller;


import com.example.interviewPrep.quiz.member.dto.*;
import com.example.interviewPrep.quiz.member.service.AuthenticationService;
import com.example.interviewPrep.quiz.member.service.MemberService;
import com.example.interviewPrep.quiz.member.social.service.OauthService;
import com.example.interviewPrep.quiz.response.ResultResponse;
import com.google.common.net.HttpHeaders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/members/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class MemberController {
    private final AuthenticationService authService;
    private final MemberService memberService;

    @PostMapping("signup")
    public ResultResponse<?> signUp(@RequestBody @Valid SignUpRequestDTO memberDTO){
        return ResultResponse.success(memberService.createMember(memberDTO));
    }

    @GetMapping("userInfo")
    public ResultResponse<?> getUserInfo(){
        return ResultResponse.success(memberService.getUserInfo());
    }

    @PostMapping("login")
    public ResultResponse<?> login(@RequestBody @NotNull LoginRequestDTO memberDTO, HttpServletResponse response){
        return ResultResponse.success(authService.login(memberDTO, response));
    }

    @PutMapping("/change")
    public ResultResponse<?> changeNickNameAndEmail(@RequestBody @NotNull MemberDTO memberDTO){
        return ResultResponse.success(memberService.changeNickNameAndEmail(memberDTO));
    }

    @PutMapping("/password/change")
    public ResultResponse<?> changePassword(@RequestBody @NotNull MemberDTO memberDTO){
        return ResultResponse.success(memberService.changePassword(memberDTO));
    }

//    @GetMapping(value="auth/{socialType}")
//    public void socialLoginType(@PathVariable String socialType){
//        oauthService.request(socialType);
//    }
//
//    @GetMapping(value="auth/{socialType}/callback")
//    public ResultResponse<?> callback(@PathVariable String socialType, @RequestParam(name="code") String code){
//        return ResultResponse.success(oauthService.socialLogin(socialType, code));
//    }

    @GetMapping(value="logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        authService.logout(request.getHeader(HttpHeaders.AUTHORIZATION), response);
    }


    @GetMapping(value="reissue")
    public ResultResponse<LoginResponseDTO> reissueToken(@CookieValue(value="refreshToken", required = false) Cookie cookie){
        return ResultResponse.success(authService.reissue(cookie.getValue()));
    }




}
