/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2013, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package org.mobicents.protocols.ss7.tools.simulator.tests.cap;

import javolution.xml.XMLFormat;
import javolution.xml.stream.XMLStreamException;

import org.mobicents.protocols.ss7.tools.simulator.common.CapApplicationContextScf;

/**
 *
 * @author sergey vetyutnev
 *
 */
public class TestCapScfConfigurationData {

    private static final String CAP_APPLICATION_CONTEXT = "capApplicationContext";

    private CapApplicationContextScf capApplicationContext = new CapApplicationContextScf(
            CapApplicationContextScf.VAL_CAP_V4_capscf_ssfGeneric);

    public CapApplicationContextScf getCapApplicationContext() {
        return capApplicationContext;
    }

    public void setCapApplicationContext(CapApplicationContextScf capApplicationContext) {
        this.capApplicationContext = capApplicationContext;
    }

    protected static final XMLFormat<TestCapScfConfigurationData> XML = new XMLFormat<TestCapScfConfigurationData>(
            TestCapScfConfigurationData.class) {

        public void write(TestCapScfConfigurationData srv, OutputElement xml) throws XMLStreamException {
            xml.add(srv.capApplicationContext.toString(), CAP_APPLICATION_CONTEXT, String.class);
        }

        public void read(InputElement xml, TestCapScfConfigurationData srv) throws XMLStreamException {
            String cpv = (String) xml.get(CAP_APPLICATION_CONTEXT, String.class);
            srv.capApplicationContext = CapApplicationContextScf.createInstance(cpv);
        }
    };

}
