package com.crmdemo.model.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "비회원"),
    USER("ROLE_USER", "일반회원"),
    ADMIN("ROLE_ADMIN", "관리자"),
    KBUSER("ROLE_KBUSER","KB회원"),
    KAKAOUSER("ROLE_KAKAO", "카카오회원"),
    NAVERUSER("ROLE_NAVER", "네이버회원"),
    GOOGLE("ROLE_GOOGLE","구글회원"),
    FACEBOOK("ROLE_FACEBOOK","페이스북회원");
    private final String key;

    private final String title;
}
