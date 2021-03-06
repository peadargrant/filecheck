/* 
 * Copyright (C) 2014 Peadar Grant
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.peadargrant.filecheck.core.checks;

import com.peadargrant.filecheck.core.checker.CheckImplementation;
import com.peadargrant.filecheck.core.checker.CheckResult;
import com.peadargrant.filecheck.core.checker.Outcome;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Peadar Grant <peadargrant@gmail.com>
 */
public class XPathEvaluation extends CheckImplementation {

    private DocumentBuilder db;
    private XPathExpression xpe;

    @Override
    public void runCheck(InputStream input, CheckResult cr) {

        try {

            if (this.db == null) {
                // Document builder factory
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                this.db = dbf.newDocumentBuilder();
            }

            if (this.xpe == null) {
                // XPath factory 
                XPathFactory xpf = XPathFactory.newInstance();
                XPath xp = xpf.newXPath();

                // Compile the XPath expression
                xpe = xp.compile(this.stringParameters.get("expression"));
            }

            Document doc = db.parse(input);

            String outputString = (String) xpe.evaluate(doc, XPathConstants.STRING);

            cr.setResultText(outputString);

            if (outputString.length() > 0) {
                cr.setOutcome(Outcome.PASS);
            } else {
                cr.setOutcome(Outcome.FAIL);
            }
        } catch (SAXException e) {
            cr.setResultText("(document not well-formed)");
            cr.setOutcome(Outcome.FAIL);
        } catch (IOException e) {
            cr.setResultText("(I/O error during check)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
        } catch (XPathExpressionException e) {
            cr.setResultText("(XPath expression error)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
        } catch (ParserConfigurationException e) {
            cr.setDescription("(parser configuration error)");
            cr.setOutcome(Outcome.CHECK_FAILURE);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XPath: ");
        sb.append(this.stringParameters.get("expression"));
        return sb.toString();
    }

}
