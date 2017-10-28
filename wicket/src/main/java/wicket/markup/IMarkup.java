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
package wicket.markup;

/**
 * Holds markup as a resource (the stream that the markup came from) and a list
 * of MarkupElements (the markup itself).
 * 
 * @see MarkupElement
 * @see ComponentTag
 * @see wicket.markup.RawMarkup
 * 
 * @author Jonathan Locke
 * @author Juergen Donnerstag
 */
public abstract interface IMarkup
{
	/** Placeholder that indicates no markup */
	public static final Markup NO_MARKUP = new Markup();

	/**
	 * Gets the markup encoding. A markup encoding may be specified in a markup
	 * file with an XML encoding specifier of the form &lt;?xml ...
	 * encoding="..." ?&gt;.
	 * 
	 * @return Encoding, or null if not found.
	 */
	String getEncoding();

	/**
	 * Gets the resource that contains this markup
	 * 
	 * @return The resource where this markup came from
	 */
	MarkupResourceStream getResource();

	/**
	 * Get the wicket namespace valid for this specific markup
	 * 
	 * @return wicket namespace
	 */
	String getWicketNamespace();

	/**
	 * Return the XML declaration string, in case if found in the markup.
	 * 
	 * @return Null, if not found.
	 */
	String getXmlDeclaration();

	/**
	 * @return String representation of markup list
	 */
	String toString();
}