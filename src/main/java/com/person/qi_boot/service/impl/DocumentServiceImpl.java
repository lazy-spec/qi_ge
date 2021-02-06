package com.person.qi_boot.service.impl;

import com.person.qi_boot.dao.DocumentDao;
import com.person.qi_boot.domain.Document;
import com.person.qi_boot.domain.Employee;
import com.person.qi_boot.service.DocumentService;
import com.person.qi_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired private DocumentDao documentDao;
    @Autowired private EmployeeService employeeService;

    @Override
    public List<Document> getDocumentList() {
        List<Document> documents = documentDao.getList();
        for (Document document : documents) {
            Employee employee = employeeService.getEmployeeInfo(document.getEmpId());
            document.setEmpName(employee.getName());
        }
        return documents;
    }

    @Override
    public List<Document> getDocumentLikeList(String key) {
        return documentDao.getLikeList(key);
    }

    @Override
    public Document getDocumentInfo(Integer id) {
        return documentDao.getInfoById(id);
    }

    @Override
    public void updateDocumentInfo(Document document) {
        documentDao.updateInfoById(document);
    }

    @Override
    public void insertDocumentInfo(Document document) {
        documentDao.save(document);
    }

    @Override
    public void deletedById(Integer id) {
        documentDao.deleteById(id);
    }
}
