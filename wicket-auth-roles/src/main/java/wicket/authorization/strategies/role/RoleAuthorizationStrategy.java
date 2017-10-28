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
package wicket.authorization.strategies.role;

import wicket.authorization.strategies.CompoundAuthorizationStrategy;
import wicket.authorization.strategies.role.annotations.AnnotationsRoleAuthorizationStrategy;
import wicket.authorization.strategies.role.metadata.MetaDataRoleAuthorizationStrategy;

/**
 * Compound strategy that works with roles.
 * 
 * @author Eelco Hillenius
 */
public class RoleAuthorizationStrategy extends CompoundAuthorizationStrategy
{
	/**
	 * Construct.
	 * 
	 * @param roleCheckingStrategy
	 *            the role checking strategy
	 */
	public RoleAuthorizationStrategy(final IRoleCheckingStrategy roleCheckingStrategy)
	{
		add(new AnnotationsRoleAuthorizationStrategy(roleCheckingStrategy));
		add(new MetaDataRoleAuthorizationStrategy(roleCheckingStrategy));
	}
}