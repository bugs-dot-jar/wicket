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
package wicket.ajax.markup.html.ajaxLink;

import wicket.MarkupContainer;
import wicket.ajax.AjaxRequestTarget;
import wicket.ajax.markup.html.AjaxLink;
import wicket.markup.IAlternateParentProvider;
import wicket.markup.html.WebPage;
import wicket.markup.html.basic.Label;
import wicket.markup.html.border.BoxBorder;

/**
 * 
 */
public class AjaxPage2 extends WebPage implements IAlternateParentProvider
{
	private static final long serialVersionUID = 1L;

	private Label ajaxLabel;
	private BoxBorder myBorder;

	/**
	 * Construct.
	 */
	public AjaxPage2()
	{
		super();

		myBorder = new BoxBorder(this, "pageLayout");

		ajaxLabel = new Label(myBorder, "ajaxLabel", "AAAAAAA");
		ajaxLabel.setOutputMarkupId(true);

		new AjaxLink(myBorder, "ajaxLink")
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(final AjaxRequestTarget target)
			{
				Label ajaxLabel2 = new Label(ajaxLabel.getParent(), "ajaxLabel", "BBBBBBB");
				ajaxLabel2.setOutputMarkupId(true);
				if (target != null)
				{
					target.addComponent(ajaxLabel2, "ajaxLabel");
				}
			}
		};
	}

	/**
	 * 
	 * @see wicket.markup.IAlternateParentProvider#getAlternateParent(Class childClass, String childId)
	 */
	public MarkupContainer getAlternateParent(final Class childClass, final String childId)
	{
		return (this.myBorder == null ? this : this.myBorder);
	}
}