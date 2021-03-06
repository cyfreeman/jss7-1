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

package org.mobicents.protocols.ss7.tools.simulator.level2;

import javolution.xml.XMLFormat;
import javolution.xml.stream.XMLStreamException;

import org.mobicents.protocols.ss7.indicator.NatureOfAddress;
import org.mobicents.protocols.ss7.indicator.NumberingPlan;

/**
 *
 * @author sergey vetyutnev
 *
 */
public class SccpConfigurationData {

    protected static final String REMOTE_ON_GT_MODE = "routeOnGtMode";
    protected static final String REMOTE_SPC = "remoteSpc";
    protected static final String REMOTE_SPC_2 = "remoteSpc2";
    protected static final String LOCAL_SPC = "localSpc";
    protected static final String LOCAL_SPC_2 = "localSpc2";
    protected static final String NI = "ni";
    protected static final String REMOTE_SSN = "remoteSsn";
    protected static final String HLR_SSN = "hlrSsn";
    protected static final String LOCAL_SSN = "localSsn";
    protected static final String GLOBAL_TITLE_TYPE = "globalTitleType";
    protected static final String ADDRESS_NATURE = "addressNature";
    protected static final String ADDRESS_NATURE_2 = "addressNature2";
    protected static final String NUMBERING_PLAN = "numberingPlan";
    protected static final String TRANSLATION_TYTE = "translationType";
    protected static final String CALLING_PARTY_ADDRESS_DIGITS = "callingPartyAddressDigits";

    private boolean routeOnGtMode;
    private int remoteSpc = 0;
    private int remoteSpc2 = 0;
    private int localSpc = 0;
    private int localSpc2 = 0;
    private int hlrSsn = 6;
    private int localSsn;
    private int remoteSsn;
    private int ni = 0;
    private GlobalTitleType globalTitleType = new GlobalTitleType(GlobalTitleType.VAL_TT_NP_ES_NOA);
    private NatureOfAddress natureOfAddress = NatureOfAddress.INTERNATIONAL;
    private NatureOfAddress natureOfAddress2 = NatureOfAddress.NATIONAL;
    private NumberingPlan numberingPlan = NumberingPlan.ISDN_MOBILE;
    private int translationType = 0;
    private String callingPartyAddressDigits = "";

    public boolean isRouteOnGtMode() {
        return routeOnGtMode;
    }

    public void setRouteOnGtMode(boolean routeOnGtMode) {
        this.routeOnGtMode = routeOnGtMode;
    }

    public int getRemoteSpc() {
        return remoteSpc;
    }

    public int getRemoteSpc2() {
        return remoteSpc2;
    }

    public void setRemoteSpc(int remoteSpc) {
        this.remoteSpc = remoteSpc;
    }

    public void setRemoteSpc2(int remoteSpc2) {
        this.remoteSpc2 = remoteSpc2;
    }

    public int getLocalSpc() {
        return localSpc;
    }

    public int getLocalSpc2() {
        return localSpc2;
    }

    public void setLocalSpc(int localSpc) {
        this.localSpc = localSpc;
    }

    public void setLocalSpc2(int localSpc2) {
        this.localSpc2 = localSpc2;
    }

    public int getHLRSsn() {
        return hlrSsn;
    }

    public void setHLRSsn(int hlrSsn) {
        this.hlrSsn = hlrSsn;
    }

    public int getLocalSsn() {
        return localSsn;
    }

    public void setLocalSsn(int localSsn) {
        this.localSsn = localSsn;
    }

    public int getRemoteSsn() {
        return remoteSsn;
    }

    public void setRemoteSsn(int remoteSsn) {
        this.remoteSsn = remoteSsn;
    }

    public int getNi() {
        return ni;
    }

    public void setNi(int ni) {
        this.ni = ni;
    }

    public GlobalTitleType getGlobalTitleType() {
        return globalTitleType;
    }

    public void setGlobalTitleType(GlobalTitleType globalTitleType) {
        this.globalTitleType = globalTitleType;
    }

    public NatureOfAddress getNatureOfAddress() {
        return natureOfAddress;
    }

    public NatureOfAddress getNatureOfAddress2() {
        return natureOfAddress2;
    }

    public void setNatureOfAddress(NatureOfAddress natureOfAddress) {
        this.natureOfAddress = natureOfAddress;
    }

