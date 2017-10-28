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
package wicket.util.tester.apps_3;

import java.util.ArrayList;
import java.util.List;

import wicket.markup.html.WebPage;
import wicket.markup.html.form.Button;
import wicket.markup.html.form.Check;
import wicket.markup.html.form.CheckBoxMultipleChoice;
import wicket.markup.html.form.CheckGroup;
import wicket.markup.html.form.ChoiceRenderer;
import wicket.markup.html.form.DropDownChoice;
import wicket.markup.html.form.Form;
import wicket.markup.html.form.ListChoice;
import wicket.markup.html.form.ListMultipleChoice;
import wicket.markup.html.form.Radio;
import wicket.markup.html.form.RadioChoice;
import wicket.markup.html.form.RadioGroup;
import wicket.markup.html.list.ListItem;
import wicket.markup.html.list.ListView;
import wicket.model.CompoundPropertyModel;
import wicket.model.Model;
import wicket.util.tester.apps_1.Book;

/**
 * @author Ingram Chen
 * @param <T>
 */
public class ChoicePage<T> extends WebPage<T>
{
	private static final long serialVersionUID = 1L;

	/** test DropDownChoice */
	public Book dropDownChoice;

	/** test ListChoice */
	public Book listChoice;

	/** test RadioChoice */
	public Book radioChoice;

	/** test RadioChoice */
	public Book radioGroup;

	/** test CheckBoxMultipleChoice */
	public List<String> checkBoxMultipleChoice = new ArrayList<String>();

	/** test CheckGroup */
	public List<String> checkGroup = new ArrayList<String>();

	/** test ListMultipleChoice */
	public List<String> listMultipleChoice = new ArrayList<String>();

	/** test multiple button */
	public boolean anotherButtonPressed;

	/**
	 * Test page for FormTester.select()
	 * 
	 * @param candidateChoices
	 */
	public ChoicePage(List<Book> candidateChoices)
	{
		ChoiceRenderer<Book> bookChoiceRenderer = new ChoiceRenderer<Book>("name", "id");

		Form<ChoicePage> form = new Form<ChoicePage>(this, "choiceForm");

		form.setModel(new CompoundPropertyModel<ChoicePage>(this));

		// single select family
		new DropDownChoice<Book>(form, "dropDownChoice", candidateChoices, bookChoiceRenderer);
		new ListChoice<Book>(form, "listChoice", candidateChoices, bookChoiceRenderer)
				.setMaxRows(4);
		new RadioChoice<Book>(form, "radioChoice", candidateChoices, bookChoiceRenderer);
		newRadioGroup(form, candidateChoices);

		// mulitple select family
		new ListMultipleChoice<Book>(form, "listMultipleChoice", candidateChoices,
				bookChoiceRenderer).setMaxRows(4);
		new CheckBoxMultipleChoice<Book>(form, "checkBoxMultipleChoice", candidateChoices,
				bookChoiceRenderer);
		newCheckGroup(form, candidateChoices);
		new Button(form, "anotherButton")
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit()
			{
				anotherButtonPressed = true;
			}
		};
	}

	private CheckGroup newCheckGroup(Form parent, List<Book> candidateChoices)
	{
		CheckGroup checkGroupComponent = new CheckGroup(parent, "checkGroup");
		new ListView<Book>(checkGroupComponent, "loop", candidateChoices)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem item)
			{
				new Check<Book>(item, "check", new Model<Book>((Book)item.getModelObject()));
			}

		};
		return checkGroupComponent;
	}

	private RadioGroup newRadioGroup(Form parent, List<Book> candidateChoices)
	{
		RadioGroup radioGroupComponent = new RadioGroup(parent, "radioGroup");
		new ListView<Book>(radioGroupComponent, "loop", candidateChoices)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem item)
			{
				new Radio<Book>(item, "radio", new Model<Book>((Book)item.getModelObject()));
			}

		};
		return radioGroupComponent;
	}
}