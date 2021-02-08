package com.person.qi_boot.controller;

import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.consts.Const;
import com.person.qi_boot.domain.Document;
import com.person.qi_boot.domain.Employee;
import com.person.qi_boot.service.DocumentService;
import com.person.qi_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("document")
public class DocumentController {

    @Autowired private DocumentService documentService;
    @Autowired private EmployeeService employeeService;

    @GetMapping("list")
    public AjaxResult list() {
        return AjaxResult.ok().data("documents", documentService.getDocumentList());
    }

    @PostMapping("upload")
    public AjaxResult update(@RequestParam(value = "file") MultipartFile file, @RequestParam("title") String title,
                             @RequestParam("empId") String empId, @RequestParam("remark") String remark) {
        String filename = file.getOriginalFilename();
        if (Objects.isNull(filename)) {
            return AjaxResult.fail().msg("文件为空");
        }
        try {
            String uuidFile = UUID.randomUUID().toString().replace("-","") +
                    filename.substring(filename.lastIndexOf("."));
            File parentFile = new File(Const.path_url);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            String targetFilename = Const.path_url + uuidFile;
            Document document = new Document();
            document.setEmpId(Integer.parseInt(empId));
            Employee employee = employeeService.getEmployeeInfo(Integer.parseInt(empId));
            document.setEmpName(employee.getName());
            document.setFile(file);
            document.setTitle(title);
            document.setRemark(remark);
            document.setFilename(uuidFile);
            documentService.insertDocumentInfo(document);
            file.transferTo(new File(targetFilename));
            return AjaxResult.ok().msg("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.fail().msg("上传失败");
        }
    }


}
