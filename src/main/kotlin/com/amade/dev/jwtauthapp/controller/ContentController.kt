package com.amade.dev.jwtauthapp.controller

import com.amade.dev.jwtauthapp.model.Word
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RequestMapping("/api/v1/content/")
@RestController
class ContentController {


    @GetMapping
    suspend fun getContent(@AuthenticationPrincipal principal: Principal): Word {
        return Word()
    }


}