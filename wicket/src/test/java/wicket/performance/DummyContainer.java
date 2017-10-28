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
package wicket.performance;

import java.io.File;
import java.util.Random;

import wicket.MarkupContainer;
import wicket.markup.IMarkupCacheKeyProvider;
import wicket.markup.IMarkupResourceStreamProvider;
import wicket.markup.MarkupFragment;
import wicket.markup.html.WebMarkupContainer;
import wicket.util.resource.FileResourceStream;
import wicket.util.resource.IResourceStream;

/**
 * 
 * @author Juergen Donnerstag
 */
public class DummyContainer extends WebMarkupContainer
		implements
			IMarkupResourceStreamProvider,
			IMarkupCacheKeyProvider
{
	private static final long serialVersionUID = 1L;

	private File markupFile;

	private final Random random = new Random();

	/**
	 * Construct.
	 * 
	 * @param parent
	 * @param markupFile
	 */
	public DummyContainer(final MarkupContainer parent)
	{
		super(parent, "dummy");
	}

	/**
	 * 
	 * @param file
	 */
	public void setMarkupFile(final File file)
	{
		this.markupFile = file;
	}

	@Override
	public MarkupFragment getMarkupFragment()
	{
		return getAssociatedMarkup(true);
	}
	
	/**
	 * 
	 * @see wicket.markup.IMarkupResourceStreamProvider#getMarkupResourceStream(wicket.MarkupContainer,
	 *      java.lang.Class)
	 */
	public IResourceStream getMarkupResourceStream(final MarkupContainer container,
			final Class<? extends MarkupContainer> containerClass)
	{
		if (container.getClass() == containerClass)
		{
			return new FileResourceStream(new wicket.util.file.File(this.markupFile));
		}

		return null;
	}

	/**
	 * 
	 * @see wicket.markup.IMarkupCacheKeyProvider#getCacheKey(wicket.MarkupContainer,
	 *      java.lang.Class)
	 */
	public CharSequence getCacheKey(final MarkupContainer container,
			final Class<? extends MarkupContainer> containerClass)
	{
		// Disable caching
		return null;

		// Enable caching
		// return this.markupFile.getPath();

		// Some requests are cached, others are not
		// Note: The range must be significantly larger (2-10) than the number
		// of files which are scanned. The larger, the less likely it is that
		// a file is found in the cache
		// return String.valueOf(random.nextInt(1000));
	}
}