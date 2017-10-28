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
package wicket.extensions.markup.html.repeater.data.table;

import wicket.Component;
import wicket.MarkupContainer;
import wicket.model.Model;

/**
 * A column that does not have a header
 * 
 * @param <T>
 * @author Igor Vaynberg
 */
public abstract class HeaderlessColumn<T> extends AbstractColumn<T>
{
	/**
	 * Construct.
	 */
	public HeaderlessColumn()
	{
		super(new Model<String>("&nbsp;"));
	}

	@Override
	public Component<String> getHeader(MarkupContainer parent, String componentId)
	{
		return super.getHeader(parent, componentId).setEscapeModelStrings(false);
	}
}