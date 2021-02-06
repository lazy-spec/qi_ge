package com.person.qi_boot.controller;

import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("document")
public class DocumentController {

    @Autowired private DocumentService documentService;

    @GetMapping("list")
    public AjaxResult list() {
        return AjaxResult.ok().data("documents", documentService.getDocumentList());
    }

    @PostMapping("upload")
    public void update(HttpServletResponse response) {
        
    }


}
