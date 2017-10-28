/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wicket.protocol.http;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import wicket.protocol.http.documentvalidation.HtmlDocumentValidator;
import wicket.protocol.http.documentvalidation.Tag;
import wicket.protocol.http.documentvalidation.TextContent;
import wicket.util.tester.WicketTester;

/**
 * Simple tester that demonstrates the mock http tester code (and checks that it
 * is working)
 * 
 * @author Chris Turner
 */
public class WicketTagPanelTest extends TestCase
{
	private static final Log log = LogFactory.getLog(WicketTagPanelTest.class);

	private WicketTester tester;

	/**
	 * Create the test.
	 * 
	 * @param name
	 *            The test name
	 */
	public WicketTagPanelTest(String name)
	{
		super(name);
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		tester = new WicketTester(WicketPanelPage.class);
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePage() throws Exception
	{
		// Do the processing
		tester.setupRequestAndResponse();
		tester.processRequestCycle();

		// Validate the document
		String document = tester.getServletResponse().getDocument();
		log.info(document);
		assertTrue(validatePage1(document));
	}

	/**
	 * Validate page 2 of the paged table.
	 * 
	 * @param document
	 *            The document
	 * @return The validation result
	 */
	private boolean validatePage1(String document)
	{
		HtmlDocumentValidator validator = new HtmlDocumentValidator();
		Tag html = new Tag("html");
		Tag body = new Tag("body");
		html.addExpectedChild(body);
		body.addExpectedChild(new TextContent("\\s+"));
		Tag span = new Tag("span");
		body.addExpectedChild(span);
		Tag wicket = new Tag("wicket:panel");
		span.addExpectedChild(wicket);

		wicket.addExpectedChild(new TextContent("\\s*Panel Content"));

		validator.addRootElement(html);
		return validator.isDocumentValid(document);
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePageWicketTagRemoved() throws Exception
	{
		// Remove wicket tags from output
		tester.getApplication().getMarkupSettings().setStripWicketTags(true);
		tester.setupRequestAndResponse();
		tester.processRequestCycle();

		// Validate the document
		String document = tester.getServletResponse().getDocument();
		log.info(document);
		assertTrue(validatePage2(document));
	}

	/**
	 * Validate page 2 of the paged table.
	 * 
	 * @param document
	 *            The document
	 * @return The validation result
	 */
	private boolean validatePage2(String document)
	{
		HtmlDocumentValidator validator = new HtmlDocumentValidator();
		Tag html = new Tag("html");
		Tag body = new Tag("body");
		body.addExpectedChild(new TextContent("\\s+"));
		html.addExpectedChild(body);
		Tag span = new Tag("span");
		body.addExpectedChild(span);

		span.addExpectedChild(new TextContent("\\s*Panel Content"));

		validator.addRootElement(html);
		return validator.isDocumentValid(document);
	}
}