package tech.jitao.httpapidemo.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import tech.jitao.httpapidemo.common.ApiResult;
import tech.jitao.httpapidemo.config.RequestHeaders;
import tech.jitao.httpapidemo.config.auth.NoAuth;
import tech.jitao.httpapidemo.service.AccountService;

@RestController(Logout.PATH)
@CrossOrigin
@NoAuth
public class Logout {
    static final String PATH = "/web/logout";

    @Autowired
    private AccountService accountService;

    @PostMapping(PATH)
    public ApiResult process(@RequestHeader(value = RequestHeaders.ACCESS_TOKEN, required = false) String accessToken) {
        accountService.logout(accessToken);

        return ApiResult.ok();
    }
}
