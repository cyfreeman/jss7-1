/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.protocols.ss7.sccp.impl.oam;

/**
 * Declares static messages used by RouterImpl
 * 
 * @author amit bhayani
 * 
 */
public interface SccpOAMMessage {

	public static final String INVALID_COMMAND = "Invalid Command";

	public static final String RULE_ALREADY_EXIST = "Rule already exist";

	public static final String INVALID_MASK = "Invalid Mask";

	public static final String RULE_DOESNT_EXIST = "Rule doesn't exist";

	public static final String RULE_SUCCESSFULLY_ADDED = "Rule successfully added";

	public static final String RULE_SUCCESSFULLY_REMOVED = "Rule successfully removed";

	public static final String ADDRESS_ALREADY_EXIST = "Address already exist";

	public static final String ADDRESS_DOESNT_EXIST = "Address doesn't exist";

	public static final String ADDRESS_SUCCESSFULLY_ADDED = "Address successfully added";

	public static final String ADDRESS_SUCCESSFULLY_REMOVED = "Address successfully removed";

	public static final String SERVER_ERROR = "Server Error";

	public static final String NO_PRIMARY_ADDRESS = "No primary address defined for id=%d";

	public static final String NO_BACKUP_ADDRESS = "No backup address defined for id=%d";

	public static final String RSPC_ALREADY_EXIST = "Remote Signaling Pointcode already exist";

	public static final String RSPC_SUCCESSFULLY_ADDED = "Remote Signaling Pointcode successfully added";

	public static final String RSS_ALREADY_EXIST = "Remote Subsystem already exist";

	public static final String RSS_SUCCESSFULLY_ADDED = "Remote Subsystem successfully added";
}
