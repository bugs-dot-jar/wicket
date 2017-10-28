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
package wicket.markup.parser.filter;

import wicket.MarkupContainer;
import wicket.markup.IAlternateParentProvider;
import wicket.markup.html.WebPage;
import wicket.markup.html.border.Border;

/**
 * 
 * @author pz65n8
 */
public abstract class AbstractTest14WebPage extends WebPage implements IAlternateParentProvider
{
	private Border border;

	/**
	 * 
	 */
	public AbstractTest14WebPage()
	{
		// Create border and add it to the page
		border = new HeaderSectionBorder_2(this, "border");
	}

	/**
	 * 
	 * @see wicket.markup.IAlternateParentProvider#getAlternateParent(Class childClass, String childId)
	 */
	public MarkupContainer getAlternateParent(final Class childClass, final String childId)
	{
		return (this.border == null ? this : this.border);
	}
}