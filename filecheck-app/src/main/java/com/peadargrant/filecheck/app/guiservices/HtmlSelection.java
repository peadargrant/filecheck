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
package com.peadargrant.filecheck.app.guiservices;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class HtmlSelection implements Transferable {

  private static List<DataFlavor> flavors = new ArrayList<>();

  static {
    try {
      flavors.add(DataFlavor.stringFlavor);
      flavors.add(new DataFlavor("text/html;class=java.lang.String"));
      flavors.add(new DataFlavor("text/html;class=java.io.Reader"));
      flavors.add(new DataFlavor("text/html;charset=unicode;class=java.io.InputStream"));
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
  }

  private String html;

  public HtmlSelection(String html) {
    this.html = html;
  }

  @Override
  public DataFlavor[] getTransferDataFlavors() {
    return flavors.toArray(new DataFlavor[flavors.size()]);
  }

  @Override
  public boolean isDataFlavorSupported(DataFlavor flavor) {
    return flavors.contains(flavor);
  }

  @Override
  public Object getTransferData(DataFlavor flavor)
    throws UnsupportedFlavorException {
    if (flavor.equals(DataFlavor.stringFlavor)) {
      return html;
    } else if (String.class.equals(flavor.getRepresentationClass())) {
      return html;
    } else if (Reader.class.equals(flavor.getRepresentationClass())) {
      return new StringReader(html);
    } else if (InputStream.class.equals(flavor.getRepresentationClass())) {
      return new StringReader(html);
    }
    throw new UnsupportedFlavorException(flavor);
  }
}