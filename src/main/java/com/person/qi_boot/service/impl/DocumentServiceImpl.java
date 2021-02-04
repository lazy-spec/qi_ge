package com.person.qi_boot.service.impl;

import com.person.qi_boot.dao.DocumentDao;
import com.person.qi_boot.domain.Document;
import com.person.qi_boot.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired private DocumentDao documentDao;

    @Override
    public List<Document> getDocumentList() {
        return documentDao.getList();
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
