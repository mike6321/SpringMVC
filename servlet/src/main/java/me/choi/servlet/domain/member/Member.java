package me.choi.servlet.domain.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Project : servlet
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 2:51 오후
 */
@Getter @Setter
@NoArgsConstructor
public class Member {

    private Long id;
    private String username;
    private Long age;

    public Member(String username, long age) {
        this.username = username;
        this.age = age;
    }
}
