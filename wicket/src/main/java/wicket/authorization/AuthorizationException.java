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
package wicket.authorization;

import wicket.WicketRuntimeException;

/**
 * Base class for exceptions thrown as a result of authorization failure.
 */
public abstract class AuthorizationException extends WicketRuntimeException
{
	private static final long serialVersionUID = 1L;

	/**
	 * Construct.
	 */
	public AuthorizationException()
	{
		super();
	}

	/**
	 * 
	 * Construct.
	 * 
	 * @param message
	 */
	public AuthorizationException(String message)
	{
		super(message);
	}

	/**
	 * Construct.
	 * 
	 * @param message
	 * @param cause
	 */
	public AuthorizationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Construct.
	 * 
	 * @param cause
	 */
	public AuthorizationException(Throwable cause)
	{
		super(cause);
	}
}