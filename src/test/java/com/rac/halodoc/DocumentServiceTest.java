package com.rac.halodoc;

import java.util.ArrayList;
import java.util.List;

import com.rac.halodoc.exception.InvalidAtributeTypeException;
import com.rac.halodoc.model.Attribute;
import com.rac.halodoc.model.Document;
import com.rac.halodoc.service.DocumentService;
import com.rac.halodoc.util.AttributeBuilder;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DocumentServiceTest extends TestCase {
	private DocumentService documentService;

	public DocumentServiceTest(String testName) {
		super(testName);
		documentService = documentService.getInstance();
	}

	public static Test suite() {
		return new TestSuite(DocumentServiceTest.class);
	}

	public void testConflictAttributeDocumentInsert() {
		Document document;

		document = new Document();
		List<Attribute> attributes = new ArrayList<>();
		attributes.add(AttributeBuilder.buildAttribute("population_level", "10"));
		attributes.add(AttributeBuilder.buildAttribute("population", "25"));
		document.setKey("Bangalore");
		document.setAttributes(attributes);
		assertTrue(documentService.insertDocument(document));
		
		document = new Document();
		attributes = new ArrayList<>();
		attributes.add(AttributeBuilder.buildAttribute("population_level", "10"));
		attributes.add(AttributeBuilder.buildAttribute("population", "25 million")); //invalid type
		document.setKey("Bangalore");
		
		document.setAttributes(attributes);
		
		try {
			documentService.insertDocument(document);
			fail();
		}
		catch(InvalidAtributeTypeException e) {
			assertTrue(true);
		}
	}

}
