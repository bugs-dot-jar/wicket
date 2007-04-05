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
package wicket.util.convert;

import wicket.IConverterLocator;
import wicket.settings.IApplicationSettings;

/**
 * Factory that creates and configures instances of {@link IConverterLocator}.
 * The actual instance to use can be configured using
 * {@link IApplicationSettings#getConverterLocatorFactory()}.
 * 
 * @see ConverterLocatorFactory
 * 
 * @author Eelco Hillenius
 * @author Jonathan Locke
 */
public interface IConverterLocatorFactory
{
	/**
	 * Creates and returns a new instance of {@link IConverterLocator}.
	 * 
	 * @return A new {@link IConverterLocator} instance
	 */
	IConverterLocator newConverterLocator();
}