    public void setNatureOfAddress2(NatureOfAddress natureOfAddress) {
        this.natureOfAddress2 = natureOfAddress;
    }

    public NumberingPlan getNumberingPlan() {
        return numberingPlan;
    }

    public void setNumberingPlan(NumberingPlan numberingPlan) {
        this.numberingPlan = numberingPlan;
    }

    public int getTranslationType() {
        return translationType;
    }

    public void setTranslationType(int translationType) {
        this.translationType = translationType;
    }

    public String getCallingPartyAddressDigits() {
        return callingPartyAddressDigits;
    }

    public void setCallingPartyAddressDigits(String callingPartyAddressDigits) {
        this.callingPartyAddressDigits = callingPartyAddressDigits;
    }

    protected static final XMLFormat<SccpConfigurationData> XML = new XMLFormat<SccpConfigurationData>(
            SccpConfigurationData.class) {

        public void write(SccpConfigurationData sccp, OutputElement xml) throws XMLStreamException {
            xml.setAttribute(REMOTE_ON_GT_MODE, sccp.isRouteOnGtMode());
            xml.setAttribute(REMOTE_SPC, sccp.getRemoteSpc());
            xml.setAttribute(REMOTE_SPC_2, sccp.getRemoteSpc2());
            xml.setAttribute(LOCAL_SPC, sccp.getLocalSpc());
            xml.setAttribute(LOCAL_SPC_2, sccp.getLocalSpc2());
            xml.setAttribute(NI, sccp.getNi());
            xml.setAttribute(REMOTE_SSN, sccp.getRemoteSsn());
            xml.setAttribute(HLR_SSN, sccp.getHLRSsn());
            xml.setAttribute(LOCAL_SSN, sccp.getLocalSsn());
            xml.setAttribute(TRANSLATION_TYTE, sccp.getTranslationType());

            xml.add(sccp.getGlobalTitleType().toString(), GLOBAL_TITLE_TYPE, String.class);
            xml.add(sccp.getNatureOfAddress().toString(), ADDRESS_NATURE, String.class);
            xml.add(sccp.getNatureOfAddress2().toString(), ADDRESS_NATURE_2, String.class);
            xml.add(sccp.getNumberingPlan().toString(), NUMBERING_PLAN, String.class);
            xml.add(sccp.getCallingPartyAddressDigits(), CALLING_PARTY_ADDRESS_DIGITS, String.class);
        }

        public void read(InputElement xml, SccpConfigurationData sccp) throws XMLStreamException {
            sccp.setRouteOnGtMode(xml.getAttribute(REMOTE_ON_GT_MODE).toBoolean());
            sccp.setRemoteSpc(xml.getAttribute(REMOTE_SPC).toInt());
            sccp.setRemoteSpc2(xml.getAttribute(REMOTE_SPC_2).toInt());
            sccp.setLocalSpc(xml.getAttribute(LOCAL_SPC).toInt());
            sccp.setLocalSpc2(xml.getAttribute(LOCAL_SPC_2).toInt());
            sccp.setNi(xml.getAttribute(NI).toInt());
            sccp.setRemoteSsn(xml.getAttribute(REMOTE_SSN).toInt());
            sccp.setHLRSsn(xml.getAttribute(HLR_SSN).toInt());
            sccp.setLocalSsn(xml.getAttribute(LOCAL_SSN).toInt());
            sccp.setTranslationType(xml.getAttribute(TRANSLATION_TYTE).toInt());

            String gtt = (String) xml.get(GLOBAL_TITLE_TYPE, String.class);
            sccp.setGlobalTitleType(GlobalTitleType.createInstance(gtt));
            String an = (String) xml.get(ADDRESS_NATURE, String.class);
            sccp.setNatureOfAddress(NatureOfAddress.valueOf(an));
            String an2 = (String) xml.get(ADDRESS_NATURE_2, String.class);
            sccp.setNatureOfAddress2(NatureOfAddress.valueOf(an2));
            String np = (String) xml.get(NUMBERING_PLAN, String.class);
            sccp.setNumberingPlan(NumberingPlan.valueOf(np));
            sccp.setCallingPartyAddressDigits((String) xml.get(CALLING_PARTY_ADDRESS_DIGITS, String.class));
        }
    };

}
