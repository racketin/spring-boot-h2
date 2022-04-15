package com.rac.halodoc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.rac.halodoc.exception.InvalidAtributeTypeException;
import com.rac.halodoc.exception.InvalidDocumentException;
import com.rac.halodoc.model.Attribute;
import com.rac.halodoc.model.Document;

public class DocumentService {
	private Map<String, Map<String, List<String>>> documentStore;
	private AttributeService attributeService = new AttributeService();
	private static DocumentService documentService;

	private DocumentService() {
		initializeDocumentStore();
	}

	public static DocumentService getInstance() {
		if (documentService == null) {
			synchronized (DocumentService.class) {
				if (documentService == null) {
					documentService = new DocumentService();
				}
			}
		}
		return documentService;
	}

	private void initializeDocumentStore() {
		documentStore = new ConcurrentHashMap<String, Map<String, List<String>>>();
	}

	public boolean insertDocument(Document document) throws InvalidDocumentException {
		boolean flag = validateDocument(document);
		if (flag) {
			attributeService.addAttribute(document.getAttributes());
			for (Attribute attribute : document.getAttributes()) {
				if (documentStore.get(attribute.getName()) != null) {
					Map<String, List<String>> map = documentStore.get(attribute.getName());
					if (map.get(attribute.getValue()) != null) {
						List<String> list = map.get(attribute.getValue());
						list.add(document.getKey());

					} else {
						List<String> keys = new ArrayList<>();
						keys.add(document.getKey());
						map.put(attribute.getValue(), keys);
					}
				} else {
					Map<String, List<String>> map = new HashMap<>();
					List<String> keys = new ArrayList<>();
					keys.add(document.getKey());
					map.put(attribute.getValue(), keys);
					documentStore.put(attribute.getName(), map);
				}
			}

		}
		return flag;
	}

	private boolean validateDocument(Document document) {
		boolean flag = false;
		if (document != null) {
			for (Attribute attribute : document.getAttributes()) {
				flag = isValidAttribute(attribute);
			}
		} else {
			throw new InvalidDocumentException("Document is null");
		}
		return flag;
	}

	private boolean isValidAttribute(Attribute attribute) {
		if (attributeService.validate(attribute)) {
			return true;
		} else {
			throw new InvalidAtributeTypeException("Attribute already exists with a different type");
		}
	}

	public Map<String, Map<String, List<String>>> getDocumentStore() {
		return documentStore;
	}

	public List<String> searchDocumentStore(String key, String value) {
		List<String> result = new ArrayList<>();
		if (documentStore.get(key) != null) {
			Map<String, List<String>> map = documentStore.get(key);
			if (map.get(value) != null) {
				result = map.get(value);
			}
		}
		return result;
	}

}
