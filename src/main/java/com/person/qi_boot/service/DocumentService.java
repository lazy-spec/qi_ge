package com.person.qi_boot.service;


import com.person.qi_boot.domain.Document;

import java.util.List;

public interface DocumentService {

    List<Document> getDocumentList();

    List<Document> getDocumentLikeList(String key);

    Document getDocumentInfo(Integer id);

    void updateDocumentInfo(Document document);

    void insertDocumentInfo(Document document);

    void deletedById(Integer id);

}
